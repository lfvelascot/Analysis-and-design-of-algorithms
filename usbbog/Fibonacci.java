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
public class Fibonacci {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int num = s.nextInt();
        System.out.println("FIBONACCI ITERATIVA = " + fibonacciIterativo(num) + "\n"
                + "FIBONACCI RECURSIVO = " + fibonacciRecursivo(num, 0, 1, 0) + "\n"
                + "FIBONACCI ANIDADO = " + fibonacci(num));
    }

    private static int fibonacciIterativo(int num) {
        if (num == 0) {
            return 0;
        } else {
            int a = 0, b = 1, c = 0;
            for (int i = 1; i < num; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return b;
        }
    }
    private static int fibonacciRecursivo(int num, int a, int b, int i) {
        if (num == 0) {
            return 0; 
        } else if (i < num) {
            return fibonacciRecursivo(num, b, a + b, i + 1);
        } else {
            return a;
        }
    }

    public static int fibonacci(int n) {
        if (n <= 2 && n != 0) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
