package anlisisAlgoritmos.sis.ing.usbbog.edu.co;

import java.util.Scanner;

/**
 * @author Luis Felipe Velasco
 */
public class CompareSubstrings {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        compareStrings(s.nextLine().toLowerCase(), s.nextLine().toLowerCase());
    }

    public static void compareStrings(String cadena1, String cadena2) {
        String aux = "";
        int longitud = 0;
        for (int i = 0; i < cadena1.length(); i++) {
            aux += cadena1.charAt(i);
            if (cadena2.contains(aux)) {
                if (aux.length() > longitud) {
                    longitud = aux.length();
                }
                for (int j = i + 1; j < cadena1.length(); j++) {
                    aux += cadena1.charAt(j);
                    if (cadena2.contains(aux)) {
                        if (aux.length() > longitud) {
                            longitud = aux.length();
                        }
                    } else {
                        break;
                    }
                }
            } else {
                aux = "";
            }
        }
        System.out.println(longitud);
    }
}
