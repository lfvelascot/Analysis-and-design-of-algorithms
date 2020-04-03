
package anlisisAlgoritmos.sis.ing.usbbog.edu.co;
import java.util.Scanner;
/**
 * @author Luis Felipe Velasco
 */
public class DominacionBacteriana {

    static Scanner s = new Scanner(System.in);
    static int[][] bacteria;

    public static void main(String[] args) {
        int q = s.nextInt();
        while (q > 0) {
            int l = s.nextInt();
            bacteria = new int[l][l];
            for (int[] bacteria1 : bacteria) {
                for (int j = 0; j < bacteria[0].length; j++) {
                    bacteria1[j] = s.nextInt();
                }
            }
            System.out.printf("%.2f\n", respuesta());
            q--;
        }

    }

    private static double respuesta() {
        double respuesta = 0;
        for (int i = 0; i < bacteria.length; i++) {
            for (int j = 0; j < bacteria[0].length; j++) {
                if (bacteria[i][j] == 1) {
                    respuesta++;
                    if (j + 1 < bacteria.length) {
                        if (bacteria[i][j + 1] == 0) {
                            if (ceros(i, j + 1)) {
                                j++;
                                if (j < bacteria.length) {
                                    respuesta = respuesta + cantCeros(i, j);
                                }
                            }
                        }
                    }
                }
            }
        }
        return respuesta / 2;
    }

    private static boolean ceros(int a, int b) {
        boolean flag = false;
        for (int i = b; i < bacteria.length; i++) {
            if (bacteria[a][i] == 1) {
                i = bacteria.length;
                for (int j = a - 1; j >= 0; j--) {
                    if (bacteria[j][b] == 1) {
                        j = -1;
                        for (int k = a + 1; k < bacteria.length; k++) {
                            if (bacteria[k][b] == 1) {
                                k = bacteria.length + 1;
                                flag = true;
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    private static int cantCeros(int a, int b) {
        int aux = 0;
        for (int i = b; i < bacteria.length; i++) {
            if (bacteria[a][i] == 0) {
                if (ceros(a, i)) {
                    aux += 1;
                } else {
                    aux = 0;
                    i = bacteria.length;
                }
            } else {
                i = bacteria.length;
            }
        }
        return aux;
    }
}

