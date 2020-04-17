/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usbbog;

import java.util.Scanner;

/**
 * @author TAO
 */
public class Palindromo {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String palabra = s.next();
        System.out.println(palindromo(palabra, "", palabra.length() - 1));;
    }

    private static String palindromo(String palabra, String palabraInv, int i) {
        if (i == 0) {
            if (palabra.equals(palabraInv.concat(String.valueOf(palabra.charAt(i))))) {
                return palabra + " si es un palindromo";
            } else {
                return palabra + " no es un palindromo";
            }
        } else {
            return palindromo(palabra, palabraInv.concat(String.valueOf(palabra.charAt(i))), i - 1);
        }
    }
}
