/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usbbog;

import java.util.Scanner;

/**
 *
 * @author COMPURED
 */
public class Permutacion {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String elemento = s.next();
        permutacion(elemento, "", elemento.length(), elemento.length());
    }

    private static void permutacion(String elemento, String permutado, int letra, int ext) {
        if (letra == 0) {
            System.out.println(permutado);
        } else {
            for (int i = 0; i < ext; i++) {
                if (!permutado.contains(String.valueOf(elemento.charAt(i)))) {
                    permutacion(elemento, permutado + elemento.charAt(i), letra - 1, ext);
                }
            }
        }
    }
}
