package analisisAlgoritmos.sis.ing.usbbog.edu.co;

import java.util.Scanner;

/**
 * @author Luis Felipe Velasco
 */
public class AlgoritmoDeterministico1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese los dos valores para hallar su M.C.D ");
        int num1 = s.nextInt(), num2 = s.nextInt(), mcd = minimoComunMultiplo(num1, num2);
        if (mcd != 1) {
            System.out.println("El MCD entre " + num1 + " y " + num2 + " es " + mcd);
        } else {
            System.out.println("Entre los numeros " + num1 + " y " + num2 + " no existe un MCD ---->" + mcd);
        }
    }

    public static int minimoComunMultiplo(int num1, int num2) {
        int aux = 0;
        while (num2 != 0) {
            aux = num2;
            num2 = num1 % num2;
            num1 = aux;
        }
        return num1;
    }
}


