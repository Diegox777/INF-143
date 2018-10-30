import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<String> q = new LinkedList<>();
		TreeMap<String, Integer> tm = new TreeMap<>();
		for (char i = 'a'; i <= 'z'; i++) {
			q.add("" + i);
		}
		//generamos las cadenas
		int index = 1;
		while (!q.isEmpty()) {
			String f = q.remove();
			tm.put(f, index++); // a -> 1, b -> 2, ...
			if (f.length() == 5) continue;
			char ultimoCaracter = f.charAt(f.length() - 1);
			for (char ch = (char)(ultimoCaracter + 1); ch <= 'z'; ch++) {
				q.add(f + ch);
			}
		}
		String x;
		while (sc.hasNext()) {
			x = sc.next();
			Integer respuesta = tm.get(x);
			if (respuesta == null) {
				System.out.println(0);
			} else {
				System.out.println(respuesta);
			}
		}
	}
}
