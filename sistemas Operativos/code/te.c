#include <stdio.h>
#include <stdlib.h>

char *btow(int q){
  char *no="NOpe",*yes="YES,claro que si";
  return (q)? yes:no;
}


union pid{
  int integer;
  short corto;
};


struct bla{
  int squash;
  short quad;
  // bla(void *param);
};

//bla::bla(void * param){}

int main()
{
  freopen("hola","w",stdout);
  printf("stage 1\n");

  int egg=10;
  short eg=20;
  bla mystruct;
  int i=4;


  {
    int j;
    for(j=10; j>0 ; --j)
      printf("stage 2 ");
  }
  int j=9;
  printf("\nstage 3 -> %d\n",i+j);  
  int yes=1,no=0;
  printf("me gusta %s %s\n",btow(yes),btow(no));


  return 0;
}
