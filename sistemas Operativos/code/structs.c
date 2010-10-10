/* @(#)structs.c
 */
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
//#include "structs.h"
typedef struct {
  int a,b,c;
  //  int (*AInt)(int,int);
  void (*apuntador_a_funcion)();
} A;

void AVoid(){
  printf("%d-%d-%d\n",10,20,30);
}

int main()
{
  A a1={.a=10,.b=20,.c=30,.apuntador_a_funcion = AVoid};
  a1.apuntador_a_funcion();
  //  test A[2]={ [0]={.a=10,.b=13,.c=120}, [1]={.a=4,.b=4,.c=4}  };
  //  printf("4->%d 10->%d 120->%d",A[1].c,A[0].a,A[0].c);
  return 0;
}
