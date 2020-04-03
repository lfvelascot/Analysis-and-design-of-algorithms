package anlisisAlgoritmos.sis.ing.usbbog.edu.co;

import java.util.Scanner;

/**
 * @author Luis Felipe Velasco
 */
public class HoneyReservoir {

    static Scanner s = new Scanner(System.in);
    static double r = 0.0;

    public static void main(String[] args) {
        System.out.printf("ALTURA = %.2f \nAREA = %.2f \n", s.nextDouble() / ((potencia(s.nextDouble() / 2))), r);
    }

    private static double potencia(double x) {
        r = 3.14 * (x * x);
        return r;
    }
}
