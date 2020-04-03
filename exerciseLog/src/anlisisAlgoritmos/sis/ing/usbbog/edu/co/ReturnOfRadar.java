package anlisisAlgoritmos.sis.ing.usbbog.edu.co;

import java.util.Scanner;

/**
 * @author Luis Felipe Velasco
 */
public class ReturnOfRadar {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int num = s.nextInt();
        while (num != 0) {
            for (int i = 0; i < num; i++) {
                radarRule(s.nextInt());
            }
            num = s.nextInt();
        }
    }

    private static void radarRule(int ord) {
        if (ord % 2 == 0) {
            System.out.println((ord * 2) - 2);
        } else {
            System.out.println((ord * 2) - 1);
        }
    }
}

