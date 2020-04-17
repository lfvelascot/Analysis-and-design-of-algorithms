/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usbbog;

import java.util.Scanner;

/**
 *
 * @author TAO
 */
public class NumeroMenorArreglo {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("NUMERO MENOR DE UN ARREGLO ITERATIVO = " + menorDelArregloIterativo(llenarArreglo()));
        System.out.println("NUMERO MENOR DE UN ARREGLO RECURSIVO = " + menorDelArregloRecursivo(llenarArregloR(0, null), 0, 0));
    }

    private static int menorDelArregloIterativo(int[] elementos) {
        int men = elementos[0];
        for (int i = 1; i < elementos.length; i++) {
            if (men > elementos[i]) {
                men = elementos[i];
            }
        }
        return men;
    }

    private static int menorDelArregloRecursivo(int[] elementos, int i, int men) {
        if (i == elementos.length) {
            return men;
        } else if (i == 0) {
            return menorDelArregloRecursivo(elementos, i + 1, elementos[i]);
        } else {
            if (men > elementos[i]) {
                return menorDelArregloRecursivo(elementos, i + 1, elementos[i]);
            } 
                return menorDelArregloRecursivo(elementos, i + 1, men);
        }
    }

    private static int[] llenarArreglo() {
        int[] elementos = new int[5];
        for (int i = 0; i < elementos.length; i++) {
            elementos[i] = s.nextInt();
        }
        return elementos;
    }

    private static int[] llenarArregloR(int i, int[] nume) {
        if (i == 0) {
            int[] num = new int[5];
            num[0] = s.nextInt();
            return llenarArregloR(i + 1, num);
        } else if (i < 5) {
            nume[i] = s.nextInt();
            return llenarArregloR(i + 1, nume);
        } else {
            return nume;
        }
    }
}
