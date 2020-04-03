package analisisAlgoritmos.sis.ing.usbbog.edu.co;

import java.util.Scanner;

/**
 * @author Luis Felipe Velasco
 */
public class AlgoritmoNoDeterministico {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("----------MAYOR O MENOR----------------"
                + "\nINGRESE CUATRO VALORES NUMERICOS:");
        mayorMenor(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt());
    }

    private static void mayorMenor(int w, int x, int y, int z) {
        String resul = "";
        if (w == x && w == y && w == z && x == y && x == z && y == z) {
            System.out.println(w + " = " + x + " = " + y + " = " + z);
        } else if (w > x && w > y && w > x) {
            resul += w + " > ";
            if (x > y && x > z) {
                resul += x + " > ";
                if (y > z) {
                    resul += y + " > " + z;
                } else {
                    resul += z + " > " + y;
                }
            } else if (y > x && y > z) {
                resul += y + " > ";
                if (x > z) {
                    resul += x + " > " + z;
                } else {
                    resul += z + " > " + x;
                }
            } else if (z > x && z > y) {
                resul += z + " > ";
                if (x > y) {
                    resul += x + " > " + y;
                } else {
                    resul += y + " > " + x;
                }
            }
        } else if (x > w && x > y && x > z) {
            resul += x + " > ";
            if (w > y && w > z) {
                resul += w + " > ";
                if (y > z) {
                    resul += y + " > " + z;
                } else {
                    resul += z + " > " + y;
                }
            } else if (y > w && y > z) {
                resul += y + " > ";
                if (w > z) {
                    resul += w + " > " + z;
                } else {
                    resul += z + " > " + w;
                }
            } else if (z > w && z > y) {
                resul += z + " > ";
                if (w > y) {
                    resul += w + " > " + y;
                } else {
                    resul += y + " > " + w;
                }
            }
        } else if (y > w && y > x && y > z) {
            resul += y + " > ";
            if (w > x && w > z) {
                resul += w + " > ";
                if (x > z) {
                    resul += x + " > " + z;
                } else {
                    resul += z + " > " + x;
                }
            } else if (x > w && x > z) {
                resul += x + " > ";
                if (w > z) {
                    resul += w + " > " + z;
                } else {
                    resul += z + " > " + w;
                }
            } else if (z > w && z > x) {
                resul += z + " > ";
                if (w > x) {
                    resul += w + " > " + x;
                } else {
                    resul += x + " > " + w;
                }
            }
        } else {
            resul += z + " > ";
            if (w > x && w > y) {
                resul += w + " > ";
                if (x > y) {
                    resul += x + " > " + y;
                } else {
                    resul += y + " > " + x;
                }
            } else if (x > w && x > y) {
                resul += x + " > ";
                if (w > y) {
                    resul += w + " > " + y;
                } else {
                    resul += y + " > " + w;
                }
            } else if (y > w && y > x) {
                resul += y + " > ";
                if (w > x) {
                    resul += w + " > " + x;
                } else {
                    resul += x + " > " + w;
                }
            }
        }
        System.out.println(resul);
    }
}


