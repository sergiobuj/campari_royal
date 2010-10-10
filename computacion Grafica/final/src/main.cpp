#include "lib/primitives.h"

// allocate back buffer
ColorFloat* backBuffer;

/*alboroto opengl*/
#define ESCAPE 27
#include <unistd.h>
#include <cstdlib>
#include <cstdio>
int window;
int width=640,height=480,initx=40,inity=40;

void InitGL(int Width, int Height){
  glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
  glClearDepth(1.0);
  glDepthFunc(GL_LESS);
  glEnable(GL_DEPTH_TEST);
  glShadeModel(GL_SMOOTH);
  glMatrixMode(GL_PROJECTION);
  glLoadIdentity();
  //  gluPerspective(45.0f,(GLfloat)Width/(GLfloat)Height,0.1f,100.0f);	// Calculate The Aspect Ratio Of The Window
  glMatrixMode(GL_MODELVIEW);

}

void DrawGLScene(){
  glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
  glLoadIdentity();
  glDrawPixels(640,480,GL_RGB,GL_FLOAT,backBuffer);
  glutSwapBuffers();
}

void keyPressed(unsigned char key, int x, int y){
  usleep(100);
  if (key == ESCAPE){ 
      glutDestroyWindow(window); 
      exit(0);               
    }
}
/*fin alboroto opengl*/


void SetupScene(Primitive *primitives, int numPrimitives, Vector *vertices, int numVertices, LightSource *lightSources, int numLightSources)
{
  AssignPrimitiveType(primitives[0], TRIANGLE_TYPE);
  primitives[0].triangleProperties->v1=&vertices[0];
  primitives[0].triangleProperties->v2=&vertices[1];
  primitives[0].triangleProperties->v3=&vertices[2];
}
void Scene(Primitive *primitives, int numPrimitives, Vector *vertices, int numVertices, LightSource *lightSources, int numLightSources)
{  
  //leer color
  float r,g,b;
  scanf("%f%f%f",&r,&g,&b);
  primitives[0].surface.baseColor.r = r*255;
  primitives[0].surface.baseColor.g = g*255;
  primitives[0].surface.baseColor.b = b*255;
  primitives[0].surface.reflectivity=1;


  //leer pos de la luz  
  float xl,yl,zl;
  scanf("%f%f%f",&xl,&yl,&zl);
  lightSources[0].location.x = xl;
  lightSources[0].location.y = yl;
  lightSources[0].location.z = zl;
  lightSources[0].color.r = 255;
  lightSources[0].color.g = 255;
  lightSources[0].color.b = 255;
  
  float x,y,z;
  scanf("%f%f%f",&x,&y,&z);
  VectorSetXYZ(vertices[0], x, y, z); 	//Rotate(vertices[0], currTime*1.4, currTime, currTime*1.2352);
  scanf("%f%f%f",&x,&y,&z);
  VectorSetXYZ(vertices[1], x, y, z);//	Rotate(vertices[1], currTime*1.4, currTime, currTime*1.2352);
  scanf("%f%f%f",&x,&y,&z);
  VectorSetXYZ(vertices[2], x, y, z);//	Rotate(vertices[2], currTime*1.4, currTime, currTime*1.2352);
}

int main (int argc, char * argv[]){
  backBuffer = new ColorFloat[640*480];
  // allocate the ray direction lookup table
  Vector *directionTable = GenerateRayDirectionTable();

  const int numPrimitives = 1;
  Primitive *primitives = new Primitive[numPrimitives];
  
  const int numLightSources = 1;
  LightSource *lightSources = new LightSource[numLightSources];

  const int numVertices = 4;

  Vector *vertices = new Vector[numVertices];
  Scene(primitives, numPrimitives, vertices, numVertices, lightSources, numLightSources);
  
  SetupScene(primitives, numPrimitives, vertices, numVertices, lightSources, numLightSources);

  TraceScene(primitives, numPrimitives, lightSources, numLightSources, backBuffer, directionTable);

  /*alboroto para opengl*/
  glutInit(&argc, argv);  
  glutInitDisplayMode(GLUT_RGBA | GLUT_DOUBLE | GLUT_ALPHA | GLUT_DEPTH);  
  glutInitWindowSize(width, height);  
  glutInitWindowPosition(initx, inity);  
  window = glutCreateWindow("final");
  glutDisplayFunc(&DrawGLScene);  
  glutIdleFunc(&DrawGLScene);
  glutKeyboardFunc(&keyPressed);
  InitGL(width, height);

  /*  float * a = new float[3];
      glGetFloatv(GL_CURRENT_RASTER_POSITION,a);
      printf("x=%f y=%f z=%f\n",a[0],a[1],a[2]);*/
  glutMainLoop();
  /*fin alboroto de opengl*/

  // clean up
  for(int i=0; i<numPrimitives; i++) ClearPrimitiveType(primitives[i]);    
  delete[] lightSources;
  delete[] vertices;
  delete[] directionTable;
  delete[] backBuffer;
  return 0;
}
