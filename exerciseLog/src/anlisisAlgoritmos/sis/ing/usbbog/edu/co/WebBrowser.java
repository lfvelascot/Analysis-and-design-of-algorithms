package anlisisAlgoritmos.sis.ing.usbbog.edu.co;

import java.util.Scanner;

/**
 * @author Luis Felipe Velasco
 */
public class WebBrowser {

    static Scanner s = new Scanner(System.in);
    static String[] lista1;
    static String[] lista2;

    public static void main(String[] args) {
        lista1 = new String[s.nextInt()];
        llenarLista(lista1);
        lista2 = new String[s.nextInt()];
        llenarLista(lista2);
        System.out.println(resultado());
    }

    private static void llenarLista(String[] lista) {
        for (int i = 0; i < lista.length; i++) {
            lista[i] = s.next();
        }
    }

    private static String resultado() {
        String result = "";
        for (String lista12 : lista2) {
            int cant = 0, ext = 0;
            for (String lista11 : lista1) {
                if (lista11.contains(lista12)) {
                    cant += 1;
                    if (lista11.length() > ext) {
                        ext = lista11.length();
                    }
                }
            }
            if (cant == 0) {
                result += "-1\n";
            } else {
                result += cant + " " + ext + "\n";
            }
        }
        return result;
    }
}
