import java.util.LinkedList;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Character> respuesta = new LinkedList<>();
        String linea;
        int posicion;
        while (sc.hasNext()) {
            linea = sc.nextLine();
            respuesta.clear();
            posicion = 0;
            for (char ch: linea.toCharArray()) {
                if (ch == '[') posicion = 0;
                else if (ch == ']') posicion = respuesta.size();
                else respuesta.add(posicion++, ch);
            }
            for (char ch: respuesta) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}
 
