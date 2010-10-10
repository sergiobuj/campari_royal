#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

class ReGrilla{
int rows;
int columns;
int matrix[][0];  // ese 1 es porque dicen que el segndo debe estar indicado .. no se..

    public:
   ReGrilla(int rowsP,int columnsP){
          rows = rowsP-1;
          columns =  columnsP-1;
          matrix[rows][columns];
          feedGrilla();
          printMyGrilla();
   }                                            //end of constructor

     private:


   void feedGrilla(){
      for(int i=1 ; i <= rows ; i++){
            for(int j=1 ; j <= columns ; j++){
                int fill = theRandom();
                if(fill==0){
                    matrix[i][j]=0;
                }else{
                    matrix[i][j]= fill;
                }                               //end of if

            }                                   //end of for j

       }                                        //end of i

    }                                           //end of for




    int theRandom(){
          srand(time(NULL));
          int random_integer; 
          for(int index=0; index<20; index++){ 
            random_integer = (rand()%10)+1;
            return random_integer+1;
    }
          
          
    }                                           //end of random



    void printMyGrilla(){
         for (int i = 0 ; i <= rows ; i++){
             for (int j = 0 ; j <= columns ; j++){
                 cout << matrix[rows][columns] << " ";
             }                                 //end of for j
             cout << endl;
         }                                     //end of for i
    }                                          //end of printing


};                                              //end of class


int main(){
        /*int rows,columns;
        cout <<"ingrese el numero de filas: "<<endl;
        cin  >>rows;
        cout <<"ingrese el numero de columnas"<<endl;
        cin  >> columns;*/
        ReGrilla n (3,4);
        return 0;
      }                                          //end of main

