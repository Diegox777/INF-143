import java.util.Scanner;

public class Main {
	
	static long memo[][];
	
	static long superSuma(int k, int n) {
		if (k == 0) {
			return n;
		}
		if (memo[k][n] != -1) {
			return memo[k][n];
		}
		long suma = 0;
		for (int i = 1; i <= n; i++) {
			suma += superSuma(k - 1, i);
		}
		return memo[k][n] = suma;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k, n;
		memo = new long[25][25];
		for (int i = 0; i < 25; i++) 
			for (int j = 0; j < 25;j++)
				memo[i][j] = -1;
		while (sc.hasNext()) {
			k = sc.nextInt();
			n = sc.nextInt();
			System.out.println(superSuma(k, n));			
		}
	}
}
