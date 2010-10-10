
int factorial(int n){
  if(n==0) return 1;
  else return n*factorial(n-1);
}

float funca(float angle){
  float ans = 0;
  int sign = 1;
  float acum_x = angle;
  int acum_factorial = 1;
  int i;
  for( i = 0 ; i < 16 ; i = i + 1){
    ans = ans + (sign * ( acum_x/factorial(i)));
    sign = sign * -1;
    acum_x = acum_x + angle * angle;
  }
  return ans;
}

int main(){
  printf("%f\n", funca());
  return 0;
}
