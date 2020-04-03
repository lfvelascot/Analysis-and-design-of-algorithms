
package analisisAlgoritmos.sis.ing.usbbog.edu.co;

import java.util.Scanner;

/**
 * @author Luis Felipe Velasco
 */
public class AlgoritmoHeuritico {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("INGRESE LA CANTIDAD DE n PRIMOS QUE DESEA GENERAR");
        nPrimos(s.nextInt());
    }

    private static void nPrimos(int iter) {
        int primo = 2;
        while (iter > 0) {
            boolean flag = true;
            for (int i = primo; i > 0; i--) {
                if (primo % i == 0 && i != primo && i != 1) {
                    flag = false;
                    break;
                }
            }
            if (flag){
                iter--;
                System.out.println(" (-) "+primo);
            }
            flag = true;
            primo++;
        }
    }

}
