import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // leemos el nro. de juguetes
		int k = sc.nextInt(); // leemos la cantitad de juguetes disponibles
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] =  sc.nextInt();
		Arrays.sort(A); // ordenamos para obtener los de menor precio -> n log(n)
		int suma = 0;
		int juguetes = 0;
		for (int i = 0; i < n; i++) {
			suma += A[i];
			if (suma <= k) {
				juguetes++; // compramos el juguete
			} else {
				break; // si ya no podemos comprar mas detenemos el ciclo
			}
		}
		System.out.println(juguetes);
	} // O(n log(n))
}
