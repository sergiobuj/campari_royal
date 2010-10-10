#include "lib/primitives.h"

Vector* GenerateRayDirectionTable()
{
  Vector *direction = new Vector[640*480];

  for(int y=0; y<480; y++)
    for(int x=0; x<640; x++)
      {
	Vector &currDirection = direction[x+y*640];
	currDirection.x = x - 320;
	currDirection.y = y - 240;
	currDirection.z = 58;//+.4*sqrt( (x-320)*(x-320) + (y-240)*(y-240)); // fisheye
	VectorNormalize(currDirection);
      }

  return direction;
}

void CleanUpRayDirectionTable(Vector *direction)
{
  delete[] direction;
}

void TraceScene(Primitive *primitives, int numPrimitives, LightSource *lightSources, int numLightSources,ColorFloat* buffer, Vector *directionTable)
{
  // view
  Ray primaryRay;
  primaryRay.origin.x = 0;
  primaryRay.origin.y = 0;
  //  primaryRay.origin.z = -270;
  primaryRay.origin.z = -50;
    for(int y=0; y<480; y++)
    for(int x=0; x<640; x++)
      
      {                
	primaryRay.direction = directionTable[x + (y*640)]; 
	ColorFloat color = TraceRay(-1, primaryRay, primitives, numPrimitives, lightSources, numLightSources, 0);           
	if(color.r>255) color.r=255;
	if(color.g>255) color.g=255;
	if(color.b>255) color.b=255;  
	//	printf("%.0f %.0f %.0f ",color.r,color.g,color.b);
	buffer[ x +  (y*640) ].r = (color.r/255);
	buffer[ x +  (y*640) ].g = (color.g/255);
	buffer[ x +  (y*640) ].b = (color.b/255);
      }
}
