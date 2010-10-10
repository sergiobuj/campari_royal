// Sergio Botero - sergiobuj@gmail.com
// Status:
#include <vector>
#include <list>
#include <map>
#include <set>
#include <deque>
#include <queue>
#include <stack>
#include <bitset>
#include <algorithm>
#include <functional>
#include <numeric>
#include <utility>
#include <sstream>
#include <iostream>
#include <iomanip>
#include <cstdio>
#include <cmath>
#include <cstdlib>
#include <cctype>
#include <string>
#include <cstring>
#include <cstdio>
#include <cmath>
#include <cstdlib>
#include <ctime>

using namespace std;
#define all(x) x.begin(),x.end()
#define D(x) cout <<__LINE__<<"  "<<#x<<"  is  "<< x << endl
#define D_v(x) for(int __i=0;__i<x.size();cerr<<x[__i++]<<" ")
#define D_m(m,rows,cols) for(int __i=0;__i<rows;cout<<endl,++__i) for(int __j=0;__j<cols;) cout <<m[__i][__j++]<<"  "
#define SWAP(a,b)({(a)^=(b);(b)^=(a);(a)^=(b);})


struct valle{
  union {
    int entero;
    short carac;
  }a;
};

int main (){
  valle la;
  la.a.entero = 128;

  string aux="";
  for(int i=0; la.a.entero >> i > 0; ++i) aux=((la.a.entero>>i)&1? "1":"0") + aux;
  puts(aux.c_str());
  printf("el int %d\nel short %hi\n",la.a.entero,la.a.carac );
  la.a.carac = 15;
  aux="";
  for(int i=0; la.a.entero >> i > 0; ++i) aux=((la.a.entero>>i)&1? "1":"0") + aux;
  puts(aux.c_str());
  printf("el int %d\n short %hi\n",la.a.entero,la.a.carac );



  return 0;
}
