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
public class InvertirNumero {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        System.out.println("INVERTIR NUMERO ITERATIVO = "+invertirNumeroIterativo(String.valueOf(num))+""
                + "\nINVERTIR NUMERO RECURSIVO = " + invertirNumeroRecursivo(String.valueOf(num),
                        "", String.valueOf(num).length() - 1));
    }

    private static String invertirNumeroIterativo(String num) {
        String numInv = "";
        for (int i = num.length() - 1; i >= 0; i--) {
            numInv += num.charAt(i);
        }
        return numInv;
    }

    private static String invertirNumeroRecursivo(String num, String numInv, int i) {
        if (i == 0) {
            return numInv.concat(String.valueOf(num.charAt(i)));
        } else {
            return invertirNumeroRecursivo(num, numInv.concat(String.valueOf(num.charAt(i))), i - 1);
        }
    }
}
