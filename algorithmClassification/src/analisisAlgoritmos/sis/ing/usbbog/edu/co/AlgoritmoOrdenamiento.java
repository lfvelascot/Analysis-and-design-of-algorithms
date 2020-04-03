
package analisisAlgoritmos.sis.ing.usbbog.edu.co;

import java.util.Scanner;
/**
 * @author Luis Felipe Velasco
 */
public class AlgoritmoOrdenamiento {
	static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int[] cod = new int[10];
        System.out.println("Ingrese el tipo de ordenamiento que desea realizar: \n 1.Ascendente\n 2.Descendente ");
        switch (s.nextInt()) {
            case 1:
                cod = ordenamiento(llenarArreglo(), 1);
                System.out.println("LISTA DE CODIGOS ORDENADOS DE FORMA ASCENDENTE");
                for (int i = 0; i < cod.length; i++) {
                    System.out.println("CODIGO [" + i + "]" + cod[i]);
                }
                break;
            case 2:
                cod = ordenamiento(llenarArreglo(), 2);
                System.out.println("LISTA DE CODIGOS ORDENADOS DE FORMA DESCENDENTE");
                for (int i = 0; i < cod.length; i++) {
                    System.out.println("CODIGO [" + i + "]" + cod[i]);
                }
                break;
            default:
                System.out.println("Valor ingresado no valido");
        }

    }


    private static int[] llenarArreglo() {
        int[] codigos = new int[10];
        for (int i = 0; i < codigos.length; i++) {
            System.out.println("CODIGO [" + i + "]");
            codigos[i] = s.nextInt();
        }
        return codigos;
    }

    private static int[] ordenamiento(int[] codigos, int orden) {
        for (int i = 0; i < codigos.length; i++) {
            for (int j = i + 1; j < codigos.length; j++) {
                if (orden == 1) {
                    if (codigos[i] > codigos[j]) {
                        int aux = codigos[i];
                        codigos[i] = codigos[j];
                        codigos[j] = aux;
                    }
                } else {
                    if (codigos[i] < codigos[j]) {
                        int aux = codigos[i];
                        codigos[i] = codigos[j];
                        codigos[j] = aux;
                    }
                }
            }
        }
        return codigos;
    }
}

