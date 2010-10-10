#include <ctype.h>
#include <stdlib.h>
#include <stdio.h>

int token;
void command(void);
int expr(void);
int term(void);
int factor(void);
int number(void);
int digit(void);

void error(void){
     printf("error de parse\n");
     exit(1);
     }

void getToken(void){
     token = getchar();
     }

void match(char c){
     if (token == c) getToken();
     else error();
     }
     
void command(void){
     int result= expr();
     if (token=='\n')
     printf("el resultado es: %d\n",result);
     else error();
     }

int expr(void){
    int result = term();
     while(token=='+'){
      match('+');
      result += term();
     }
    return result;  
    }
    
int term(void){
    int result = factor();
     while(token == '*'){
        match('*');
        result *= factor();
     }
    return result;
    }
    
int factor(void){
    int result;
     if(token=='('){
       match('(');
       result = expr();
       match(')');
     }
     else 
     result = number();
    return result;
    }
    
int number(void){
    int result = digit();
    while(isdigit(token))
    result = 10*result+digit();
    return result;
    }
    
int digit(void){
    int result;
    if(isdigit(token)){
    result = token - '0';
    match(token);
    }
    else
    error();
    return result;
    }
    
void parse(void){
     getToken();
     command();
     }
     
int main(){
       parse();
       return 0;
       }
