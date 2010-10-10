//
//  Paisaje.java
//  Paisaje
//
//  Created by Sergio on 1/31/09.
//  Copyright (c) 2009 __MyCompanyName__. All rights reserved.
//
//  A simple signed Java applet
//
import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.geom.*;
public class Paisaje extends JApplet {
    public void init() {
	//Color mySky		=new Color(0,191,255);
	//Color myMountains	=new Color(0,100,0);
	//Color myMountains2	=new Color(34,139,34);
		setBackground(Color.WHITE);
	}
    public void paint (Graphics g) {
		Graphics2D myCanvas = (Graphics2D) g;
		myCanvas.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Dimension dim = getSize();
		int myWidth = dim.width;
		int myHeight = dim.height;
		//int sizeX=myWidth/6;
		//int sizeY=myHeight/2;
		int x=0,y=0;
		
		//// Gradient Sky \\\\
		GradientPaint gradSky = new GradientPaint( 0, 0, Color.cyan, 0, myHeight, Color.BLUE );
		myCanvas.setPaint( gradSky );
		myCanvas.fillRect( 0, 0, myWidth, myHeight*2/3);
		//// Sea \\\\
		myCanvas.setPaint( Color.BLUE );
		myCanvas.fillRect( 0, myHeight/2, myWidth, myHeight*2/3);
		//// Waves \\\\
		x=y=0;
		myCanvas.setStroke(new BasicStroke(10.0f,BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
		for(int i = 0; i< 20 ; ++i){
			myCanvas.draw(new Arc2D.Double(x, myHeight/2-15, 80,20, 180, 180, Arc2D.OPEN));
			x+=80;
		}
		x=y=0;
		//// Beach \\\\
		int bxPoints[] = {0,0,myWidth};
		GeneralPath bPolygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD,bxPoints.length);
		bPolygon.moveTo(-10,myHeight/2);
		bPolygon.curveTo(-10,myHeight/2+30,myWidth*2/3,myHeight/2+10,myWidth+50,myHeight);
		bPolygon.lineTo(-10,myHeight+5);
		bPolygon.closePath();
		myCanvas.setPaint(new Color(245,222,179));
		myCanvas.fill(bPolygon);
		//// Sun \\\\
		myCanvas.setPaint(Color.ORANGE);
		myCanvas.fill(new Ellipse2D.Double(myWidth*8/10,myHeight/10,80,80));
		//// Palm \\\\
		int palmY=0;
		int pos=myHeight*2/3;
		int palmXPoints[] = {myWidth/10,myWidth/10+40,myWidth/10+30,myWidth/10+10};// 50,90,80,60};
		for(int i = 0 ; i<20 ;++i){
			int palmYPoints[] = {pos-palmY,pos-palmY,pos-palmY+15,pos-palmY+15};
			GeneralPath palm = new GeneralPath(GeneralPath.WIND_EVEN_ODD,palmXPoints.length);
			palm.moveTo(palmXPoints[0], palmYPoints[0]);
			for ( int index = 1; index < palmXPoints.length; index++ ) {
				palm.lineTo(palmXPoints[index],palmYPoints[index]);
			};
			palm.closePath();
			myCanvas.setPaint(new Color(139,69,19));
			myCanvas.fill(palm);
			palmY+=15;
			if(i==19){
				myCanvas.setStroke(new BasicStroke(12.0f));
				myCanvas.setPaint(Color.GREEN);
				for(int j = 0;j<2;++j){
					myCanvas.fill(new Arc2D.Double(myWidth/10-100+x	,pos-palmY		,120	,40		,0		,180	,Arc2D.OPEN));
					x+=120;
				}
				x=y=0;
				for(int j = 0;j<6;++j){
					myCanvas.draw(new Arc2D.Double(myWidth/10-100+x	,pos-palmY+15		,40	,15	,0		,180	,Arc2D.OPEN));
					if(j==2)x+=55;
					else x+=35;
				}
			}
		}
		x=y=0;
	}
	public static void main(String s[]){
		JFrame f = new JFrame("Paisaje - 200710001010");
		f.setResizable(false);
		f.setSize(new Dimension(800,600));
		JApplet applet = new Paisaje();
		f.getContentPane().add("Center", applet);
		applet.init();
		f.setVisible(true);
	}
}