#include <cstdlib>
#include <iostream>
#include <iomanip>
using namespace std;

int matrix[3][5] = { { 215, 314, 216, 112,  8 },
                     { 119, 217, 214, 111,  4 },
                     {  61, 115, 315, 316, 118 } };
int rowsum[3];
int colsum[5];

int matrixsum( int arr2D[][5], int vlen, int rsum[], int csum[],int argc, char *argv[]);
int main()
{
   cout << "Testing the function matrixsum()." << endl;

   int totalsum = matrixsum( matrix, 3, rowsum, colsum);

   cout << "The matrix with the sums of rows and columns:" << endl;
   int i,j;
   for( i = 0 ; i < 3 ; ++i)
   {                            // matrix with row sums.
     for( j = 0 ; j < 5 ; ++j)
       cout << setw(8) << matrix[i][j];
     cout << " | " << setw(8) << rowsum[i] << endl;
   }
   cout << endl;
   for( j = 0 ;  j < 5  ;  ++j )
     cout << setw(8) << colsum[j];
   cout << " | " << setw(8) << totalsum << endl;
   return 0;
       system("PAUSE");

}
