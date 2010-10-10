/* @(#)array.c
 */
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
/* #include "array.h" */

/* # define JOIN(a,b) a##b */


int main()
{
  char * leak = malloc(4*sizeof(char));

  /*  int arr[]={10,20,30,40}; */
  char arr[]="Sergio Botero";
  /*  int a=5,b=0,JOIN(a,b); */
  /* printf("%d %d %d\n",a,b,ab); */
  int i;
  for(i=0 ; *(arr+i) ;++i)
    printf("%c - ",*(arr+i));
  free(leak);
  return 0;

}
