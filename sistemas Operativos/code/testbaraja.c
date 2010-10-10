/*
 *  testbaraja.c
 *  
 *
 *  Created by Sergio on 4/11/10.
 *  Copyright 2010 sergiobuj. All rights reserved.
 *
 */
#include <stdio.h>
#include <time.h>

#define CARTAS 52
#define NO_CARTA -1
#define num_jugadores 10
int cuenta_cartas[ num_jugadores ];
int cartas_jugadores[ num_jugadores ][ CARTAS ];
int cartas[CARTAS];
/*
 */
void repartir_cartas() {
  int i,j,k,l;
  for(i = 0; i < CARTAS ; ++i) cuenta_cartas[i] = 0;
  
  for(j = 0,k = 0; j < CARTAS; ++j){
    for(l = 0; l < num_jugadores; ++l){
      
      i = (3 + l) % num_jugadores;

      if(k < CARTAS){
	cartas_jugadores[i][j] = cartas[k];
	cartas[k] = NO_CARTA;
	++cuenta_cartas[i];
      }else{
	cartas_jugadores[i][j] = NO_CARTA;
      }
      ++k;
    }
  }
}

/*
 */
void imprimir_juego_v() {
  int i, j, k, karta, maxj = 0;

  for(i = 0 ; i < num_jugadores; ++i)
    if (cuenta_cartas[i] > maxj) {
      maxj = cuenta_cartas[i];
    }
	
  if( maxj == CARTAS ) maxj = CARTAS-1;
	
  for(j = maxj ; j >= 0 ; --j  ){
    printf("|\t");
    for(i = 0; i < num_jugadores ; ++i){
      karta = cartas_jugadores[i][j];
      printf("%d\t" ,  (karta) );
    }
    puts("");
  }
	
  printf("|\t");
  for(i = 0; i < num_jugadores ; ++i) printf("(%d)\t",cuenta_cartas[i]);
  puts("");
  printf("|\t");
  for(i = 0; i < num_jugadores ; ++i) printf("J#%d\t",i+1);
  puts("");
	
}



int main(){
  srand((unsigned)time(0));
  int i;
  for (i = 0; i < CARTAS; ++i )
    cartas[i] = i + 1;
  
  repartir_cartas();
  imprimir_juego_v();

  return 0;
}
