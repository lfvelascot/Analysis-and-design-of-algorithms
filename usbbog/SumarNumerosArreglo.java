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
public class SumarNumerosArreglo {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("SUMA VALORES ARREGLO ITERATIVA = " + sumarElementosVectorIterativo(llenarArreglo()));
        System.out.println("SUMA VALORES ARREGLO RECURSIVA = " + sumarElementosVectorRecursivo(llenarArregloR(0,null), 0, 0));
    }
     private static int sumarElementosVectorIterativo(int[] elementos) {
        int r = 0;
        for (int i = 0; i < elementos.length; i++) {
            r += elementos[i];
        }
        return r;
    }
    private static int sumarElementosVectorRecursivo(int[] elementos, int i,int r) {
        if (i == elementos.length-1){
             return r += elementos[i];
        } else {
            return sumarElementosVectorRecursivo(elementos, i+1, r+elementos[i]);
        }
    }    
    private static int[] llenarArreglo() {
        int [] elementos = new int [5];
        for (int i = 0; i < elementos.length; i++) {
            elementos[i] = s.nextInt();
        }return elementos;
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
