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
public class Operaciones {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a =s.nextInt(), b = s.nextInt();
        operaciones(a, b);
        operacionesRecurisvas(a, b, 0);
    }

    private static void operacionesRecurisvas(int a, int b, int oper) {
        switch (oper) {
            case 4:
                System.out.println(a + "^2 = " + (a * a) + "  " + b + "^2 = " + (b * b));
                break;
            case 0:
                System.out.println("OPERACIONES RECURSIVAS\n"+a + " + " + b + " = " + (a + b));
                operacionesRecurisvas(a, b, oper + 1);
                break;
            case 1:
                System.out.println(a + " - " + b + " = " + (a - b));
                operacionesRecurisvas(a, b, oper + 1);
                break;
            case 2:
                System.out.println(a + " x " + b + " = " + (a * b));
                operacionesRecurisvas(a, b, oper + 1);
                break;
            case 3:
                double div = (double) a / b;
                System.out.println(a + " / " + b + " = " + div);
                operacionesRecurisvas(a, b, oper + 1);
                break;
            default:
                break;
        }
    }

    private static void operaciones(int a, int b) {
        double div = (double) a / b;
        System.out.printf("OPERACIONES ITERATIVAS\n"
                + "%d + %d = %d \n"
                + " %d - %d = %d \n"
                + " %d x %d = %d \n"
                + " %d / %d = %.2f \n"
                + " %d ^2 = %d     %d ^2 = %d \n",
                a, b, (a + b), a, b, (a - b), a, b, (a * b), a, b, div, a, (a * a), b, (b * b));
    }
}
