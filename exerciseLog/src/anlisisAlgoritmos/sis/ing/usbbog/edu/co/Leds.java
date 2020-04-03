
package anlisisAlgoritmos.sis.ing.usbbog.edu.co;

import java.util.Scanner;

/**
 * @author Luis Felipe Velasco
 */
public class Leds {

    static int[] led = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        leds(s.nextInt());
    }

    public static void leds(int cases) {
        String c = "";
        while (cases > 0) {
            int numLed = 0;
            String x = s.next();
            for (int i = 0; i < x.length(); i++) {
                for (int j = 0; j < led.length; j++) {
                    if (x.charAt(i) == String.valueOf(j).charAt(0)) {
                        numLed += led[j];
                    }
                }
            }
            c += numLed + " leds\n";
            cases--;
        }
        System.out.println(c);
    }
}

