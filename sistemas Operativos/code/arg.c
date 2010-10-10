/* @(#)arg.c
 */
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
//#include "arg.h"
#include <pthread.h>
#define THREADS 4

pthread_t threads[THREADS];
typedef struct {
  int a,b,c;
}args;

void * threadf(void *parm){
  args *mine = parm;
  int aa= mine->a,bb=mine->b;
  printf("a-> %d  -  b-> %d\n",aa,bb);
  pthread_exit(NULL);
}

int main()
{
  int i;
  args *main;
  for(i=0; i< THREADS ; ++i){
    main->a = i;
    pthread_create(&threads[i],NULL,threadf,(void*) main);
  }

  for(i=0; i< THREADS ; ++i){
    pthread_join(threads[i],NULL);
  }
  return 0;
}
