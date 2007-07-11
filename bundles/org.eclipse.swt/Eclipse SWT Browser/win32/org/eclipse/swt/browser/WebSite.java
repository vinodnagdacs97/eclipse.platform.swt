/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.browser;

import org.eclipse.swt.*;
import org.eclipse.swt.internal.C;
import org.eclipse.swt.internal.ole.win32.*;
import org.eclipse.swt.ole.win32.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.internal.win32.*;

class WebSite extends OleControlSite {
	COMObject iDocHostUIHandler;
	COMObject iDocHostShowUI;
	COMObject iServiceProvider;
	COMObject iInternetSecurityManager;
	COMObject iOleCommandTarget;

	static final int OLECMDID_SHOWSCRIPTERROR = 40;
	static final String CONSUME_KEY = "org.eclipse.swt.OleFrame.ConsumeKey"; //$NON-NLS-1$

public WebSite(Composite parent, int style, String progId) {
	super(parent, style, progId);		
}

protected void createCOMInterfaces () {
	super.createCOMInterfaces();
	iDocHostUIHandler = new COMObject(new int[]{2, 0, 0, 4, 1, 5, 0, 0, 1, 1, 1, 3, 3, 2, 2, 1, 3, 2}){
		public int /*long*/ method0(int /*long*/[] args) {return QueryInterface(args[0], args[1]);}
		public int /*long*/ method1(int /*long*/[] args) {return AddRef();}
		public int /*long*/ method2(int /*long*/[] args) {return Release();}
		public int /*long*/ method3(int /*long*/[] args) {return ShowContextMenu((int)/*64*/args[0], args[1], args[2], args[3]);}
		public int /*long*/ method4(int /*long*/[] args) {return GetHostInfo(args[0]);}
		public int /*long*/ method5(int /*long*/[] args) {return ShowUI((int)/*64*/args[0], args[1], args[2], args[3], args[4]);}
		public int /*long*/ method6(int /*long*/[] args) {return HideUI();}
		public int /*long*/ method7(int /*long*/[] args) {return UpdateUI();}
		public int /*long*/ method8(int /*long*/[] args) {return EnableModeless((int)/*64*/args[0]);}
		public int /*long*/ method9(int /*long*/[] args) {return OnDocWindowActivate((int)/*64*/args[0]);}
		public int /*long*/ method10(int /*long*/[] args) {return OnFrameWindowActivate((int)/*64*/args[0]);}
		public int /*long*/ method11(int /*long*/[] args) {return ResizeBorder(args[0], args[1], (int)/*64*/args[2]);}
		public int /*long*/ method12(int /*long*/[] args) {return TranslateAccelerator(args[0], args[1], (int)/*64*/args[2]);}
		public int /*long*/ method13(int /*long*/[] args) {return GetOptionKeyPath(args[0], (int)/*64*/args[1]);}
		public int /*long*/ method14(int /*long*/[] args) {return GetDropTarget(args[0], args[1]);}
		public int /*long*/ method15(int /*long*/[] args) {return GetExternal(args[0]);}
		public int /*long*/ method16(int /*long*/[] args) {return TranslateUrl((int)/*64*/args[0], args[1], args[2]);}		
		public int /*long*/ method17(int /*long*/[] args) {return FilterDataObject(args[0], args[1]);}
	};
	iDocHostShowUI = new COMObject(new int[]{2, 0, 0, 7, C.PTR_SIZEOF == 4 ? 7 : 6}){
		public int /*long*/ method0(int /*long*/[] args) {return QueryInterface(args[0], args[1]);}
		public int /*long*/ method1(int /*long*/[] args) {return AddRef();}
		public int /*long*/ method2(int /*long*/[] args) {return Release();}
		public int /*long*/ method3(int /*long*/[] args) {return ShowMessage(args[0], args[1], args[2], (int)/*64*/args[3], args[4], (int)/*64*/args[5], args[6]);}
		public int /*long*/ method4(int /*long*/[] args) {
			if (args.length == 7) {
				return ShowHelp(args[0], args[1], (int)/*64*/args[2], (int)/*64*/args[3], (int)/*64*/args[4], (int)/*64*/args[5], args[6]);
			} else {
				return ShowHelp_64(args[0], args[1], (int)/*64*/args[2], (int)/*64*/args[3], args[4], args[5]);
			}
		}
	};
	iServiceProvider = new COMObject(new int[]{2, 0, 0, 3}){
		public int /*long*/ method0(int /*long*/[] args) {return QueryInterface(args[0], args[1]);}
		public int /*long*/ method1(int /*long*/[] args) {return AddRef();}
		public int /*long*/ method2(int /*long*/[] args) {return Release();}
		public int /*long*/ method3(int /*long*/[] args) {return QueryService(args[0], args[1], args[2]);}
	};
	iInternetSecurityManager = new COMObject(new int[]{2, 0, 0, 1, 1, 3, 4, 8, 7, 3, 3}){
		public int /*long*/ method0(int /*long*/[] args) {return QueryInterface(args[0], args[1]);}
		public int /*long*/ method1(int /*long*/[] args) {return AddRef();}
		public int /*long*/ method2(int /*long*/[] args) {return Release();}
		public int /*long*/ method3(int /*long*/[] args) {return SetSecuritySite(args[0]);}
		public int /*long*/ method4(int /*long*/[] args) {return GetSecuritySite(args[0]);}
		public int /*long*/ method5(int /*long*/[] args) {return MapUrlToZone(args[0], args[1], (int)/*64*/args[2]);}
		public int /*long*/ method6(int /*long*/[] args) {return GetSecurityId(args[0], args[1], args[2], args[3]);}
		public int /*long*/ method7(int /*long*/[] args) {return ProcessUrlAction(args[0], (int)/*64*/args[1], args[2], (int)/*64*/args[3], args[4], (int)/*64*/args[5], (int)/*64*/args[6], (int)/*64*/args[7]);}
		public int /*long*/ method8(int /*long*/[] args) {return QueryCustomPolicy(args[0], args[1], args[2], args[3], args[4], (int)/*64*/args[5], (int)/*64*/args[6]);}
		public int /*long*/ method9(int /*long*/[] args) {return SetZoneMapping((int)/*64*/args[0], args[1], (int)/*64*/args[2]);}
		public int /*long*/ method10(int /*long*/[] args) {return GetZoneMappings((int)/*64*/args[0], args[1], (int)/*64*/args[2]);}
	};
	iOleCommandTarget = new COMObject(new int[]{2, 0, 0, 4, 5}) {
		public int /*long*/ method0(int /*long*/[] args) {return QueryInterface(args[0], args[1]);}
		public int /*long*/ method1(int /*long*/[] args) {return AddRef();}
		public int /*long*/ method2(int /*long*/[] args) {return Release();}		
		public int /*long*/ method3(int /*long*/[] args) {return QueryStatus(args[0], (int)/*64*/args[1], args[2], args[3]);}		
		public int /*long*/ method4(int /*long*/[] args) {return Exec(args[0], (int)/*64*/args[1], (int)/*64*/args[2], args[3], args[4]);}
	};
}

protected void disposeCOMInterfaces() {
	super.disposeCOMInterfaces();
	if (iDocHostUIHandler != null) {
		iDocHostUIHandler.dispose();
		iDocHostUIHandler = null;
	}
	if (iDocHostShowUI != null) {
		iDocHostShowUI.dispose();
		iDocHostShowUI = null;
	}
	if (iServiceProvider != null) {
		iServiceProvider.dispose();
		iServiceProvider = null;
	}
	if (iInternetSecurityManager != null) {
		iInternetSecurityManager.dispose();
		iInternetSecurityManager = null;
	}
	if (iOleCommandTarget != null) {
		iOleCommandTarget.dispose();
		iOleCommandTarget = null;
	}
}

protected int AddRef() {
	/* Workaround for javac 1.1.8 bug */
	return super.AddRef();
}

protected int QueryInterface(int /*long*/ riid, int /*long*/ ppvObject) {
	int result = super.QueryInterface(riid, ppvObject);
	if (result == COM.S_OK) return result;
	if (riid == 0 || ppvObject == 0) return COM.E_INVALIDARG;
	GUID guid = new GUID();
	COM.MoveMemory(guid, riid, GUID.sizeof);
	if (COM.IsEqualGUID(guid, COM.IIDIDocHostUIHandler)) {
		COM.MoveMemory(ppvObject, new int /*long*/[] {iDocHostUIHandler.getAddress()}, OS.PTR_SIZEOF);
		AddRef();
		return COM.S_OK;
	}
	if (COM.IsEqualGUID(guid, COM.IIDIDocHostShowUI)) {
		COM.MoveMemory(ppvObject, new int /*long*/[] {iDocHostShowUI.getAddress()}, OS.PTR_SIZEOF);
		AddRef();
		return COM.S_OK;
	}
	if (COM.IsEqualGUID(guid, COM.IIDIServiceProvider)) {
		COM.MoveMemory(ppvObject, new int /*long*/[] {iServiceProvider.getAddress()}, OS.PTR_SIZEOF);
		AddRef();
		return COM.S_OK;
	}
    if (COM.IsEqualGUID(guid, COM.IIDIInternetSecurityManager)) {
        COM.MoveMemory(ppvObject, new int /*long*/[] {iInternetSecurityManager.getAddress()}, OS.PTR_SIZEOF);
        AddRef();
        return COM.S_OK;
    }
	if (COM.IsEqualGUID(guid, COM.IIDIOleCommandTarget)) {
		COM.MoveMemory(ppvObject, new int /*long*/[] {iOleCommandTarget.getAddress()}, OS.PTR_SIZEOF);
		AddRef();
		return COM.S_OK;
	}
	COM.MoveMemory(ppvObject, new int /*long*/[] {0}, OS.PTR_SIZEOF);
	return COM.E_NOINTERFACE;
}

/* IDocHostUIHandler */

int EnableModeless(int EnableModeless) {
	return COM.E_NOTIMPL;
}

int FilterDataObject(int /*long*/ pDO, int /*long*/ ppDORet) {
	return COM.E_NOTIMPL;
}

int GetDropTarget(int /*long*/ pDropTarget, int /*long*/ ppDropTarget) {
	return COM.E_NOTIMPL;
}

int GetExternal(int /*long*/ ppDispatch) {
	OS.MoveMemory(ppDispatch, new int /*long*/ [] {0}, OS.PTR_SIZEOF);
	return COM.S_FALSE;
}

int GetHostInfo(int /*long*/ pInfo) {
	int info = IE.DOCHOSTUIFLAG_THEME;
	Browser browser = (Browser)getParent().getParent();
	if ((browser.getStyle() & SWT.BORDER) == 0) info |= IE.DOCHOSTUIFLAG_NO3DOUTERBORDER;

	DOCHOSTUIINFO uiInfo = new DOCHOSTUIINFO ();
	OS.MoveMemory(uiInfo, pInfo, DOCHOSTUIINFO.sizeof);
	uiInfo.dwFlags = info;
	OS.MoveMemory(pInfo, uiInfo, DOCHOSTUIINFO.sizeof);
	return COM.S_OK;
}

int GetOptionKeyPath(int /*long*/ pchKey, int dw) {
	return COM.E_NOTIMPL;
}

int HideUI() {
	return COM.E_NOTIMPL;
}

int OnDocWindowActivate(int fActivate) {
	return COM.E_NOTIMPL;
}

int OnFrameWindowActivate(int fActivate) {
	return COM.E_NOTIMPL;
}

protected int Release() {
	/* Workaround for javac 1.1.8 bug */
	return super.Release();
}

int ResizeBorder(int /*long*/ prcBorder, int /*long*/ pUIWindow, int fFrameWindow) {
	return COM.E_NOTIMPL;
}

int ShowContextMenu(int dwID, int /*long*/ ppt, int /*long*/ pcmdtReserved, int /*long*/ pdispReserved) {
	Browser browser = (Browser)getParent().getParent();
	Event event = new Event();
	POINT pt = new POINT();
	OS.MoveMemory(pt, ppt, POINT.sizeof);
	event.x = pt.x;
	event.y = pt.y;
	browser.notifyListeners(SWT.MenuDetect, event);
	if (!event.doit) return COM.S_OK;
	Menu menu = browser.getMenu();
	if (menu != null && !menu.isDisposed ()) {
		if (pt.x != event.x || pt.y != event.y) {
			menu.setLocation (event.x, event.y);
		}
		menu.setVisible (true);
		return COM.S_OK;
	}
	/* Show default IE popup menu */
	return COM.S_FALSE;
}

int ShowUI(int dwID, int /*long*/ pActiveObject, int /*long*/ pCommandTarget, int /*long*/ pFrame, int /*long*/ pDoc) {
	return COM.S_FALSE;
}

int TranslateAccelerator(int /*long*/ lpMsg, int /*long*/ pguidCmdGroup, int nCmdID) {
	/*
	* Feature on Internet Explorer.  By default the embedded Internet Explorer control runs
	* the Internet Explorer shortcuts (e.g. F5 for refresh).  This overrides the shortcuts
	* defined by SWT.  The workaround is to forward the accelerator keys to the parent window
	* and have Internet Explorer ignore the ones handled by the parent window.
	*/
	Menu menubar = getShell().getMenuBar();
	if (menubar != null && !menubar.isDisposed() && menubar.isEnabled()) {
		Shell shell = menubar.getShell();
		int /*long*/ hwnd = shell.handle;
		int /*long*/ hAccel = OS.SendMessage(hwnd, OS.WM_APP+1, 0, 0);
		if (hAccel != 0) {
			MSG msg = new MSG();
			OS.MoveMemory(msg, lpMsg, MSG.sizeof);
			if (OS.TranslateAccelerator(hwnd, hAccel, msg) != 0) return COM.S_OK;
		}
	}
	/*
	* Feature on Internet Explorer.  By default the embedded Internet Explorer control runs
	* the Internet Explorer shortcuts.  CTRL-N opens a standalone IE, which is undesirable
	* and can cause a crash in some contexts.  CTRL-O is being intercepted by IE, but this
	* accelerator should be handled by Eclipse. F5 causes a refresh, which is not appropriate
	* when rendering HTML from memory.  The workaround is to block the handling of these
	* shortcuts by IE when necessary, and in some cases ensure that Eclipse has an opportunity
	* to handle these accelerators.
	*/
	int result = COM.S_FALSE;
	MSG msg = new MSG();
	OS.MoveMemory(msg, lpMsg, MSG.sizeof);
	if (msg.message == OS.WM_KEYDOWN) {
		switch ((int)/*64*/msg.wParam) {
			case OS.VK_N:
			case OS.VK_O:
				if (OS.GetKeyState (OS.VK_CONTROL) < 0) {
					getParent().setData(CONSUME_KEY, "false"); //$NON-NLS-1$
					result = COM.S_OK;
				}
				break;
			case OS.VK_F5:
				OleAutomation auto = new OleAutomation(this);
				int[] rgdispid = auto.getIDsOfNames(new String[] { "LocationURL" }); //$NON-NLS-1$
				Variant pVarResult = auto.getProperty(rgdispid[0]);
				auto.dispose();
				if (pVarResult != null) {
					if (pVarResult.getType() == OLE.VT_BSTR) {
						String url = pVarResult.getString();
						if (url.equals(IE.ABOUT_BLANK)) result = COM.S_OK;
					}
					pVarResult.dispose();
				}
				break;
		}
	}
	return result;
}

int TranslateUrl(int dwTranslate, int /*long*/ pchURLIn, int /*long*/ ppchURLOut) {
	return COM.E_NOTIMPL;
}

int UpdateUI() {
	return COM.E_NOTIMPL;
}

/* IDocHostShowUI */

int ShowMessage(int /*long*/ hwnd, int /*long*/ lpstrText, int /*long*/ lpstrCaption, int dwType, int /*long*/ lpstrHelpFile, int dwHelpContext, int /*long*/ plResult) {
	/*
	* Feature on IE.  When IE navigates to a website that contains an ActiveX that is prevented from
	* being executed, IE displays a message "Your current security settings prohibit running ActiveX 
	* controls on this page ...".  The workaround is to selectively block this alert as indicated
	* in the MSDN article "WebBrowser customization".
	*/
	/* resource identifier in shdoclc.dll for window caption "Your current security settings prohibit 
	 * running ActiveX controls on this page ..." 
	 */
	int IDS_MESSAGE_BOX_CAPTION = 8033;
		if (lpstrText != 0) {
		TCHAR lpLibFileName = new TCHAR (0, "SHDOCLC.DLL", true); //$NON-NLS-1$
		int /*long*/ hModule = OS.LoadLibrary(lpLibFileName);
		if (hModule != 0) {
			/* 
			* Note.  lpstrText is a LPOLESTR, i.e. a null terminated unicode string LPWSTR, i.e. a WCHAR*.
			* It is not a BSTR.  A BSTR is a null terminated unicode string that contains its length
			* at the beginning. 
			*/
			int cnt = OS.wcslen(lpstrText);
			char[] buffer = new char[cnt];
			/* 
			* Note.  lpstrText is unicode on both unicode and ansi platforms.
			* The nbr of chars is multiplied by the constant 2 and not by TCHAR.sizeof since
			* TCHAR.sizeof returns 1 on ansi platforms.
			*/
			OS.MoveMemory(buffer, lpstrText, cnt * 2);
			String text = new String(buffer);
			/* provide a buffer large enough to hold the string to compare to and a null terminated character */
			int length = (OS.IsUnicode ? cnt : OS.WideCharToMultiByte (OS.CP_ACP, 0, buffer, cnt, 0, 0, null, null)) + 1;

			TCHAR lpBuffer = new TCHAR(0, length);
			int result = OS.LoadString(hModule, IDS_MESSAGE_BOX_CAPTION, lpBuffer, length);
			OS.FreeLibrary(hModule);
			return result > 0 && text.equals(lpBuffer.toString(0, result)) ? COM.S_OK : COM.S_FALSE;
		}
	}
	return COM.S_FALSE;
}

int ShowHelp_64(int /*long*/ hwnd, int /*long*/ pszHelpFile, int uCommand, int dwData, long pt, int /*long*/ pDispatchObjectHit) {
	POINT point = new POINT();
	OS.MoveMemory(point, new long[]{pt}, 8);
	return ShowHelp(hwnd, pszHelpFile, uCommand, dwData, point.x, point.y, pDispatchObjectHit);
}

/* Note.  One of the arguments of ShowHelp is a POINT struct and not a pointer to a POINT struct. Because
 * of the way Callback gets int parameters from a va_list of C arguments 2 integer arguments must be declared,
 * ptMouse_x and ptMouse_y. Otherwise the Browser crashes when the user presses F1 to invoke
 * the help.
 */
int ShowHelp(int /*long*/ hwnd, int /*long*/ pszHelpFile, int uCommand, int dwData, int ptMouse_x, int ptMouse_y, int /*long*/ pDispatchObjectHit) {
	Browser browser = (Browser)getParent().getParent();
	Event event = new Event();
	event.type = SWT.Help;
	event.display = getDisplay();
	event.widget = browser;
	Shell shell = browser.getShell();
	Control control = browser;
	do {
		if (control.isListening(SWT.Help)) {
			control.notifyListeners(SWT.Help, event);
			break;
		}
		if (control == shell) break;
		control = control.getParent();
	} while (true);
	return COM.S_OK;
}

/* IServiceProvider */

int QueryService(int /*long*/ guidService, int /*long*/ riid, int /*long*/ ppvObject) {
	if (riid == 0 || ppvObject == 0) return COM.E_INVALIDARG;
	GUID guid = new GUID();
	COM.MoveMemory(guid, riid, GUID.sizeof);
	if (COM.IsEqualGUID(guid, COM.IIDIInternetSecurityManager)) {
		COM.MoveMemory(ppvObject, new int /*long*/[] {iInternetSecurityManager.getAddress()}, OS.PTR_SIZEOF);
		AddRef();
		return COM.S_OK;
	}
	COM.MoveMemory(ppvObject, new int /*long*/[] {0}, OS.PTR_SIZEOF);
	return COM.E_NOINTERFACE;
}

/* IInternetSecurityManager */

int SetSecuritySite(int /*long*/ pSite) {
	return IE.INET_E_DEFAULT_ACTION;
}

int GetSecuritySite(int /*long*/ ppSite) {
	return IE.INET_E_DEFAULT_ACTION;
}

int MapUrlToZone(int /*long*/ pwszUrl, int /*long*/ pdwZone, int dwFlags) {	
	/*
	* Feature in IE 6 sp1.  HTML rendered in memory
	* does not enable local links but the exact same
	* HTML document loaded through a local file is
	* permitted to follow local links.  The workaround is
	* to return URLZONE_INTRANET instead of the default
	* value URLZONE_LOCAL_MACHINE.
	*/	
	COM.MoveMemory(pdwZone, new int[] {IE.URLZONE_INTRANET}, 4);
	return COM.S_OK;
}

int GetSecurityId(int /*long*/ pwszUrl, int /*long*/ pbSecurityId, int /*long*/ pcbSecurityId, int /*long*/ dwReserved) {
	return IE.INET_E_DEFAULT_ACTION;
}

int ProcessUrlAction(int /*long*/ pwszUrl, int dwAction, int /*long*/ pPolicy, int cbPolicy, int /*long*/ pContext, int cbContext, int dwFlags, int dwReserved) {
	/*
	* Feature in IE 6 sp1.  HTML rendered in memory
	* containing an OBJECT tag referring to a local file
	* brings up a warning dialog asking the user whether
	* it should proceed or not.  The workaround is to
	* set the policy to URLPOLICY_ALLOW in this case (dwAction
	* value of 0x1406).
	* 
	* Feature in IE. Security Patches and user settings
	* affect the way the embedded web control behaves.  The current
	* approach is to consider the content trusted and allow
	* all URLs by default.
	*/
	int policy = IE.URLPOLICY_ALLOW;
	/*
	* The URLACTION_JAVA flags refer to the <applet> tag, which resolves to
	* the Microsoft VM if the applet is java 1.1.x compliant, or to the OS's
	* java plug-in VM otherwise.  Applets launched with the MS VM work in the
	* Browser, but applets launched with the OS's java plug-in VM crash as a
	* result of the VM failing to load.  Set the policy to URLPOLICY_JAVA_PROHIBIT
	* so that applets compiled with java compliance > 1.1.x will not crash. 
	*/
	if (dwAction >= IE.URLACTION_JAVA_MIN && dwAction <= IE.URLACTION_JAVA_MAX) {
		policy = IE.URLPOLICY_JAVA_PROHIBIT;
	}
	/*
	* Note.  Some ActiveX plugins crash when executing
	* inside the embedded explorer itself running into
	* a JVM.  The current workaround is to detect when
	* such ActiveX is about to be started and refuse
	* to execute it.
	*/
	if (dwAction == IE.URLACTION_ACTIVEX_RUN) {
		GUID guid = new GUID();
		COM.MoveMemory(guid, pContext, GUID.sizeof);
		if (COM.IsEqualGUID(guid, COM.IIDJavaBeansBridge) || COM.IsEqualGUID(guid, COM.IIDShockwaveActiveXControl)) {
			policy = IE.URLPOLICY_DISALLOW;
		}
	}
	if (cbPolicy >= 4) COM.MoveMemory(pPolicy, new int[] {policy}, 4);
	return policy == IE.URLPOLICY_ALLOW ? COM.S_OK : COM.S_FALSE;
}

int QueryCustomPolicy(int /*long*/ pwszUrl, int /*long*/ guidKey, int /*long*/ ppPolicy, int /*long*/ pcbPolicy, int /*long*/ pContext, int cbContext, int dwReserved) {
	return IE.INET_E_DEFAULT_ACTION;
}

int SetZoneMapping(int dwZone, int /*long*/ lpszPattern, int dwFlags) {
	return IE.INET_E_DEFAULT_ACTION;
}

int GetZoneMappings(int dwZone, int /*long*/ ppenumString, int dwFlags) {
	return COM.E_NOTIMPL;
}

/* IOleCommandTarget */
int QueryStatus(int /*long*/ pguidCmdGroup, int cCmds, int /*long*/ prgCmds, int /*long*/ pCmdText) {
	return COM.E_NOTSUPPORTED;
}

int Exec(int /*long*/ pguidCmdGroup, int nCmdID, int nCmdExecOpt, int /*long*/ pvaIn, int /*long*/ pvaOut) {
	if (pguidCmdGroup != 0) {
		GUID guid = new GUID();
		COM.MoveMemory(guid, pguidCmdGroup, GUID.sizeof);

		/*
		* If a javascript error occurred then suppress IE's default script error dialog.
		*/
		if (COM.IsEqualGUID(guid, COM.CGID_DocHostCommandHandler)) {
			if (nCmdID == OLECMDID_SHOWSCRIPTERROR) return COM.S_OK;
		}

		/*
		* Bug in Internet Explorer.  OnToolBar TRUE is also fired when any of the 
		* address bar or menu bar are requested but not the tool bar.  A workaround
		* has been posted by a Microsoft developer on the public webbrowser_ctl
		* newsgroup. The workaround is to implement the IOleCommandTarget interface
		* to test the argument of an undocumented command.
		*/
		if (nCmdID == 1 && COM.IsEqualGUID(guid, COM.CGID_Explorer) && ((nCmdExecOpt & 0xFFFF) == 0xA)) {
			IE browser = (IE)((Browser)getParent().getParent()).webBrowser;
			browser.toolBar = (nCmdExecOpt & 0xFFFF0000) != 0;
		}
	}
	return COM.E_NOTSUPPORTED;
}

}
