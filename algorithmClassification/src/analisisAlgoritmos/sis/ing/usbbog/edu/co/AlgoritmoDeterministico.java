
package analisisAlgoritmos.sis.ing.usbbog.edu.co;

import java.util.Scanner;

/**
 * @author Luis Felipe Velasco
 */
public class AlgoritmoDeterministico {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("INGRESE LOS VALORES DE x Y y para la siguiente operaciòn: \n"
                + "                     (x+y)(x-y)                         ");
        int x = s.nextInt(), y = s.nextInt(), z = (x + y) * (x - y);
        System.out.println("(" + x + " + " + y + ")(" + x + " - " + y + ") = " + z);
    }
}

