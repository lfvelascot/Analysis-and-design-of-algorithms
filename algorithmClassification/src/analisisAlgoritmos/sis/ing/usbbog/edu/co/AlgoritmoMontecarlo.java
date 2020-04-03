/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisAlgoritmos.sis.ing.usbbog.edu.co;

import java.util.Scanner;

/**
 *
 * @author Luis Felipe Velasco
 */
public class AlgoritmoMontecarlo {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arreglo = new int[5];
        arreglo = llenararreglo(arreglo);
        validarnum(arreglo);
    }

    private static int[] llenararreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = s.nextInt();
        }
        return arreglo;
    }

    private static boolean comprobarPrimo(int x) {
        int a = x - 2;
        if (Math.pow(a, x - 1) % x == 1) {
            return true;
        } else {
            return false;
        }
    }

    private static void validarnum(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            if (comprobarPrimo(arreglo[i])) {
                System.out.println("EL NUMERO ES PRIMO");
            } else {
                System.out.println("EL NUMERO NO ES PRIMO");
            }
        }
    }

}
