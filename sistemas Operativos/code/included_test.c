/* @(#)included_test.c
 */
#include "included_test.h"

void * return_sum( void *  args)
{
  long one= (long)args,two=3;
  //  while(fin){
  printf("before ->>> %ld\n",one);
  //  sleep(1);
  pthread_mutex_lock(&only_mtx);
  //  pthread_mutex_lock(&mtx[one]);
  printf("I'm in ->>> %ld\n",one);
  //    pthread_mutex_unlock(&mtx[(one+1)%4]);

  //  }
  return NULL;
}
