import java.util.*;

public class AdivineLaEstructura {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Queue<Integer> q = new LinkedList<>();
    Stack<Integer> s = new Stack<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    int n, cmd, x;
    
    boolean is_stack, is_queue, is_pq;

    while (sc.hasNext()) {
      n = sc.nextInt();
      q.clear();
      s.clear();
      pq.clear();

      is_stack = is_queue = is_pq = true; // asumimos que es todas las estructuras
      
      for (int i = 0; i < n; i++) {
        cmd = sc.nextInt();
        x = sc.nextInt();
        if (cmd == 1) {
          if (is_stack)
            s.add(x); // pila
          if (is_queue)
            q.offer(x); // cola
          if (is_pq)
            pq.offer(-x); // cola de prioridad
        } else { // cmd 2
          if (is_stack && !s.isEmpty()) {
            int t = s.pop();
            if (x != t) {
              is_stack = false;
            }
          } else {
            is_stack = false;
          }
          if (is_queue && !q.isEmpty()) {
            int t = q.poll();
            if (x != t) {
              is_queue = false;
            }
          } else {
            is_queue = false;
          }
          if (is_pq && !pq.isEmpty()) { 
            int t = -pq.poll();
            if (x != t) {
              is_pq = false;
            }
          } else {
            is_pq = false;
          }
        }
      }
      if (!is_queue && !is_stack && !is_pq) {
        System.out.println("impossible");
      } else if (!is_queue && is_stack && !is_pq) {
          System.out.println("stack");
      } else if (!is_queue && !is_stack && is_pq) {
          System.out.println("priority queue");
      } else if (!is_stack && is_queue && !is_pq) {
          System.out.println("queue");
      } else {
          System.out.println("not sure");
      }
    }
  }
}