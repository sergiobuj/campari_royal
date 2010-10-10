/*
  Sergio Botero Uribe 200710001010
  Computación Gráfica
  Febrero 2009 
*/
#include <iostream>
#ifdef __APPLE__
#include<GLUT/GLUT.h>
#include<OpenGL/OpenGL.h>
#else
#include <gl\gl.h>
#include <gl\glu.h>
#include <gl\glut.h>
#endif

GLfloat rota=0.0;
GLfloat swingueo=0.0;
void resize(int w,int h){
  glViewport(0, 0, w, h);
  glMatrixMode(GL_PROJECTION);
  glLoadIdentity();
  gluPerspective(45, (double)w / (double)h, 2, 200);
}
void update(int value){
  rota+=2.0f;
  if(rota>=360)
    rota-=360;
  glutPostRedisplay();
  glutTimerFunc(25,update,0);
}
void drawscene(){
  glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
  glMatrixMode(GL_MODELVIEW);
  glLoadIdentity();
  glTranslatef(-0.50f, 0.0f, -5.0f);
  glPushMatrix();
  glColor3f(1.0f, 0.0f,0.0f );
  glTranslatef(0.5f, 0.5f, 0.0f);
  glColor3f(0.0f, 1.0f,0.0f );
  glRotatef(rota, -0.0f, -0.0f, -0.001f);
  glRotatef(rota, -1.0f, 0.0f, 0.0f);
  //adelante
  glBegin(GL_TRIANGLES);
  glVertex3f(-0.5f, -0.50f, 0.0f);
  glColor3f(0.0f, 1.0f,0.0f );
  glVertex3f(0.5f, -0.5f, 0.0f);
  glColor3f(0.0f, 0.0f,1.0f );
  glVertex3f(0.0f,0.50f, -0.50f);
  //atras
  glColor3f(0.0f, 1.0f, 0.0f);
  glVertex3f(-0.5f, -0.50f, -1.0f);
  glColor3f(0.0f, 1.0f,0.0f );
  glVertex3f(0.5f, -0.5f, -1.0f);
  glColor3f(0.0f, 0.0f,1.0f );
  glVertex3f(0.0f,0.50f, -0.50f);
  //izq
  glColor3f(0.0f, 0.0f, 1.0f);
  glVertex3f(-0.5f, -0.50f, -1.0f);
  glColor3f(0.0f, 1.0f,0.0f );
  glVertex3f(-0.50f, -0.50f, 0.0f);
  glColor3f(0.0f, 0.0f,1.0f );
  glVertex3f(0.0f,0.50f, -0.50f);
  //der
  glColor3f(0.50f, 0.50f, 0.50f);
  glVertex3f(0.5f, -0.50f, -1.0f);
  glVertex3f(0.50f, -0.50f, 0.0f);
  glColor3f(0.0f, 0.0f,1.0f );
  glVertex3f(0.0f,0.50f, -0.50f);
  glEnd();
  //fondo
  glBegin(GL_QUADS);
  glColor3f(0.0f, 1.0f, 0.0f);
  glVertex3f(-0.5f, -0.50f, 0.0f);
  glVertex3f(0.50f, -0.50f, 0.0f);
  glColor3f(0.0f, 1.0f,1.0f );
  glVertex3f(0.5f, -0.50f, -1.0f);
  glVertex3f(-0.5f, -0.50f, -1.0f);
  glEnd();
  glPopMatrix();
  glutSwapBuffers();
}

int main (int argc, char ** const argv) {
  glutInit(&argc, argv);
  glutInitDisplayMode(GLUT_DOUBLE|GLUT_RGB|GLUT_DEPTH);
  glutInitWindowSize(400, 400);
  glutCreateWindow("reto 2 - Sergio Botero Uribe 200710001010");	
  glEnable(GL_DEPTH_TEST);
  glutDisplayFunc(drawscene);
  glutReshapeFunc(resize);
  glutTimerFunc(25,update,0);
  glutMainLoop();
  return 0;
}
