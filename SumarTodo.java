import java.util.PriorityQueue;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int n, x, respuesta;
        while (true) {
            priorityQueue.clear();
            n = sc.nextInt();
            if (n == 0) break;
            for (int i = 0; i < n; i++) {
                x = sc.nextInt();
                priorityQueue.add(x);
            }
            respuesta = 0;
            while (priorityQueue.size() >= 2) {
                int primero = priorityQueue.remove();
                int segundo = priorityQueue.remove();
                int costo = primero + segundo;
                respuesta += costo;
                priorityQueue.add(costo);
            }
            System.out.println(respuesta);
        }
    }
}
