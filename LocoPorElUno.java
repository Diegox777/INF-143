import java.util.Arrays;
import java.util.Scanner;

public class LocoPorElUno {

    static int memo[];

    static int solve(int n) {
        if (n == 1) 
            return 0;
        if (memo[n] != -1)
            return memo[n];

        int respuesta;
        respuesta = 1 + solve(n - 1); // si le restamos -1
        if (n % 2 == 0) { // si es divisible entre 2
            respuesta = Math.min(respuesta, 1 + solve(n / 2));
        }
        if (n % 3 == 0) { // si es divisble entre 3
            respuesta = Math.min(respuesta, 1 + solve(n / 3));
        }
        return memo[n] = respuesta;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();
        memo = new int[1005];
        Arrays.fill(memo, -1);
        while (casos-- > 0) {
            int n = sc.nextInt();
            int respuesta = solve(n);
            System.out.println(respuesta);
        }
    }
}