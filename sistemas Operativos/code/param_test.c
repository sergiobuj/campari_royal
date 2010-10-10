/* @(#)param_test.c
 */
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
//#include "param_test.h"

int main(int argc, char *argv[])
{
  int i;

  printf("argc -> %d\n",argc);
  for(i=0; i< argc ; ++i)
    printf("string -> %s\n",argv[i]);
  
  char *num = argv[1];
  int num2  = atoi(num);
  printf("int -> %d\n",num2);



  //    printf("\n\n\n");
  //  while(i=getopt(argc,argv,"0123456789") != -1){

  //    printf("%d",i);
  //  }
  return 0;
}
