/* @(#)forktest.c
 */
#include <stdio.h>
#include <strings.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
int main(){
  /*
    pid_t p;
    p = fork();
    printf("forked returned %d\n",p);
  */
  /*
    pid_t p;
    printf("Original program pid=%d\n\n",getpid());
    p=fork();
    if(p==0){
    printf("In child process pid=%d  ppid=%d \n\n",getpid(),getppid());
    }else{
    printf("In parent process pid=%d  forked returned=%d \n\n",getpid(),p);
    }
  */
  /*
    char *arg[]={"/bin/ls",0};
    if(fork()==0){
    printf("in child \n");
    execv(arg[0],arg);
    printf("i will never be called\n");
    }
    printf("back in parent\n");
  */  

  int fd_in, fd_out;
  char buf[1024];
  
  memset(buf,0,1024);
  fd_in=open("in",O_RDONLY);
  fd_out=open("out", O_WRONLY);
  fork();
  while(read(fd_in,buf,2)>0){
    printf("%d %s\n",getpid(),buf);
    sprintf(buf,"%d Hello, world!\n\r",getpid());
    //    sleep(1);
    write(fd_out,buf,strlen(buf));
    sleep(1);
    memset(buf,0,1024);
  }
  sleep(10);
  //  return 0;
}
