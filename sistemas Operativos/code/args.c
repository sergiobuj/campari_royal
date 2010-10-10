/* @(#)args.c
 */
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
//#include "args.h"

int main(int argc, char * argv[])
{
  int num = 0;
  if(argc > 1)
    num = atoi( argv[1] );
  char opt;
  while( (opt = getopt(argc - 1, &argv[1] , "vhm::" )) != -1 ){

    switch(opt){
    case 'v': 
      puts("v");
      break;

    case 'h': 
      puts("h");
      break;

    case 'm': 
      printf("m %s\n", (optarg)? optarg : "" );
      break;

    case '?':
      puts("learn");
      break;
    }
  }
  printf("%d\n",num);

  return 0;
}
