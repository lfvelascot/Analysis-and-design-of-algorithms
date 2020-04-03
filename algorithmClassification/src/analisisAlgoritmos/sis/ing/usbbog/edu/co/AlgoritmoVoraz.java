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
public class AlgoritmoVoraz {

    static int[] monedas = {1000, 500, 200, 100, 50};
    static int[] vueltas = {0, 0, 0, 0, 0};
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("INGRESE EL VALOR DE VUELTAS ");
        vueltas(s.nextInt());
        imprimir();
    }

    private static void vueltas(int v) {
        for (int i = 0; v != 0; i++) {
            if (v % monedas[i] == 0) {
                vueltas[i] = v / monedas[i];
                break;
            } else {
                vueltas[i] = v / monedas[i];
                v = v % monedas[i];
            }
        }
    }
    
    private static void imprimir (){
        for (int i = 0; i < vueltas.length; i++){
            System.out.println("Monedas de "+monedas[i]+" son de "+vueltas[i]);
        }
    }
}

