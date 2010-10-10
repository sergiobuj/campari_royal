/* @(#)shuffle_test.c
 */
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <time.h>

#define SWAP(a,b)({(a)^=(b);(b)^=(a);(a)^=(b);})

//#include "shuffle_test.h"

void shuff(int cards[])
{
  int i,j;
  for( i=51; i>0; --i){
    j=(arc4random())%(i+1); 
    SWAP(cards[i],cards[j]);
  }

}


void gen_cards(int cards[])
{
  int j,i,k=0;
  for( i=0; i<4; ++i){
    for( j=0; j<13; ++j){
      cards[k]=j;
      k++;
    }
  }

}
void print(int cards[])
{
  int i;
  for(i=0; i<52; ++i)
    printf("%d ",cards[i]);
  printf("\n");
}

int main()
{
  srand((unsigned)(time(0)));
  int cards[52];
  
  gen_cards( cards  );
  print( cards );
  shuff( cards );
  print( cards );
  shuff( cards );
  print( cards );
  shuff( cards );
  print( cards );
  
  return 0;
}
