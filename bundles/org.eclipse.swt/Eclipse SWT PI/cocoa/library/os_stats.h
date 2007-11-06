/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation
 *******************************************************************************/

#ifdef NATIVE_STATS
extern int OS_nativeFunctionCount;
extern int OS_nativeFunctionCallCount[];
extern char* OS_nativeFunctionNames[];
#define OS_NATIVE_ENTER(env, that, func) OS_nativeFunctionCallCount[func]++;
#define OS_NATIVE_EXIT(env, that, func) 
#else
#ifndef OS_NATIVE_ENTER
#define OS_NATIVE_ENTER(env, that, func) 
#endif
#ifndef OS_NATIVE_EXIT
#define OS_NATIVE_EXIT(env, that, func) 
#endif
#endif

typedef enum {
	DeleteGlobalRef_FUNC,
	GetCurrentProcess_FUNC,
	JNIGetObject_FUNC,
	NSBackgroundColorAttributeName_FUNC,
	NSBitsPerPixelFromDepth_FUNC,
	NSDeviceRGBColorSpace_FUNC,
	NSFontAttributeName_FUNC,
	NSForegroundColorAttributeName_FUNC,
	NewGlobalRef_FUNC,
	SetFrontProcess_FUNC,
	TransformProcessType_FUNC,
	class_1addIvar_FUNC,
	class_1addMethod_FUNC,
	objc_1allocateClassPair_FUNC,
	objc_1getClass_FUNC,
	objc_1lookUpClass_FUNC,
	objc_1msgSend__II_FUNC,
	objc_1msgSend__IIB_FUNC,
	objc_1msgSend__IID_FUNC,
	objc_1msgSend__IIDD_FUNC,
	objc_1msgSend__IIDI_FUNC,
	objc_1msgSend__IIDIIIZ_FUNC,
	objc_1msgSend__IIDIZ_FUNC,
	objc_1msgSend__IIF_FUNC,
	objc_1msgSend__IIFF_FUNC,
	objc_1msgSend__IIFFFF_FUNC,
	objc_1msgSend__IIFFFFF_FUNC,
	objc_1msgSend__IIFI_FUNC,
	objc_1msgSend__IIFIF_FUNC,
	objc_1msgSend__IIFII_FUNC,
	objc_1msgSend__IIFIII_FUNC,
	objc_1msgSend__III_FUNC,
	objc_1msgSend__IIIDIIIZ_FUNC,
	objc_1msgSend__IIIF_FUNC,
	objc_1msgSend__IIIFFF_FUNC,
	objc_1msgSend__IIIFI_FUNC,
	objc_1msgSend__IIIFILorg_eclipse_swt_internal_cocoa_NSPoint_2_FUNC,
	objc_1msgSend__IIII_FUNC,
	objc_1msgSend__IIIID_FUNC,
	objc_1msgSend__IIIIDI_FUNC,
	objc_1msgSend__IIIIF_FUNC,
	objc_1msgSend__IIIIFII_FUNC,
	objc_1msgSend__IIIII_FUNC,
	objc_1msgSend__IIIIIF_FUNC,
	objc_1msgSend__IIIIII_FUNC,
	objc_1msgSend__IIIIIII_FUNC,
	objc_1msgSend__IIIIIIII_FUNC,
	objc_1msgSend__IIIIIIIII_FUNC,
	objc_1msgSend__IIIIIIILorg_eclipse_swt_internal_cocoa_NSPoint_2_FUNC,
	objc_1msgSend__IIIIIIILorg_eclipse_swt_internal_cocoa_NSRange_2I_FUNC,
	objc_1msgSend__IIIIIIIZZIII_FUNC,
	objc_1msgSend__IIIIIIIZZIIII_FUNC,
	objc_1msgSend__IIIIIILorg_eclipse_swt_internal_cocoa_NSRect_2FFF_FUNC,
	objc_1msgSend__IIIIILorg_eclipse_swt_internal_cocoa_NSPoint_2_FUNC,
	objc_1msgSend__IIIIILorg_eclipse_swt_internal_cocoa_NSRange_2_FUNC,
	objc_1msgSend__IIIIILorg_eclipse_swt_internal_cocoa_NSRange_2I_FUNC,
	objc_1msgSend__IIIIISI_FUNC,
	objc_1msgSend__IIIIIZ_FUNC,
	objc_1msgSend__IIIIIZI_FUNC,
	objc_1msgSend__IIIIJ_FUNC,
	objc_1msgSend__IIIILorg_eclipse_swt_internal_cocoa_NSPoint_2_FUNC,
	objc_1msgSend__IIIILorg_eclipse_swt_internal_cocoa_NSPoint_2I_FUNC,
	objc_1msgSend__IIIILorg_eclipse_swt_internal_cocoa_NSRange_2_FUNC,
	objc_1msgSend__IIIILorg_eclipse_swt_internal_cocoa_NSRange_2I_FUNC,
	objc_1msgSend__IIIILorg_eclipse_swt_internal_cocoa_NSRange_2ILorg_eclipse_swt_internal_cocoa_NSRange_2_FUNC,
	objc_1msgSend__IIIILorg_eclipse_swt_internal_cocoa_NSRange_2Lorg_eclipse_swt_internal_cocoa_NSPoint_2_FUNC,
	objc_1msgSend__IIIILorg_eclipse_swt_internal_cocoa_NSRange_2Lorg_eclipse_swt_internal_cocoa_NSPoint_2IILorg_eclipse_swt_internal_cocoa_NSSize_2_FUNC,
	objc_1msgSend__IIIILorg_eclipse_swt_internal_cocoa_NSRect_2_FUNC,
	objc_1msgSend__IIIILorg_eclipse_swt_internal_cocoa_NSRect_2I_FUNC,
	objc_1msgSend__IIIILorg_eclipse_swt_internal_cocoa_NSRect_2II_FUNC,
	objc_1msgSend__IIIIS_FUNC,
	objc_1msgSend__IIIIZ_FUNC,
	objc_1msgSend__IIIIZI_FUNC,
	objc_1msgSend__IIIIZII_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSPoint_2_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSPoint_2I_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSPoint_2IDIIIIF_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSPoint_2IDIIIII_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSPoint_2IDIIIIZS_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSPoint_2IDIISII_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSPoint_2II_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSPoint_2Lorg_eclipse_swt_internal_cocoa_NSPoint_2_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSPoint_2Lorg_eclipse_swt_internal_cocoa_NSSize_2IIIZ_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSPoint_2Z_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSRange_2_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSRange_2I_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSRange_2II_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSRange_2IZ_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSRange_2Lorg_eclipse_swt_internal_cocoa_NSRange_2_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSRect_2_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSRect_2I_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSRect_2II_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSRect_2IIZ_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSRect_2ILorg_eclipse_swt_internal_cocoa_NSRange_2I_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSRect_2IZ_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSRect_2IZI_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSRect_2ZI_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSSize_2_FUNC,
	objc_1msgSend__IIILorg_eclipse_swt_internal_cocoa_NSSize_2Z_FUNC,
	objc_1msgSend__IIIS_FUNC,
	objc_1msgSend__IIISZZZZ_FUNC,
	objc_1msgSend__IIIZ_FUNC,
	objc_1msgSend__IIIZI_FUNC,
	objc_1msgSend__IIIZII_FUNC,
	objc_1msgSend__IIIZIII_FUNC,
	objc_1msgSend__IIIZZ_FUNC,
	objc_1msgSend__IIIZZII_FUNC,
	objc_1msgSend__IIJ_FUNC,
	objc_1msgSend__IIJI_FUNC,
	objc_1msgSend__IIJSZ_FUNC,
	objc_1msgSend__IILjava_lang_String_2_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSAffineTransformStruct_2_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSDecimal_2_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSPoint_2_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSPoint_2F_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSPoint_2FFF_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSPoint_2FFFZ_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSPoint_2FLorg_eclipse_swt_internal_cocoa_NSPoint_2FI_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSPoint_2I_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSPoint_2IF_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSPoint_2II_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSPoint_2ILorg_eclipse_swt_internal_cocoa_NSRange_2_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSPoint_2Lorg_eclipse_swt_internal_cocoa_NSPoint_2_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSPoint_2Lorg_eclipse_swt_internal_cocoa_NSPoint_2F_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSPoint_2Lorg_eclipse_swt_internal_cocoa_NSPoint_2I_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSPoint_2Lorg_eclipse_swt_internal_cocoa_NSPoint_2IZ_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSPoint_2Lorg_eclipse_swt_internal_cocoa_NSPoint_2Lorg_eclipse_swt_internal_cocoa_NSPoint_2_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSPoint_2Lorg_eclipse_swt_internal_cocoa_NSRange_2_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSPoint_2Lorg_eclipse_swt_internal_cocoa_NSRect_2_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSPoint_2Lorg_eclipse_swt_internal_cocoa_NSRect_2F_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSPoint_2Lorg_eclipse_swt_internal_cocoa_NSRect_2I_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSPoint_2Lorg_eclipse_swt_internal_cocoa_NSRect_2IF_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRange_2_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRange_2I_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRange_2IFLorg_eclipse_swt_internal_cocoa_NSRect_2Lorg_eclipse_swt_internal_cocoa_NSRange_2Lorg_eclipse_swt_internal_cocoa_NSPoint_2_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRange_2II_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRange_2III_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRange_2IIII_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRange_2IIIII_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRange_2ILorg_eclipse_swt_internal_cocoa_NSRange_2_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRange_2ILorg_eclipse_swt_internal_cocoa_NSRect_2Lorg_eclipse_swt_internal_cocoa_NSRange_2Lorg_eclipse_swt_internal_cocoa_NSPoint_2_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRange_2IZ_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRange_2Lorg_eclipse_swt_internal_cocoa_NSPoint_2_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRange_2Lorg_eclipse_swt_internal_cocoa_NSRange_2_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRange_2Lorg_eclipse_swt_internal_cocoa_NSRange_2II_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRange_2ZI_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRect_2_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRect_2F_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRect_2FF_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRect_2I_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRect_2II_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRect_2III_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRect_2IIII_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRect_2IIIII_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRect_2IIZ_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRect_2IIZI_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRect_2ILorg_eclipse_swt_internal_cocoa_NSRange_2_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRect_2ILorg_eclipse_swt_internal_cocoa_NSRange_2I_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRect_2IZ_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRect_2IZI_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRect_2Lorg_eclipse_swt_internal_cocoa_NSPoint_2_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRect_2Lorg_eclipse_swt_internal_cocoa_NSRange_2Lorg_eclipse_swt_internal_cocoa_NSRect_2_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRect_2Lorg_eclipse_swt_internal_cocoa_NSRange_2Lorg_eclipse_swt_internal_cocoa_NSRect_2F_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRect_2Lorg_eclipse_swt_internal_cocoa_NSRect_2I_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRect_2Lorg_eclipse_swt_internal_cocoa_NSRect_2IF_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRect_2Lorg_eclipse_swt_internal_cocoa_NSSize_2_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRect_2Z_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSRect_2ZZ_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSSize_2_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSSize_2I_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSSize_2IZZ_FUNC,
	objc_1msgSend__IILorg_eclipse_swt_internal_cocoa_NSSize_2Lorg_eclipse_swt_internal_cocoa_NSRange_2_FUNC,
	objc_1msgSend__IIS_FUNC,
	objc_1msgSend__IISI_FUNC,
	objc_1msgSend__IIZ_FUNC,
	objc_1msgSend__IIZI_FUNC,
	objc_1msgSend__IIZII_FUNC,
	objc_1msgSend__IIZLorg_eclipse_swt_internal_cocoa_NSRange_2_FUNC,
	objc_1msgSend__IIZLorg_eclipse_swt_internal_cocoa_NSRect_2_FUNC,
	objc_1msgSend__IIZLorg_eclipse_swt_internal_cocoa_NSRect_2I_FUNC,
	objc_1msgSend__IIZZ_FUNC,
	objc_1msgSend__II_3C_FUNC,
	objc_1msgSend__II_3CI_FUNC,
	objc_1msgSend_1fpret__II_FUNC,
	objc_1msgSend_1fpret__IID_FUNC,
	objc_1msgSend_1fpret__IIF_FUNC,
	objc_1msgSend_1fpret__III_FUNC,
	objc_1msgSend_1fpret__IIIF_FUNC,
	objc_1msgSend_1fpret__IIIFI_FUNC,
	objc_1msgSend_1fpret__IIII_FUNC,
	objc_1msgSend_1fpret__IIIIF_FUNC,
	objc_1msgSend_1fpret__IIIIZF_FUNC,
	objc_1msgSend_1fpret__IIILorg_eclipse_swt_internal_cocoa_NSRect_2_FUNC,
	objc_1msgSend_1fpret__IILorg_eclipse_swt_internal_cocoa_NSPoint_2_FUNC,
	objc_1msgSend_1fpret__IILorg_eclipse_swt_internal_cocoa_NSPoint_2I_FUNC,
	objc_1msgSend_1fpret__IILorg_eclipse_swt_internal_cocoa_NSRect_2_FUNC,
	objc_1msgSend_1fpret__IILorg_eclipse_swt_internal_cocoa_NSSize_2_FUNC,
	objc_1msgSend_1size_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSAffineTransformStruct_2II_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSDecimal_2II_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSPoint_2II_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSPoint_2III_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSPoint_2IIIII_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSPoint_2IIIIIII_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSPoint_2IIILorg_eclipse_swt_internal_cocoa_NSRect_2I_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSPoint_2IIISLorg_eclipse_swt_internal_cocoa_NSRect_2_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSPoint_2IILorg_eclipse_swt_internal_cocoa_NSPoint_2_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSPoint_2IILorg_eclipse_swt_internal_cocoa_NSPoint_2I_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSPoint_2IILorg_eclipse_swt_internal_cocoa_NSRect_2_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRange_2II_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRange_2III_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRange_2IIII_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRange_2IIIII_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRange_2IIIIII_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRange_2IIIIIIZ_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRange_2IIIIIZII_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRange_2IIIILorg_eclipse_swt_internal_cocoa_NSRange_2_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRange_2IIIILorg_eclipse_swt_internal_cocoa_NSRange_2I_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRange_2IIILorg_eclipse_swt_internal_cocoa_NSRange_2Lorg_eclipse_swt_internal_cocoa_NSRange_2_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRange_2IILorg_eclipse_swt_internal_cocoa_NSRange_2_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRange_2IILorg_eclipse_swt_internal_cocoa_NSRange_2I_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRange_2IILorg_eclipse_swt_internal_cocoa_NSRange_2II_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRange_2IILorg_eclipse_swt_internal_cocoa_NSRect_2_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRange_2IILorg_eclipse_swt_internal_cocoa_NSRect_2I_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRect_2II_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRect_2III_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRect_2IIII_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRect_2IIIII_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRect_2IIIILorg_eclipse_swt_internal_cocoa_NSRect_2_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRect_2IIIILorg_eclipse_swt_internal_cocoa_NSRect_2Lorg_eclipse_swt_internal_cocoa_NSPoint_2I_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRect_2IIIIZ_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRect_2IIILorg_eclipse_swt_internal_cocoa_NSPoint_2Lorg_eclipse_swt_internal_cocoa_NSRect_2ILorg_eclipse_swt_internal_cocoa_NSRange_2_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRect_2IIILorg_eclipse_swt_internal_cocoa_NSRange_2_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRect_2IIILorg_eclipse_swt_internal_cocoa_NSRect_2_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRect_2IIILorg_eclipse_swt_internal_cocoa_NSRect_2I_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRect_2IIILorg_eclipse_swt_internal_cocoa_NSRect_2Lorg_eclipse_swt_internal_cocoa_NSPoint_2I_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRect_2IIILorg_eclipse_swt_internal_cocoa_NSRect_2Lorg_eclipse_swt_internal_cocoa_NSRect_2I_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRect_2IIILorg_eclipse_swt_internal_cocoa_NSRect_2Lorg_eclipse_swt_internal_cocoa_NSRect_2ILorg_eclipse_swt_internal_cocoa_NSRange_2_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRect_2IILorg_eclipse_swt_internal_cocoa_NSPoint_2Lorg_eclipse_swt_internal_cocoa_NSRect_2ILorg_eclipse_swt_internal_cocoa_NSRange_2_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRect_2IILorg_eclipse_swt_internal_cocoa_NSRange_2_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRect_2IILorg_eclipse_swt_internal_cocoa_NSRange_2I_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRect_2IILorg_eclipse_swt_internal_cocoa_NSRect_2_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRect_2IILorg_eclipse_swt_internal_cocoa_NSRect_2I_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRect_2IILorg_eclipse_swt_internal_cocoa_NSRect_2III_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRect_2IILorg_eclipse_swt_internal_cocoa_NSRect_2Lorg_eclipse_swt_internal_cocoa_NSRect_2ILorg_eclipse_swt_internal_cocoa_NSRange_2_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRect_2IILorg_eclipse_swt_internal_cocoa_NSSize_2I_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRect_2IILorg_eclipse_swt_internal_cocoa_NSSize_2II_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSRect_2IIZ_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSSize_2II_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSSize_2IIF_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSSize_2III_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSSize_2IIII_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSSize_2IIILorg_eclipse_swt_internal_cocoa_NSRange_2II_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSSize_2IIILorg_eclipse_swt_internal_cocoa_NSSize_2_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSSize_2IILorg_eclipse_swt_internal_cocoa_NSRect_2_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSSize_2IILorg_eclipse_swt_internal_cocoa_NSSize_2_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSSize_2IILorg_eclipse_swt_internal_cocoa_NSSize_2I_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSSize_2IILorg_eclipse_swt_internal_cocoa_NSSize_2ZZI_FUNC,
	objc_1msgSend_1stret__Lorg_eclipse_swt_internal_cocoa_NSSize_2IIZ_FUNC,
	objc_1registerClassPair_FUNC,
	object_1getClassName_FUNC,
	object_1getInstanceVariable_FUNC,
	object_1setInstanceVariable_FUNC,
	sel_1registerName_FUNC,
} OS_FUNCS;
