/* @(#)condvar.c
 */

#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <pthread.h>

#define HILOS 5

pthread_cond_t game, hand;
pthread_mutex_t lock;
int fin , cuenta , condicion;

void * fa (void * me) {
  long yo = (long) me;

  printf("entro %ld\n" , yo);
  
    pthread_mutex_lock( &lock ) ;
    while( condicion < 20 && !fin ) pthread_cond_wait( &hand , &lock ) ;
    printf("me liberaron %ld\n",yo) ;
    ++cuenta ;
    pthread_mutex_unlock( &lock ) ;
    if(cuenta >= HILOS ) {
      pthread_cond_signal( &game ) ;
      cuenta = 0 ;
    }
  

}

void * fb () {
  
  pthread_mutex_lock( &lock );

  sleep( 6);
  condicion = 21;
  sleep( 6);

  pthread_cond_broadcast( &hand );

  pthread_cond_wait( &game, &lock );

  pthread_mutex_unlock( &lock ); 

  puts("sale b");
}



int main(int argc, char * argv[])
{
  pthread_t a[HILOS] , b , b2;
  fin = 0;
  condicion = 5;
  int mtx = pthread_mutex_init( &lock , NULL );
  int con1 = pthread_cond_init( &game , NULL );
  int con2 = pthread_cond_init( &hand , NULL );

  long i,ra;
  for(i = 0; i < 5; ++i) ra =  pthread_create( &a[i], NULL, fa, (void*)i);
  sleep(8);
  int rb =  pthread_create( &b ,NULL ,fb , NULL );

  scanf("%d",&fin);
  sleep( 10 );
  //  rb =  pthread_create( &b2 ,NULL ,fb , NULL );

  for(i = 0; i < 5; ++i) pthread_join( a[i] , NULL );
  pthread_join( b , NULL );
  //  pthread_join( b2 , NULL );


  pthread_cond_destroy( &game );
  pthread_cond_destroy( &hand );
  pthread_mutex_destroy( &lock );
  return 0;
}
