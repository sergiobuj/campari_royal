#include <stdio.h>
#include <iostream>
using namespace std;

int main(){
    int num1,num2;
    float sum;
    
    puts("un numero");
    scanf("%d",&num1);
    puts("el otro");
    scanf("%d",&num2);
    
    sum = num1 + num2;
    printf("el promedio es: %.3f\n",sum/2);
    cin >> num1;
    return 0;
}
