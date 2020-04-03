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
public class AlgoritmoEscalada {
    static Scanner s = new Scanner(System.in);
    static double tol = 0.0;
    static double xSiguiente  = 0.0;
    static double x0 = 0.0;
    static double error = 0.0;

    public static void main(String[] args) {
        System.out.println("----------------------METODO DE NEWTON-RHAPSON----------------------\n"
                            + "Ingrese el punto de partida(flotante) para evaluar la siguiente función\n"
                            + "                     18x^3-8x^2+7x-4");
        x0 = s.nextDouble();
        System.out.println("Ingrese la tolerancia a error de la función");
        tol = s.nextDouble();
        metodoNewton();
        System.out.println("----------------------SOLUCÓN----------------------\n"
                            + "RAÍZ MAS O MENOS EN EL PUNTO X = "+x0);
    }

    private static void metodoNewton() {
        System.out.println("VALOR INICIAL = " + x0);
        do {
            double f1 = f(x0), f2 = fp(x0);
            xSiguiente = x0 - ( f1/ f2);
            if (xSiguiente > x0){
                error = xSiguiente-x0;
            } else {
                error = x0-xSiguiente;
            }
            System.out.println("x = " + x0 + ""
                    + " f(x) = " + f1 + ""
                    + " x(i+1) = " + xSiguiente + ""
                    + " f(x(i+1)) = " + f(xSiguiente) + ""
                    + " error = " + error);
            x0 = xSiguiente;
        } while (tol < error);
    }

    public static double f (double x){
        return (18*x*x*x)-(8*x*x)+(7*x)-4;
    }
    
        public static double fp (double x){
        return (54*x*x)-(16*x)+7;
    }
}
