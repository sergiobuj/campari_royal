//---------------------------------------------------------------------------
//
// Name:        ReGrillaWXFrm.cpp
// Author:      Sergio
// Created:     11/09/2007 09:05:45 p.m.
// Description: ReGrillaWXFrm class implementation
//
//---------------------------------------------------------------------------

#include "ReGrillaWXFrm.h"

//Do not add custom headers between
//Header Include Start and Header Include End
//wxDev-C++ designer will remove them
////Header Include Start
////Header Include End

//----------------------------------------------------------------------------
// ReGrillaWXFrm
//----------------------------------------------------------------------------
//Add Custom Events only in the appropriate block.
//Code added in other places will be removed by wxDev-C++
////Event Table Start
BEGIN_EVENT_TABLE(Ventana,wxFrame)
	////Manual Code Start
	////Manual Code End
	
	EVT_CLOSE(Ventana::OnClose)
	EVT_ACTIVATE(Ventana::ReGrillaWXFrmActivate)
END_EVENT_TABLE()
////Event Table End

ReGrillaWXFrm::ReGrillaWXFrm(wxWindow *parent, wxWindowID id, const wxString &title, const wxPoint &position, const wxSize& size, long style)
: wxFrame(parent, id, title, position, size, style)
{
	CreateGUIControls();
}

ReGrillaWXFrm::~ReGrillaWXFrm()
{
}

void ReGrillaWXFrm::CreateGUIControls()
{
	//Do not add custom code between
	//GUI Items Creation Start and GUI Items Creation End
	//wxDev-C++ designer will remove them.
	//Add the custom code before or after the blocks
	////GUI Items Creation Start

	SetTitle(wxT("Grilla RIGO"));
	SetIcon(wxNullIcon);
	SetSize(8,8,320,334);
	Center();
	

	WxStaticText1 = new wxStaticText(this, ID_WXSTATICTEXT1, wxT("Text1"), wxPoint(11,16), wxDefaultSize, 0, wxT("WxStaticText1"));
	WxStaticText1->SetFont(wxFont(8, wxSWISS, wxNORMAL,wxNORMAL, false, wxT("Tahoma")));
	////GUI Items Creation End
}

void ReGrillaWXFrm::OnClose(wxCloseEvent& event)
{
	Destroy();
}

/*
 * ReGrillaWXFrmActivate
 */
void ReGrillaWXFrm::ReGrillaWXFrmActivate(wxActivateEvent& event)
{
    //WxStaticText1
    
    WxStaticText matrix[][];
    
    
    
    
    // insert your code here
}
