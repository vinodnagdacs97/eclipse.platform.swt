package org.eclipse.swt.examples.paint;
/*
 * (c) Copyright IBM Corp. 2000, 2001.
 * All Rights Reserved
 */
import org.eclipse.swt.events.*;import org.eclipse.swt.graphics.*;import org.eclipse.swt.widgets.*;
/** * Manages a simple drawing surface. */
public class PaintSurface implements MouseListener, MouseMoveListener,	PaintListener, ControlListener {
	private Point currentPosition = new Point(0, 0);
	private Canvas       paintCanvas;	private PaintStatus  paintStatus;	private PaintSession paintSession;	private Image        image;	private Rectangle    visibleRect;	private Rectangle    imageRect;	private GC           displayGC;    // the GC used for drawing to the display	private GC           rubberbandGC; // the GC used exclusively for rubberband drawing	private GC           imageGC;      // the GC used as a permanent backing store	private Color        rubberbandFGColor, rubberbandBGColor;		private MetaContainer rubberband; // the active rubberband selection	private Object         rubberbandState; // the active rubberband selection previewing state	private int rubberbandHiddenNestingCount; // always >= 0, if > 0 rubberband has been hidden	/**	 * Constructs a PaintSurface.	 * 	 * @param paintCanvas the Canvas object in which to render	 * @param paintStatus the PaintStatus object to use for providing user feedback	 */
	public PaintSurface(Canvas paintCanvas, PaintStatus paintStatus) {		this.paintCanvas = paintCanvas;		this.paintStatus = paintStatus;		/* Set up the drawing surface */		visibleRect = paintCanvas.getClientArea();		imageRect = paintCanvas.getDisplay().getClientArea();		image = new Image(paintCanvas.getDisplay(), imageRect.width, imageRect.height);		imageGC = new GC(image);		displayGC = new GC(paintCanvas);		rubberbandGC = new GC(paintCanvas);		rubberbandGC.setXORMode(true);		rubberbandFGColor = new Color(paintCanvas.getDisplay(), 255, 255, 255);		rubberbandBGColor = new Color(paintCanvas.getDisplay(), 127, 127, 127);		rubberbandGC.setForeground(rubberbandFGColor);		rubberbandGC.setBackground(rubberbandBGColor);		rubberbandHiddenNestingCount = 0;		rubberbandState = null;				rubberband = new MetaContainer();		/* Initialize the session */		setPaintSession(null);		/* Add our listeners */		paintCanvas.addMouseListener(this);		paintCanvas.addMouseMoveListener(this);		paintCanvas.addPaintListener(this);		paintCanvas.addControlListener(this);		/* Set up the paint canvas scroll bars */		ScrollBar horizontal = paintCanvas.getHorizontalBar();		horizontal.setVisible(true);		horizontal.addSelectionListener(new SelectionAdapter() {			public void widgetSelected(SelectionEvent event) {				scrollHorizontally((ScrollBar)event.widget);			}		});		ScrollBar vertical = paintCanvas.getVerticalBar();		vertical.setVisible(true);		vertical.addSelectionListener(new SelectionAdapter() {			public void widgetSelected(SelectionEvent event) {				scrollVertically((ScrollBar)event.widget);			}		});		handleResize();	}		/**	 * Disposes of the PaintSurface's resources.	 */	public void dispose() {		imageGC.dispose();		displayGC.dispose();		rubberbandGC.dispose();		rubberbandFGColor.dispose();		rubberbandBGColor.dispose();		image.dispose();			}	/**	 * Called when we must grab focus.	 */	public void setFocus()  {		paintCanvas.setFocus();	}	/**
	 * Returns the display Graphics Context associated with this surface.	 * <p>	 * Use this GC to draw rubberband line and other temporary entities to the screen.	 * They will not be committed to the backing store and hence will not be refreshed	 * should the paint surface become obscured.	 * </p>
	 * 
	 * @return the display GC associated with this surface
	 */
	public GC getDisplayGC() {
		return displayGC;
	}
	/**	 * Returns the image Graphics Context associated with this surface.	 * <p>	 * Use this GC to draw entities that are to be committed to the backing store.	 * Anything drawn in this manner will persist and be refreshed as appropriate.	 * </p>	 * 	 * @return the image GC associated with this surface	 */	public GC getImageGC() {		return imageGC;	}	/**	 * Returns the offset to be added to x and y coordinates in order to transform	 * virtual paint surface coordinates into Display coordinates	 *	 * @return the offset	 */	public Point getDisplayOffset() {		return new Point(- visibleRect.x, - visibleRect.y);	}	/**	 * Returns the offset to be added to x and y coordinates in order to transform	 * virtual paint surface coordinates into Image coordinates	 *	 * @return the offset	 */	public Point getImageOffset() {		return new Point(- imageRect.x, - imageRect.y);	}	/**
	 * Sets the current paint session.	 * <p>
	 * If oldPaintSession != paintSession calls oldPaintSession.end()	 * and paintSession.begin()	 * </p>	 * 
	 * @param paintSession the paint session to activate; null to disable all sessions
	 */
	public void setPaintSession(PaintSession paintSession) {
		if (this.paintSession != null) {			if (this.paintSession == paintSession) return;
			this.paintSession.endSession();		}
		this.paintSession = paintSession;
		paintStatus.clear();		if (paintSession != null) {			paintStatus.setAction(paintSession.getDisplayName());			paintSession.beginSession();		} else {			paintStatus.setAction(PaintPlugin.getResourceString("tool.Null.displayname"));			paintStatus.setMessage(PaintPlugin.getResourceString("session.Null.message"));		}	}

	/**
	 * Returns the current paint session.
	 * 
	 * @return the current paint session, null if none is active
	 */
	public PaintSession getPaintSession() {
		return paintSession;
	}
	/**	 * Returns the current paint status object.	 * 	 * @return the current paint status object	 */	public PaintStatus getPaintStatus() {		return paintStatus;	}	/**	 * Returns the current paint tool.	 * 	 * @return the current paint tool, null if none is active (though some other session	 *         might be)	 */	public PaintTool getPaintTool() {		return (paintSession != null && paintSession instanceof PaintTool) ?			(PaintTool)paintSession : null;	}	/**	 * Returns the current position in an interactive operation.	 *	 * @return the last known position of the pointer	 */	public Point getCurrentPosition() {		return currentPosition;	}		/**	 * Redraws a specified rectangular area using the backing store	 * 	 * @param x the left X virtual coordinate of the region	 * @param y the top Y virtual coordinate of the region	 * @param width the width of the region	 * @param height the height of the region	 * @see getImageGC()	 */	public void redrawArea(int x, int y, int width, int height) {		// Clip to image and screen [computes intersection of the rectangles]		final int clipX = Math.max(imageRect.x, visibleRect.x);		if (x < clipX) {			width -= clipX - x;			x = clipX;		}		final int clipY = Math.max(imageRect.y, visibleRect.y);		if (y < clipY) {			height -= clipY - y;			y = clipY;		}		final int clipWidth = Math.min(imageRect.width, visibleRect.width) + clipX - x;		if (width > clipWidth) width = clipWidth;		final int clipHeight = Math.min(imageRect.height, visibleRect.height) + clipY - y;		if (height > clipHeight) height = clipHeight;		if (width < 0 || height < 0) return;				// Redraw the region		hideRubberband();		displayGC.drawImage(image, x - imageRect.x, y - imageRect.y, width, height,			x - visibleRect.x, y - visibleRect.y, width, height);		showRubberband();	}
	/**	 * Draws a Meta object to the screen and to the backing store permanently.	 * 	 * @param object the object to draw onscreen	 */	public void drawMeta(Meta object) {		object.draw(getImageGC(), getImageOffset());		object.draw(getDisplayGC(), getDisplayOffset());	}	/**	 * Adds a Meta object to the active rubberband selection.	 * <p>	 * This object will be drawn to the screen as a preview and refreshed appropriately	 * until the selection is either cleared or committed.	 * </p>	 * 	 * @param object the object to add to the selection	 */	public void addRubberbandSelection(Meta object) {		if (isRubberbandHidden()) {			Assert.assert(rubberbandState == null, "rubberbandState == null");			rubberband.add(object);		} else {			rubberbandState = rubberband.addAndPreview(object, rubberbandGC,				getDisplayOffset(), rubberbandState);		}	}	/**	 * Clears the active rubberband selection.	 * <p>	 * Erases any rubberband objects on the screen then clears the selection.	 * </p>	 */	public void clearRubberbandSelection() {		if (! isRubberbandHidden()) {			rubberband.erasePreview(rubberbandGC, getDisplayOffset(), rubberbandState);			rubberbandState = null;		}		rubberband.clear();	}	/**	 * Commits the active rubberband selection.	 * <p>	 * Redraws any rubberband objects on the screen as permanent objects then clears the selection.	 * </p>	 */	public void commitRubberbandSelection() {		if (! isRubberbandHidden()) {			rubberband.erasePreview(displayGC, getDisplayOffset(), rubberbandState);			rubberbandState = null;		}		drawMeta(rubberband);		rubberband.clear();	}		/**	 * Hides the rubberband (but does not eliminate it).	 * <p>	 * Increments by one the rubberband "hide" nesting count.  The rubberband	 * is hidden from view (but remains active) if it wasn't already hidden.	 * </p>	 */	public void hideRubberband() {		if (rubberbandHiddenNestingCount++ <= 0) {			rubberband.erasePreview(rubberbandGC, getDisplayOffset(), rubberbandState);			rubberbandState = null;		}	}			/**	 * Shows (un-hides) the rubberband.	 * <p>	 * Decrements by one the rubberband "hide" nesting count.  The rubberband	 * is only made visible when showRubberband() has been called once for each	 * previous hideRubberband().  It is not permitted to call showRubberband() if	 * the rubber band is not presently hidden.	 * </p>	 */	public void showRubberband() {		Assert.assert(rubberbandHiddenNestingCount > 0, "rubberbandHiddenNestingCount > 0");		if (--rubberbandHiddenNestingCount == 0) {			Assert.assert(rubberbandState == null, "rubberbandState == null");			rubberbandState = rubberband.drawPreview(rubberbandGC, getDisplayOffset());		}	}		/**	 * Determines if the rubberband is hidden.	 * 	 * @return true iff the rubber is hidden	 */	public boolean isRubberbandHidden() {		return rubberbandHiddenNestingCount > 0;	}	/**	 * Displays the current position in the status bar.	 */	public void showCurrentPositionStatus() {		paintStatus.setCoord(currentPosition);	}	/**	 * Displays the current position in the status bar.	 */	public void showCurrentRangeStatus(Point anchorPosition) {		paintStatus.setCoordRange(anchorPosition, currentPosition);	}
	/**
	 * Handles a mouseDown event.
	 * 
	 * @param event the mouse event detail information
	 */
	public void mouseDown(MouseEvent event) {		processMouseEventCoordinates(event);		if (paintSession != null) paintSession.mouseDown(event);
	}

	/**
	 * Handles a mouseUp event.
	 * 
	 * @param event the mouse event detail information
	 */
	public void mouseUp(MouseEvent event) {
		processMouseEventCoordinates(event);		if (paintSession != null) paintSession.mouseUp(event);
	}

	/**
	 * Handles a mouseDoubleClick event.
	 * 
	 * @param event the mouse event detail information
	 */
	public void mouseDoubleClick(MouseEvent event) {
		processMouseEventCoordinates(event);		if (paintSession != null) paintSession.mouseDoubleClick(event);
	}
	
	/**
	 * Handles a mouseMove event.
	 * 
	 * @param event the mouse event detail information
	 */
	public void mouseMove(MouseEvent event) {
		processMouseEventCoordinates(event);		if (paintSession != null) paintSession.mouseMove(event);
	}	/**	 * Handles a paintControl event	 * Refresh a chunk of screen real-estate.	 * 	 * @param event the paint event detail information	 */	public void paintControl(PaintEvent event) {		hideRubberband();		displayGC.drawImage(image,			event.x + visibleRect.x - imageRect.x, event.y + visibleRect.y - imageRect.y,			event.width, event.height, event.x, event.y, event.width, event.height);		showRubberband();	}	/**	 * Handles a resize event	 * 	 * @param event the resize event detail information	 */	public void controlResized(ControlEvent event) {		handleResize();	}	/**	 * Handles a location change event	 * 	 * @param event the move event detail information	 */	public void controlMoved(ControlEvent event) {	}	/**	 * Handles a horizontal scroll event	 * 	 * @param scrollbar the horizontal scroll bar that posted this event	 */	public void scrollHorizontally(ScrollBar scrollBar) {		if (image == null) return;		if (imageRect.width > visibleRect.width) {			final int oldx = visibleRect.x;			visibleRect.x = Math.min(scrollBar.getSelection(), imageRect.width - visibleRect.width);			paintCanvas.scroll(Math.max(oldx - visibleRect.x, 0), 0, Math.max(visibleRect.x - oldx, 0), 0,				visibleRect.width, visibleRect.height, false);		}	}	/**	 * Handles a vertical scroll event	 * 	 * @param scrollbar the vertical scroll bar that posted this event	 */	public void scrollVertically(ScrollBar scrollBar) {		if (image == null) return;		if (imageRect.height > visibleRect.height) {			final int oldy = visibleRect.y;			visibleRect.y = Math.min(scrollBar.getSelection(), imageRect.height - visibleRect.height);			paintCanvas.scroll(0, Math.max(oldy - visibleRect.y, 0), 0, Math.max(visibleRect.y - oldy, 0),				visibleRect.width, visibleRect.height, false);		}	}		/**	 * Handles resize events	 */	private void handleResize() {		visibleRect = paintCanvas.getClientArea();		ScrollBar horizontal = paintCanvas.getHorizontalBar();		if (horizontal != null) {			visibleRect.x = Math.min(horizontal.getSelection(), imageRect.width - visibleRect.width);			if (imageRect.width <= visibleRect.width) {				horizontal.setEnabled(false);				horizontal.setSelection(0);			} else {				final int max = imageRect.width - visibleRect.width;				horizontal.setEnabled(true);				horizontal.setValues(visibleRect.x, 0, imageRect.width, visibleRect.width,					8, visibleRect.width);			}		}		ScrollBar vertical = paintCanvas.getVerticalBar();		if (vertical != null) {			visibleRect.y = Math.min(vertical.getSelection(), imageRect.height - visibleRect.height);			if (imageRect.height <= visibleRect.height) {				vertical.setEnabled(false);				vertical.setSelection(0);			} else {				final int max = imageRect.height - visibleRect.height;				vertical.setEnabled(true);				vertical.setValues(visibleRect.y, 0, imageRect.height, visibleRect.height,					8, visibleRect.height);			}		}	}	/**	 * Virtualizes MouseEvent coordinates and stores the current position.	 */	private void processMouseEventCoordinates(MouseEvent event) {		currentPosition.x = event.x =			Math.min(Math.max(event.x + visibleRect.x, 0), visibleRect.x + visibleRect.width - 1);		currentPosition.y = event.y =			Math.min(Math.max(event.y + visibleRect.y, 0), visibleRect.y + visibleRect.height - 1);	}}
