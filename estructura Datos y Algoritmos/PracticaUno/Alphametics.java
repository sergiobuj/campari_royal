import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Alphametics {
	static int permu = 0;
	static int level = -1;
	public static void main(String[] args) {
		
		//char answer[] = new char[]{'*','*','*','*','*','*','*','*','*','*'};
		
		//int current[] = new int[]{0,1,3,5,7,9};
		
		int n =3;
		
		int current[] = new int[n];
		
		for (int i = 0; i < current.length; i++)
			current[i] = i;
		//getIndexes(n);
		//recorrerVector(new int[]{0,1,2}, 0);
		
		
		shuffleVector(current, 0, n);


		//visit(current, Value, n, 0);
	}

	/*public static void getIndexes(int n){
		
		int index[] = new int[n];
		
		for (int i = 0; i < index.length; i++)
			index[i] = i;
		
		
		
		
		int Value[] = new int [n];
		visit(index, Value, n, 0);
		                      
		
	}*/
	/*static void imprimir(int[] vector) {
		for (int i = 0; i < vector.length; i++) {
	        System.out.print(vector[i]+" ");
        }
		System.out.println();
	}*/
	
	
	public static void visit (int[] current, int [] Value, int N, int k){
		
		
		level = level+1;
		Value[k]= level;
		

		
		if (level == N){
		
			/*if (checkSum())
				return;*/
			
			permu = permu+1;	
			System.out.print("Permutacion "+permu+" : ");
			for (int i = 0; i < Value.length; i++){
				System.out.print(current[Value[i]-1]+" ");
			}
			System.out.print("\n");	
		}
		else{
			for (int i = 0; i < N; i++){
				if (Value[i] == 0){
					visit(current, Value, N, i);
				}
			}
			
		}
	level = level - 1;
	Value[k] = 0;
	}
	public static void shuffleVector(int[] vector, int position, int n) {
		//Llego al final
		if (position >= vector.length) {
			return;
		}
		
		//llamo pa los que siguen
		for (int i = vector[position] + 1; i <= 10; i ++) {
			
			//Las posiciones iniciales despues de la posicion acual siempre incian en 1
			for (int j = position; j < vector.length - 1; j ++) {
				vector[j + 1] = vector[j] + 1;
				if (vector[j + 1] >= 10) {
					return;
				}
			}
			
			
			
			int Value[] = new int[n];
			
			for (int j = 0; j < n; j++)
				Value[j] = 0;
			
			visit(vector, Value, n, 0);
			//print(vector);
			
			//Recorrer subVectores
			shuffleVector(vector, position + 1, n);
			
			//Aumento la posicion acutual
			vector[position] = i;
			
		}
		
	}
	
	private BufferedReader tableroTxt = null;

	public void Ensayo() throws FileNotFoundException {
		tableroTxt = new BufferedReader(new FileReader("alpham.in"));
	}
	public String readLine() throws IOException {
		return tableroTxt.readLine();
	}
	
	/*static void print(int[] vector) {
		for (int i = 0; i < vector.length; i++) {
	        System.out.print(vector[i]+" ");
        }
		System.out.println();
	}*/
	
}
