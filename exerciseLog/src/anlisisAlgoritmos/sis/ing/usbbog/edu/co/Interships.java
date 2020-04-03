package anlisisAlgoritmos.sis.ing.usbbog.edu.co;

import java.util.Scanner;

/**
 * @author Luis Felipe Velasco
 */
public class Interships {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt(), aux1 = 0, aux0 = 0;
        for (int i = 1; i <= m; i++) {
            int x = s.nextInt(), y = s.nextInt();
            aux0 = aux0 + (x * y);
            aux1 = aux1 + y;
        }
        System.out.printf("%.4f\n",(double)aux0/(aux1*100));
    }
}
