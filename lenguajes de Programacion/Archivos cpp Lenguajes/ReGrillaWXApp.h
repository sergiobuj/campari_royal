//---------------------------------------------------------------------------
//
// Name:        ReGrillaWXApp.h
// Author:      Sergio
// Created:     11/09/2007 09:05:45 p.m.
// Description: 
//
//---------------------------------------------------------------------------

#ifndef __REGRILLAWXFRMApp_h__
#define __REGRILLAWXFRMApp_h__

#ifdef __BORLANDC__
	#pragma hdrstop
#endif

#ifndef WX_PRECOMP
	#include <wx/wx.h>
#else
	#include <wx/wxprec.h>
#endif

class ReGrillaWXFrmApp : public wxApp
{
	public:
		bool OnInit();
		int OnExit();
};

#endif
