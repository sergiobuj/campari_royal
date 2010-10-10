//---------------------------------------------------------------------------
//
// Name:        ReGrillaWXApp.cpp
// Author:      Sergio
// Created:     11/09/2007 09:05:45 p.m.
// Description: 
//
//---------------------------------------------------------------------------

#include "ReGrillaWXApp.h"
#include "ReGrillaWXFrm.h"

IMPLEMENT_APP(ReGrillaWXFrmApp)

bool ReGrillaWXFrmApp::OnInit()
{
    ReGrillaWXFrm* frame = new ReGrillaWXFrm(NULL);
    SetTopWindow(frame);
    frame->Show();
    return true;
}
 
int ReGrillaWXFrmApp::OnExit()
{
	return 0;
}
