//---------------------------------------------------------------------------
//
// Name:        ReGrillaWXFrm.h
// Author:      Sergio
// Created:     11/09/2007 09:05:45 p.m.
// Description: ReGrillaWXFrm class declaration
//
//---------------------------------------------------------------------------

#ifndef __REGRILLAWXFRM_h__
#define __REGRILLAWXFRM_h__

#ifdef __BORLANDC__
	#pragma hdrstop
#endif

#ifndef WX_PRECOMP
	#include <wx/wx.h>
	#include <wx/frame.h>
#else
	#include <wx/wxprec.h>
#endif

//Do not add custom headers between 
//Header Include Start and Header Include End.
//wxDev-C++ designer will remove them. Add custom headers after the block.
////Header Include Start
#include <wx/stattext.h>
////Header Include End

////Dialog Style Start
#undef ReGrillaWXFrm_STYLE
#define ReGrillaWXFrm_STYLE wxCAPTION | wxSYSTEM_MENU | wxMINIMIZE_BOX | wxCLOSE_BOX
////Dialog Style End

class ReGrillaWXFrm : public wxFrame
{
	private:
		DECLARE_EVENT_TABLE();
		
	public:
		ReGrillaWXFrm(wxWindow *parent, wxWindowID id = 1, const wxString &title = wxT("Grilla RIGO"), const wxPoint& pos = wxDefaultPosition, const wxSize& size = wxDefaultSize, long style = ReGrillaWXFrm_STYLE);
		virtual ~ReGrillaWXFrm();
		void ReGrillaWXFrmActivate(wxActivateEvent& event);
		
	private:
		//Do not add custom control declarations between
		//GUI Control Declaration Start and GUI Control Declaration End.
		//wxDev-C++ will remove them. Add custom code after the block.
		////GUI Control Declaration Start
		wxStaticText *WxStaticText1;
		////GUI Control Declaration End
		
	private:
		//Note: if you receive any error with these enum IDs, then you need to
		//change your old form code that are based on the #define control IDs.
		//#defines may replace a numeric value for the enum names.
		//Try copy and pasting the below block in your old form header files.
		enum
		{
			////GUI Enum Control ID Start
			ID_WXSTATICTEXT1 = 1001,
			////GUI Enum Control ID End
			ID_DUMMY_VALUE_ //don't remove this value unless you have other enum values
		};
		
	private:
		void OnClose(wxCloseEvent& event);
		void CreateGUIControls();
};

#endif
