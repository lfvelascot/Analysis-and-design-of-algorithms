/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisAlgoritmos.sis.ing.usbbog.edu.co;

import java.util.Scanner;
/**
 * @author Luis Felipe Velasco
 */
public class AlgoritmoComputacional {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("INGRESE EL VALOR PARA LA RAIZ CUADRADA:");
        int n = s.nextInt();
        System.out.println("La raíz representada por multiplos es:\n"+ metodo1(n)+" = "+Math.sqrt(n));
    }

    private static String metodo1(int n) {
        String raiz = "";
        int aux = n, x = 2, i = 0;
        int[] numeros = new int [10]; 
	// Ciclo While para hallar los múltiplos del valor ingresado
        while (aux != 1) {
            if (aux%x == 0){
                numeros[i] = x;
                aux /= x;
                i++;
            } else {
                x++;
            }
        }
        i = 0;
	// Ciclo While para hallar las constantes enteras y las raíces inexactas del valor n
        while (numeros[i] != 0) {
            if (i + 1 < 10) {
                if (numeros[i] == numeros[i + 1] && numeros[i] * numeros[i + 1] != 0) {
                    raiz += "("+numeros[i] + ")";
                    i = i + 2;
                }
                if (numeros[i] != 0 && numeros[i] * numeros[i + 1] == 0 || numeros[i] != numeros[i + 1]) {
                    raiz += "(sqrt(" + numeros[i] + "))";
                    i++;
                }
            }
        }
        return raiz;
    }
    
    
}

