
#include <OpenGL/Gl.h>
#include <GLUT/glut.h>
#include <iostream.h>
#include <fstream.h>

//**************Global Data
char ifileName[30],oFileName[30];
fstream inFile,outFile;

//************ Data structure 
struct GLfloatPoint
{ GLfloat x,y;
};

const int MAX = 100;
class GLfloatPointArray
{
public:
  int num;
  GLfloatPoint pt[MAX];
};

//***************** subprograms
typedef GLfloat colorType[3];
// subprogram used to draw the control points separately
void drawDot (GLfloat x, GLfloat y, GLfloat r, GLfloat g, GLfloat b)
{ glColor3f(r,g,b);
  glBegin (GL_POINTS);
	  glVertex2f (x,y);
  glEnd();
}
// Drawing subprogram - this will draw the curve from a set of points
void drawFloatPolyLine (GLfloatPointArray P, colorType c)
{ glColor3fv (c);
  glBegin(GL_LINE_STRIP);
   for (int i=0; i < P.num; i++)
     glVertex2f (P.pt[i].x,P.pt[i].y);
  glEnd();
}

//******************** myInit 
 void myInit(void)
 {
    glClearColor(1.0,1.0,1.0,0.0);  // set white background color
    glColor3f (0.0f,0.0f,0.0f);    //default color
    glMatrixMode(GL_PROJECTION); 
    glLoadIdentity();
    gluOrtho2D(0.0, 640.0, 0.0, 480.0);
    // get data files
    cout << "Enter the input file name: ";
    cin >> ifileName;
    inFile.open (ifileName,ios::in);
    if (inFile.fail())
      return;
    // if want to see points for debugging add output
	// cout << "Enter the output file name: ";
	// cin >> oFileName;
	// outFile.open (oFileName,ios::out);
	// if (outFile.fail())
	//   return;
}

//***************** BEZIER Curve subprograms
// Read the control points 
void readControlPoints (GLfloatPointArray &P)
{
  inFile >> P.num;
  for (int j = 0; j < P.num; j++)
    inFile >> P.pt[j].x >> P.pt[j].y;
}
// output control points to a text file - if you want to see the 
// computations
void printPointArray (GLfloatPointArray P)
{
  outFile << "Size: " << P.num << endl << "Points:" << endl;
  for (int j = 0; j < P.num; j++)
    outFile << "(" << P.pt[j].x << "," << P.pt[j].y << ")" << endl;
}

const int MAXCONTPTS = 100;
int c[MAXCONTPTS];   // the binomial coefficients
//helper routines - compute the coefficient
void ComputeCoeff (int n)
{ int j,k;
  for (k=0;k<=n;k++)
  { //compute n! / (k!*(n-k)!)
    c[k] = 1;
    for (j = n;j>=k+1;j--)
      c[k] *=j;
    for (j = n-k;j>=2;j--)
      c[k] /= j;
  }
}
// compute the blending value
float BlendingValue (int n, int k, float t)
{ int j;
  float bv;
  // compute  c[k]*t^k * (1-t)^(n-k)
  bv = c[k];
  for (j=1; j<=k;j++)
    bv *= t;
  for (j = 1;j<=n-k;j++)
    bv *= (1-t);
  return bv;
}

// compute one point on the Bezier curve - fixed value of t
void ComputePoint (float t, int n, GLfloatPoint & p, 
				   GLfloatPointArray ctrlPts)
{ int k;
  float b;
  p.x = 0.0;
  p.y = 0.0;
  for (k = 0; k<=n;k++)
  {  b = BlendingValue (n,k,t);
     p.x += ctrlPts.pt[k].x*b;
     p.y  += ctrlPts.pt[k].y*b;
  }
}
// compute the array of Bezier points - drawing done separately
void Bezier ( GLfloatPointArray controlPts, int numInter, 
			  GLfloatPointArray & curve)
{ // there are numContPts+1 control points and numInter t values to evaluate the curve
  int k;
  float t;
  ComputeCoeff (controlPts.num-1);
  curve.num = numInter+1;
  for (k=0; k<=numInter; k++)
  { t = (float) k / (float) numInter;
    ComputePoint (t, controlPts.num-1,curve.pt[k],controlPts);
  }
}

//************************ myDisplay 
void myDisplay(void)
{  
   int numbCurves;
   GLfloatPointArray ControlPts,BezCurve;
   colorType C = {0.0f,1.0f,0.0f};
  
   glClear(GL_COLOR_BUFFER_BIT);     // clear the screen 

   inFile >> numbCurves;
   for (int i = 0; i < numbCurves; i++)
   { 
     // read control points and draw them in red big points
     readControlPoints (ControlPts);
	 glPointSize (4.0);
	 for (int j = 0; j < ControlPts.num; j++)
       drawDot (ControlPts.pt[j].x,ControlPts.pt[j].y,1,0,0);
	 glPointSize (1.0);
	 // Compute the Bezier curve points and draw
	 Bezier (ControlPts,50,BezCurve);
       // draw the Bezier curve
	 drawFloatPolyLine (BezCurve,C);
	 glFlush ();
   }
}

//**************************** main
int main(int argc, char** argv)
{
	glutInit(&argc, argv);          // initialize the toolkit
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB); // set display mode
	glutInitWindowSize(640,480);     // set window size
	glutInitWindowPosition(100, 150); // set window position on screen
	glutCreateWindow("Bezier Curve drawing"); // open the screen window
	glutDisplayFunc(myDisplay);     // register redraw function
	myInit();                   
	glutMainLoop(); 		     // go into a perpetual loop
	return 0;
}
