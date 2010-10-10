/* @(#)include_test.c
 */
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <pthread.h>
#include "include_test.h"
#include "included_test.h"
#include <time.h>

int main(int argc, char * argv[])
{
  srand(time(0));
  fin=1;
  if(argc>2){
    //    int ans = return_sum( atoi(/)  );
    printf("suma %d\n", atoi(argv[1]) + atoi(argv[2]) );
  }else{
    printf("pffffffff....\n");
  }
  
  pthread_t t1,t2,t3,t4;
  void * st;
  int i,t_st;
  //  mtx = PTHREAD_MUTEX_INITIALIZER ;
  for(i=0; i<4; ++i){
    t_st = pthread_mutex_init(&mtx[i], NULL);
    pthread_mutex_lock(&mtx[i]);
  }
  t_st = pthread_mutex_init(&only_mtx, NULL);
  pthread_mutex_lock(&only_mtx);
  printf("t_st %d\n",t_st);
  params go;
  go.p_one = 0;
  t_st=pthread_create( &t1,NULL,return_sum,(void*)go.p_one );
  go.p_one = 1;
  t_st=pthread_create( &t2,NULL,return_sum,(void*)go.p_one );
  go.p_one = 2;
  t_st=pthread_create( &t3,NULL,return_sum,(void*)go.p_one );
  go.p_one = 3;
  t_st=pthread_create( &t4,NULL,return_sum,(void*)go.p_one );

  //  pthread_mutex_unlock(&mtx[arc4random()%4]);
  sleep(5);
  printf("dale\n\n\n");
  pthread_mutex_unlock(&only_mtx);
  //  scanf("%d",&fin);

  pthread_join(t1,&st);
  pthread_join(t2,&st);
  pthread_join(t3,&st);
  pthread_join(t4,&st);

  for(i=0; i<4; ++i)
    t_st = pthread_mutex_destroy(&mtx[i]);
    t_st = pthread_mutex_destroy(&only_mtx);

  return 0;
}
