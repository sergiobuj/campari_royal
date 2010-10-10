#ifdef __APPLE__
#include "GLUT/GLUT.h"
#else
#include "GL/glut.h"
#endif

bool keyN[256];
bool keyS[21];
//Luz uno
GLfloat LA1[]= { 0.0f, 0.0f, 0.4f, 1.0f };
GLfloat LD1[]= { 0.8f, 0.8f, 0.8f, 1.0f };
GLfloat LS1[]= { 1.0f, 1.0f, 1.0f, 1.0f };
GLfloat LP1[]= { 2.0f, 0.0f, 5.0f, 1.0f };
//Luz dos
GLfloat LA2[]= { 0.3f, 0.3f, 0.3f, 1.0f };
GLfloat LD2[]= { 0.0f, 0.0f, 0.8f, 1.0f };
GLfloat LS2[]= { 0.0f, 0.0f, 1.0f, 1.0f };
GLfloat LP2[]= { 0.0f, 0.0f, -5.0f, 1.0f };
//Shoulder
GLfloat MA1[]= {0.2f, 0.2f, 0.2f, 1.2f};
GLfloat MS1[]= {0.3f, 0.0f, 0.0f, 1.0f};
//Elbow
GLfloat MA2[]= {0.5f, 0.3f, 0.3f, 1.3f};
GLfloat MS2[]= {0.0f, 0.3f, 0.0f, 1.0f};
//Wrist
GLfloat MA3[]= {0.4f, 1.0f, 0.3f, 1.0f};
GLfloat MS3[]= {0.0f, 0.0f, 0.3f, 1.0f};
//Finger
GLfloat MA4[]= {0.3f, 0.3f, 0.3f, 1.0f};
GLfloat MS4[]= {0.3f, 0.5f, 0.35f, 1.5f};
GLfloat rShoulderh = 0.0f, rShoulderv = 0.0f, rShoulderp = 0.0f;
GLfloat rElbow = 0.0f;
GLfloat rWrist = 0.0f;
GLfloat rFinger1 = 0.1f, rFinger2 = 0.0f;
GLfloat LightAmbient[]= { 0.5f, 1.5f, 0.3f, 0.7f };
GLfloat LightPosition[]= { 0.0f, 1.0f, 1.0f, 1.0f };
float mcolor[] = { 1.0f, 0.0f, 0.0f, 1.0f };
void drawCartesian(float R,float G,float B)
{
  //Position the plane on the center of the shoulder
  //glTranslatef(0.0f, 0.5f, 0.0f);
  //Saves the current color
  glPushAttrib(GL_CURRENT_BIT);
  //glColor3f(0.0f, 0.0f, 0.8f);
  glColor3f(R, G, B);
  //draw the axis
  glBegin(GL_LINES);
  //X
  glVertex3f(0.0f, 0.0f, 0.0f);
  glVertex3f(0.7f, 0.0f, 0.0f);
  glVertex3f(0.7f, -0.1f, 0.0f);
  glVertex3f(0.8f, 0.1f, 0.0f);
  glVertex3f(0.8f, -0.1f, 0.0f);
  glVertex3f(0.7f, 0.1f, 0.0f);
  //Y
  glVertex3f(0.0f, 0.0f, 0.0f);
  glVertex3f(0.0f, 0.7f, 0.0f);
  glVertex3f(0.06f, 0.95f, 0.0f);
  glVertex3f(0.0f, 0.85f, 0.0f);
  glVertex3f(-0.06f, 0.95f, 0.0f);
  glVertex3f(0.0f, 0.85f, 0.0f);
  glVertex3f(0.0f, 0.85f, 0.0f);
  glVertex3f(0.0f, 0.75f, 0.0f);
  //Z
  glVertex3f(0.0f, 0.0f, 0.0f);
  glVertex3f(0.0f, 0.0f, 0.7f);
  glVertex3f(0.0f, 0.05f, 0.85f);
  glVertex3f(0.0f, 0.05f, 0.75f);
  glVertex3f(0.0f, 0.05f, 0.75f);
  glVertex3f(0.0f, -0.05f, 0.85f);
  glVertex3f(0.0f, -0.05f, 0.85f);
  glVertex3f(0.0f, -0.05f, 0.75f);
  glEnd();
  //Restores the color
  glPopAttrib();
}
void draw(void)
{
  glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
  glPushMatrix();
  //Arm
  glRotatef(rShoulderv,1.0f, 0.0f, 0.0f);
  glRotatef(rShoulderp,0.0f, 1.0f, 0.0f);
  glRotatef(rShoulderh, 0.0f, 0.0f, 1.0f);
  //Draw the cartesian plane
  glPushMatrix();
  //  drawCartesian(0.0,0.3,0.2);
  glPopMatrix();

  glTranslatef(0.0f, 0.6f, 0.0f);     
   
  glPushMatrix();
  glScalef(0.6, 1.5f, 0.6f);
  glMaterialfv(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, MA1);
  glMaterialfv(GL_FRONT, GL_SPECULAR, MS1);
  glutSolidCube(0.5f);
  glPopMatrix();

  //Elbow
  glTranslatef(0.0f, 0.4f, 0.0f);
  glRotatef(rElbow, 0.0f, 0.0f, 1.0f);
  glTranslatef(0.0f, 0.4f, 0.0f);
 
  glPushMatrix();
  glScalef(0.6, 1.7f, 0.6f);
  glMaterialfv(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, MA2);
  glMaterialfv(GL_FRONT, GL_SPECULAR, MS2);
  glutSolidCube(0.5f);
  glPopMatrix();

  //Wrist
  glTranslatef(0.0f, 0.55f, 0.0f);
  glRotatef(rWrist, 0.0f, 1.0f, 0.0f);
 
  glPushMatrix();
  glScalef(0.5, 0.5f, 0.5f);
  glMaterialfv(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, MA3);
  glMaterialfv(GL_FRONT, GL_SPECULAR, MS3);
  glutSolidCube(0.5f);
  glPopMatrix();

  glMaterialfv(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, MA4);
  glMaterialfv(GL_FRONT, GL_SPECULAR, MS4);

  //Finger1
  glPushMatrix();
  glRotatef(rFinger1, 0.0f, 0.0f, 1.0f);
  glTranslatef(0.1f, 0.26f, 0.0f);
  glPushMatrix();
  glScalef(0.2, 0.5f, 0.2f);
  glutSolidCube(0.9f);
  glPopMatrix(); 
  glPopMatrix();
 
  //Finger2
  glPushMatrix();
  glRotatef(rFinger2, 0.0f, 0.0f, 1.0f);
  glTranslatef(-0.1f, 0.26f, 0.0f);
  glPushMatrix();
  glScalef(0.2, 0.5f, 0.2f);
  glutSolidCube(0.5f);
  glPopMatrix(); 
  glPopMatrix();

  glPopMatrix();

  //Light1
  glPushMatrix();
  glDisable(GL_LIGHTING);
  glColor3f(1.5f, 0.0f, 1.0f);
  glTranslatef(LP1[0], LP1[1], LP1[2]);
  glutSolidSphere(0.05f, 5, 5);
  glEnable(GL_LIGHTING);
  glPopMatrix();

  //Light2
  glPushMatrix();
  glColor3f(0.0f, 0.0f, 1.0f);
  glDisable(GL_LIGHTING);
  glTranslatef(LP2[0], LP2[1], LP2[2]);
  glutSolidSphere(0.05f, 5, 5);
  glEnable(GL_LIGHTING);
  glPopMatrix();

  glutSwapBuffers();
}

void update()
{
  //Rotation for the shoulder
  if(keyN['s'] || keyN['S'])
    rShoulderv += 0.03;
  if(keyN['w'] || keyN['W'])
    rShoulderv -= 0.03;
  if(keyN['a'] || keyN['A'])
    rShoulderh += 0.03;
  if(keyN['d'] || keyN['D'])
    rShoulderh -= 0.03;
  if(keyN['q'] || keyN['Q'])
    rShoulderp += 0.03;
  if(keyN['e'] || keyN['E'])
    rShoulderp -= 0.03;

  //Rotation for the elbow
  if(keyS[GLUT_KEY_UP])
    rElbow += 0.05;
  if(keyS[GLUT_KEY_DOWN])
    rElbow -= 0.05;

  //Rotation of the wrist
  if(keyS[GLUT_KEY_LEFT])
    rWrist += 0.05;
  if(keyS[GLUT_KEY_RIGHT])
    rWrist -= 0.05;

  //Finger Movement
  //Finger1
  if(keyN['u'] || keyN['U'])
  {
    rFinger1 += 0.03;
    if(rFinger1 > 7)
      rFinger1 = 7;
  }
  if(keyN['j'] || keyN['J'])
  {
    rFinger1 -= 0.03;
    if(rFinger1 < -20)
      rFinger1 = -20;
  }
  //Finger2
  if(keyN['i'] || keyN['I'])
  {
    rFinger2 -= 0.03;
     if(rFinger2 < -7)
      rFinger2 = -7;
  }
  if(keyN['k'] || keyN['K'])
  {
    rFinger2 += 0.03;
    if(rFinger2 > 20)
      rFinger2 = 20;
  }

  //Draw the scene
  draw();
}

void keyDown(unsigned char key, int x, int y)
{
  keyN[key] = true;
}

void keyUp(unsigned char key, int x, int y)
{
  keyN[key] = false;
}

void keySDown(int key, int x, int y)
{
  keyS[key] = true;
}

void keySUp(int key, int x, int y)
{
   keyS[key] = false;
}

void resize(int w, int h)
{
  // Prevent a divide by zero, when window is too short
  // (you cant make a window of zero width).
  if(h == 0)
    h = 1;
  
  float ratio = 1.0* w / h;
  
  // Reset the coordinate system before modifying
  glMatrixMode(GL_PROJECTION);
  glLoadIdentity();
  
  // Set the viewport to be the entire window
  glViewport(0, 0, w, h);
  
  // Set the correct perspective.
  gluPerspective(45,ratio,1,500);
  glMatrixMode(GL_MODELVIEW);
  glLoadIdentity();
  gluLookAt(0.0,0.0,8.0, 
            0.0,0.0,0.0,
            0.0f,1.0f,0.0f);

}

void initGl()
{
  resize(800, 600);

  glEnable(GL_LIGHTING);
  glEnable(GL_LIGHT0);
  glEnable(GL_CULL_FACE);
  
}

int main(int args, char **argv)
{
  glutInit(&args, argv);
  glutInitDisplayMode(GLUT_DEPTH | GLUT_DOUBLE | GLUT_RGBA);
  glutInitWindowPosition(100,100);
  glutInitWindowSize(800,600);
  glutCreateWindow("Alejandro Pelaez - Nicolas Hock - Sergio Botero -- Reto 3");

  glutKeyboardFunc(keyDown);
  glutSpecialFunc(keySDown);
  glutKeyboardUpFunc(keyUp);
  glutSpecialUpFunc(keySUp);

  glutReshapeFunc(resize);
  glutDisplayFunc(draw);
  glutIdleFunc(update);

  initGl();
  glutMainLoop();
}

