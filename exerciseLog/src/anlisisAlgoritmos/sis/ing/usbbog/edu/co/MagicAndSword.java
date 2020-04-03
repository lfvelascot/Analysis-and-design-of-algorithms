
package anlisisAlgoritmos.sis.ing.usbbog.edu.co;

import java.util.Scanner;

/**
 *
 * @author Luis Felipe Velasco
 */
public class MagicAndSword {
    static Scanner s = new Scanner(System.in);
    static int[] rec = new int[4];
    static int[] cir = new int[4];

    public static void main(String[] args) {
        int iter = s.nextInt();
        while (iter > 0) {
            System.out.println(respuesta(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.next(), s.nextInt(), s.nextInt(), s.nextInt()));
            iter--;
        }
    }

    private static void dibujarcuadrado(int w, int h, int x, int y) {
        rec[0] = x + w;
        rec[1] = x;
        rec[2] = y;
        rec[3] = y + h;

    }

    private static void dibujarCirculo(String poder, int level, int x, int y) {
        int r = radio(poder, level);
        cir[0] = x - r;
        cir[1] = x + r;
        cir[3] = y + r;
        cir[2] = y - r;
    }

    private static int radio(String poder, int level) {
        switch (poder) {
            case "fire":
                switch (level) {
                    case 1:
                        return 20;
                    case 2:
                        return 30;
                    case 3:
                        return 50;
                }
                break;
            case "water":
                switch (level) {
                    case 1:
                        return 10;
                    case 2:
                        return 25;
                    case 3:
                        return 40;
                }
                break;
            case "earth":
                switch (level) {
                    case 1:
                        return 25;
                    case 2:
                        return 55;
                    case 3:
                        return 70;
                }
                break;
            case "air":
                switch (level) {
                    case 1:
                        return 18;
                    case 2:
                        return 38;
                    case 3:
                        return 60;
                }
                break;
        }
        return 0;
    }

    private static int respuesta(int w, int h, int x, int y, String poder, int level, int x0, int y0) {
        int dano = damage(poder);
        dibujarcuadrado(w, h, x, y);
        dibujarCirculo(poder, level, x0, y0);
        if (validación()) {
            return dano;
        }
        return 0;
    }

    private static int damage(String poder) {
        switch (poder) {
            case "fire":
                return 200;
            case "water":
                return 300;
            case "earth":
                return 400;
            case "air":
                return 100;
        }
        return 0;
    }

    private static boolean validación() {
        if ((rec[0] >= cir[0] && rec[0] <= cir[1]) || (rec[1] <= cir[1] && rec[1] >= cir[0])) {
            if ((rec[2] >= cir[2] && rec[2] <= cir[3]) || (rec[3] <= cir[2] && rec[3] >= cir[3])) {
                return true;
            }
        }
        return false;
    }
}

