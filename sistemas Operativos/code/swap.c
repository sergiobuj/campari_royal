/* @(#)swap.c
 */
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
//#include "swap.h"
#define SWAP(a,b)({(a)^=(b);(b)^=(a);(a)^=(b);})
int main(int argc, char * argv[])
{
  
  int a=-10 , b=23;
  printf("a=%d\tb=%d\n",a,b);
  
  SWAP(a,b);

  printf("a=%d\tb=%d\n",a,b);


  return 0;
}
