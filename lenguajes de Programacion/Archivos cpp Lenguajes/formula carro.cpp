# include <iostream>
using namespace std;

main() {
       double vel;
       int distancia;

	cout << "Distancia: ";
    cin >> distancia;
  		
   	if(distancia < 30){
      vel = ( 0.425 + 0.00175 * (distancia*distancia));        
             }else{
      vel = (0.625 + (0.12 * distancia) - (0.00021 * (distancia*distancia)));
             }
   			cout << "La velocidad es: " << vel << endl;
   			cin >> a;
   	return 0;
}
