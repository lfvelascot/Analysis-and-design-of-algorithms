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
public class Factorial {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        System.out.println("Factorial iterativo = " + factorialIterativo(num) + "\n"
                + "Factorial Recursivo = " + factorialRecursivo(num, 2, 1));
    }

    private static int factorialIterativo(int num) {
        int r = 1;
        for (int i = 2; i <= num; i++) {
            r *= i;
        }
        return r;
    }

    private static int factorialRecursivo(int num, int i, int r) {
        if (i != num) {
            return factorialRecursivo(num, i + 1, r * i);
        } else {
            return r * i;
        }
    }
}
