#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

typedef struct {
  int a,b;
} s_param;


void *
threadfunc(void *parm)
{
  s_param *param = parm; 
  printf("ID:%d y valor:%d\n",param->a,param->b);
  pthread_exit(NULL);
}

int main(int argc, char **argv)
{
  pthread_t thread[3];
  int rc=0,i;
  void * status;

  s_param param;
  param.b=10;//cualquier cosa
  for(i=0; i<3 ; ++i){
    param.a=i;
    rc = pthread_create(&thread[i], NULL, threadfunc, &param ); // !!!!
    if(rc){
      free(thread);      
      exit(1);
    }
  }  

  for(i=0; i<3 ; ++i){
    pthread_join(thread[i],&status);
  }
  
  //  realloc(thread,0);
  return 0;
}
