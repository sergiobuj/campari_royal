/* @(#)sb_jugador.c
   AUTOR: Sergio Botero Uribe
   Creado para la practica de sistemas operativos (Manotazo).
   EAFIT 2010-1
*/


#include "sb_jugador.h"

/*
 */
void init_recursos_jugadores() {
  ronda_jugada = 1;
  poner_manos = 0;
  quitar_manos = 0;
  no_coinciden = 0;
  manos_en_centro = 0;

  perdedor_pasado = -1;
	
  pthread_mutex_init( &manotazo , NULL );
  pthread_mutex_init( &poner_mano , NULL );
  pthread_mutex_init( &quitar_mano , NULL );
	
  pthread_cond_init( &cond_poner_manos , NULL );
  pthread_cond_init( &cond_juego , NULL );
  pthread_cond_init( &cond_quitar_manos , NULL );
	
  pthread_mutex_unlock( &manotazo );
  pthread_mutex_unlock( &poner_mano );
  pthread_mutex_unlock( &quitar_mano );
	
}


/*
 */
void liberar_recursos_jugadores() {
	
  pthread_mutex_destroy( &manotazo );
  pthread_mutex_destroy( &poner_mano );
  pthread_mutex_destroy( &quitar_mano );
  pthread_cond_destroy( &cond_poner_manos );
  pthread_cond_destroy( &cond_quitar_manos );
  pthread_cond_destroy( &cond_juego );
	
}


/*
 */
void * manos(void * param) {
  long me = ( long ) param;
  pthread_t los_ojos;
  int estado_hilo = pthread_create( &los_ojos, NULL, ojos , (void *) me );
  if( estado_hilo ){
    fprintf( stderr, "%s" , crear_ojos_error);
    liberar_recursos();
    exit(EXIT_FAILURE);
  }
	
  while( !fin_del_juego ){
    pthread_mutex_lock( &mtx_jugadores[me] );
		
    if( !fin_del_juego ){
			
      if( cuenta_cartas[me] ){
				
        carta_siguiente = ( carta_siguiente + 1 ) % CARTAS_EN_PINTA;
        carta_a_poner = cartas_jugadores[me][cuenta_cartas[me] -1];
        cartas[ cartas_centro ] = carta_a_poner;
        ++cartas_centro;
        cartas_jugadores[me][cuenta_cartas[me] -1] = NO_CARTA;
        --cuenta_cartas[me];
				
        pthread_mutex_lock( &manotazo );
        poner_manos = 1;
        pthread_cond_broadcast ( &cond_poner_manos );
        pthread_cond_wait ( &cond_juego , &manotazo );
        pthread_mutex_unlock ( &manotazo );
				
      }
			
    }else{
      break;
    }
		
    int i;
    for( i = 0; i < num_jugadores; ++i){
      if( ( cuenta_cartas[i] == 0 && cartas_centro == 0 ) || cartas_centro == CARTAS ){
				
        pthread_mutex_lock ( &manotazo);
				
        pthread_mutex_lock( &mtx_juego );
        fin_del_juego = 1;
        pthread_cond_broadcast( &cond_fin_juego );
        pthread_mutex_unlock( &mtx_juego );
				
        poner_manos = 1;
        pthread_mutex_unlock ( &manotazo);
        pthread_cond_broadcast ( &cond_poner_manos );
				
        break;
      }
    }    
		
    if(perdedor_pasado == -1){
      pthread_mutex_unlock( &mtx_jugadores[SIGUIENTE] ); //me #defined
    } else {
      pthread_mutex_unlock( &mtx_jugadores[perdedor_pasado] ); //me #defined
      perdedor_pasado = -1;
    }

  }
	
  pthread_join( los_ojos , NULL );
	
  return NULL;
}


/*
 */
void * ojos(void * param) {
  long me = (long) param;
	
  while( !fin_del_juego ){
		
    pthread_mutex_lock( &manotazo );
    while( poner_manos != 1) pthread_cond_wait( &cond_poner_manos , &manotazo );
		
    if (fin_del_juego) {
      pthread_mutex_unlock( &manotazo );
      break;
    }
		
    if( carta_siguiente == carta_a_poner ){
			
      usleep( random_port( MILLISEG_MAX ));
			
      pthread_mutex_lock( &poner_mano );
			
      ++manos_en_centro;
      if( manos_en_centro == num_jugadores ){
        imprimir_juego( ronda_jugada );
        tomar_cartas(me);
        imprimir_juego( ronda_jugada );
        perdedor_pasado = me;
        carta_siguiente = -1;
        manos_en_centro = 0;
        poner_manos = 0;		
        ++ronda_jugada;
        int i;
        for(i=0; i < num_jugadores; ++i){
          if( cuenta_cartas[i] == 0  ){
						
            pthread_mutex_lock( &mtx_juego );
            fin_del_juego = 1;
            pthread_cond_broadcast( &cond_fin_juego );
            pthread_mutex_unlock( &mtx_juego );
						
          }
        }
				
      }
      pthread_mutex_unlock( &poner_mano );
      pthread_mutex_unlock( &manotazo );
			
      pthread_mutex_lock( &quitar_mano );
      ++quitar_manos;
			
      if( quitar_manos < num_jugadores ){
        pthread_cond_wait( &cond_quitar_manos ,&quitar_mano );
      }else if (quitar_manos == num_jugadores) {
        quitar_manos = 0;
        pthread_cond_broadcast( &cond_quitar_manos );
        pthread_cond_signal ( &cond_juego );
      }
      pthread_mutex_unlock( &quitar_mano );
			
			
    }else{
			
      pthread_mutex_unlock( &manotazo );
      pthread_mutex_lock( &quitar_mano );
      ++no_coinciden;
			
      if( no_coinciden < num_jugadores ){
        pthread_cond_wait( &cond_quitar_manos ,&quitar_mano );
      }else if (no_coinciden == num_jugadores) {
        no_coinciden = 0;
        poner_manos = 0;
        pthread_cond_broadcast( &cond_quitar_manos );
        pthread_cond_signal ( &cond_juego );
      }
      pthread_mutex_unlock( &quitar_mano );
    }
		
		
		
		
  }
  return NULL;
}


/*
 */
void * tomar_cartas(long me) {
  fprintf( stdout , "%s %ld\n" , jugador_pierde , me + 1 );
  int mazo_aux[CARTAS], i;
  for(i=0; i < CARTAS; ++i ) mazo_aux[i] = NO_CARTA;

  /* Se recogen las cartas de la mesa y la que est� m�s arriba queda despu�s de las que se tienen.
    for(i=0; i < cartas_centro; ++i){
    mazo_aux[i] = cartas[i];
    cartas[i] = NO_CARTA;
    }
  */

  /* Se recogen las cartas de la mesa y la que est� m�s arriba queda en el fondo. */
  for(i=0; i < cartas_centro; ++i){
    mazo_aux[cartas_centro - i -1] = cartas[i];
    cartas[i] = NO_CARTA;
  }
  /***/

  for(i=0; i < cuenta_cartas[me]; ++i)
    mazo_aux[cartas_centro + i] = cartas_jugadores[me][i];
	
  cuenta_cartas[me] += cartas_centro;
  cartas_centro = 0;
	
  for(i=0; i < cuenta_cartas[me]; ++i)
    cartas_jugadores[me][i] = mazo_aux[i];
  return NULL;
}


/*
 */
void forzar_salida() {
  fin_del_juego = 1;
  pthread_mutex_unlock( &poner_mano );
}
