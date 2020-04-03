package anlisisAlgoritmos.sis.ing.usbbog.edu.co;

import java.util.Scanner;

/**
 * @author Luis Felipe Velasco
 */
public class IdentifyingTea {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(identifyingTea(s.nextInt()));
    }

    private static int identifyingTea(int tea) {
        int resultado = 0;
        for (int i = 0; i < 5; i++) {
            if (s.nextInt() == tea) {
                resultado++;
            }
        }
        return resultado;
    }
}
