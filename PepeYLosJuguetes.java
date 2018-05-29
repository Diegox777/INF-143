import java.util.*;
 
public class PepeYLosJuguetes {
  public static void main(String... bla) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int A[] = new int[n];
    for (int i = 0; i < n; i++)
      A[i] = sc.nextInt();
    Arrays.sort(A);
    int sum = 0;
    int ans = 0;
    for (int i = 0; i < n; i++) {
      sum += A[i];
      if (sum <= k) {
        ans++;
      }
      else {
        break;
      }
    }
    System.out.println(ans);
  }
}
