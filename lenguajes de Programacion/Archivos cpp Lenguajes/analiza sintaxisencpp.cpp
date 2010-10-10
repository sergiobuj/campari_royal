#include <iostream>
#include <cctype>

using namespace std;

class Calculadora{
   public: 
   
    int token;
   
    void error(void){
         cout <<"error de parse"<< endl;
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
         int resultado= expresion();
         if (token=='\n')
           cout << "el resultado es: " << resultado << endl;
         else error();
           cin >> resultado;
    }
    
    int expresion(void){
        int resultado = termino();
         while(token=='+'){
          match('+');
          resultado += termino();
         }
        return resultado;  
     }
        
    int termino(void){
        int resultado = factor();
         while(token == '*'){
            match('*');
            resultado *= factor();
         }
        return resultado;
     }
        
    int factor(void){
        int resultado;
         if(token=='('){
           match('(');
           resultado = expresion();
           match(')');
         }
         else 
         resultado = numero();
        return resultado;
     }
        
    int numero(void){
        int resultado = digito();
        while(isdigit(token))
          resultado = 10*resultado+digito();
        return resultado;
     }
        
    int digito(void){
        int resultado;
        if(isdigit(token)){
          resultado = token - '0';
          match(token);
        }
        else
          error();
        return resultado;
     }
        
    void parse(void){
         getToken();
         command();
    }
}     

int main(){
    Calculadora calc;
    calc.parse();
    return 0;
}
