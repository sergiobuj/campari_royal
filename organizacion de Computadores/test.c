/* @(#)test.c
 */

#include <stdio.h>
main()
{

  char *a = "ST0254 bienvenidos!!!";;
  int i=0;
  for(;i<21;i=i+1){
    printf(" %x",a[i]);
  }
  printf("\n");
}
