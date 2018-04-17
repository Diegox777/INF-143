import java.util.Scanner;
import java.util.TreeSet;

class PrimerDiccionario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        TreeSet<String> treeSet = new TreeSet<>();
        String linea, palabra;

        while (sc.hasNext()) {
            linea = sc.nextLine();
            linea = linea.toLowerCase(); // convertimos a minusculas
            palabra = "";
            for (char c : linea.toCharArray()) {
                if (c >= 'a' && c <= 'z') { // si es del alfabeto
                    palabra += c; // componemos
                } else { // no es del alfabeto,
                    if (palabra.length() > 0) 
                        treeSet.add(palabra);
                    palabra = "";
                }
            }
            if (palabra.length() > 0) // caso especial
                treeSet.add(palabra);
        }
        for (String p : treeSet) { // imprime de menor a mayor
            System.out.println(p);
        }
    }
}

/*
hola bola

*/