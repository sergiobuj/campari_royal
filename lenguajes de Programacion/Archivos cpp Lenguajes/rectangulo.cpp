#include <iostream>

using namespace std;
float respuesta;

int main(){

    cout<<"ingrese la altura del rectangulo..."<<endl;;
    float altura;
    cin >>  altura;
    cout<<"ingrese la base del rectangulo..."<<endl;;
    float base;
    cin >> base;
    
    cout<<"desea calcular 1) área del rectangulo. 2) perimetro del rectangulo."<<endl<<"escriba el numero de la función"<<endl;
    int option;
    cin>>option;
    switch(option){
                 case 1:
                         respuesta = (base*altura);
                         cout<< "el área es: "<<respuesta<<endl;
                         break;
                 case 2:
                         respuesta = (2*base)+(2*altura);
                         cout<< "el perimetro es: "<<respuesta<<endl;
                         break;
                         
}
int t;
cin>>t;
return 0;
}

