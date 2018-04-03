import java.util.Scanner;
import java.util.Stack;

public class BobYLosParentesis {

  public static void main(String... blabla) {
    Scanner sc = new Scanner(System.in);
    Stack<Character> stack;
    int tc = sc.nextInt();
    sc.nextLine();  // ignorar el siguiente carater
    String s;
    boolean ok;
    while (tc-- > 0) {
      stack = new Stack<>();
      s = sc.nextLine(); // leer una linea entera
      ok = true; // asumimos que cumple las condiciones
      for (char ch: s.toCharArray()) { // for each
        if (ch == ' ')
          continue; // ignoramos los espacios
        if (ch == '(') { // si es de apertura
          stack.add(')'); // añadimos el de cierre
        } else if (ch == '[') {
          stack.add(']');
        }
        if (ch == ')' || ch == ']') { // para el cierre
          if (stack.isEmpty()) {
            ok = false;
            break;
          }
          if (stack.peek() == ch) {
            stack.pop();
          } else {
            ok = false;
            break;
          }
        }
      }
      if (!stack.isEmpty()) { // si la pila no esta vacia
        ok = false; // no cumple
      }
      System.out.println(ok ? "Yes" : "No");
    }
  }
}