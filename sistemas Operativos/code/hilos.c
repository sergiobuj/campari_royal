#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void *threadfunc(void *parm)
{
  printf("Inside secondary thread:%d\n",arc4random()%10);
  pthread_exit(NULL);
}

int main(int argc, char **argv)
{
  pthread_t *thread;
  int rc=0;
  void * status;
  srand((unsigned)time(0));  
  int i,j,players=2;
  scanf("%d",&players);
  void * threads_ptr =  realloc(thread,(players*sizeof(pthread_t)));  
  if(!threads_ptr){
    printf("error on pthreads\n");
    //    free(threads_ptr);
    free(thread);
    exit(1);
  }
  thread = (pthread_t*)threads_ptr;
  for(i=0; i<players ; ++i){
    int *ptr = &i;
    rc = pthread_create(&thread[i], NULL, threadfunc, (void *)ptr );
    if(rc){
      printf("error on %d\n",i);
      //      free(threads_ptr);
      free(thread);      
      exit(1);
    }
  }  
  for(j=0; j<players ; ++j){
    pthread_join(thread[j],&status);
    printf("joined %d\n",j);
  }
  //  free(threads_ptr);
  free(thread);
  //  pthread_detach(thread);
  printf("Main completed\n");  return 0;
}
