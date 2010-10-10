#ifndef tracescene_h
#define tracescene_h

#include "primitives.h"

Vector* GenerateRayDirectionTable();

void TraceScene(Primitive *primitives, int numPrimitives, LightSource *lightSources, int numLightSources, ColorFloat* buffer, Vector *directionTable);

#endif
