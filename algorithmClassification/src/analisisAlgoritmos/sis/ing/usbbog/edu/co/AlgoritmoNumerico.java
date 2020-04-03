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
public class AlgoritmoNumerico {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ingrese 4 numeros de coma flotante para ubicar sobre el eje X y hallar su punto medio");
        System.out.printf("PUNTO MEDIO APROX.  A DOS CIFRAS DECIMALES SIGNIFICATIVAS= %.2f \n", (s.nextDouble() + s.nextDouble() + s.nextDouble() + s.nextDouble()) / 4);
    }
}
