import java.util.Arrays;
import java.util.Scanner;

public class FibonacciDP {

    static long memo[];

    static long fibonacci(int n) { // Top - Down
        // casos base
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        // si el valor ya ha sido calculado
        if (memo[n] != -1)
            return memo[n]; // simplemente devolvemos la sol.
        // calculamos la solucion
        long ans = fibonacci(n - 1) + fibonacci(n - 2);
        // guardamos en memoria
        memo[n] = ans;
        return memo[n]; // returnamos la respuesta
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        memo = new long[n + 5]; // asignamos nuestra memoria el tamaño de n
        Arrays.fill(memo, -1); // llenamos con un valor 
                                //que nunca formara parte de la solucion
        long ans = fibonacci(n);

        System.out.println(ans);

        // Bottom - Up
        long dp[] = new long[n + 5];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }
}