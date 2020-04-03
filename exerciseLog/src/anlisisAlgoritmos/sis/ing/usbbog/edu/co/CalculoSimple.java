package anlisisAlgoritmos.sis.ing.usbbog.edu.co;

/**
 * @author Luis Felipe Velasco
 */
import java.util.Scanner;

public class CalculoSimple {

    public static double metodo(int a, int b, double c, int d, int e, double f) {
        return (b * c) + (e * f);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.printf("VALOR A PAGAR: R$ %.2f \n", metodo(
                s.nextInt(), s.nextInt(), s.nextDouble(),
                s.nextInt(), s.nextInt(), s.nextDouble())
        );
    }
}
