/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usbbog;


import java.util.Arrays;
import java.util.Scanner;
import static usbbog.SumarNumerosArreglo.s;

/**
 *
 * @author TAO
 */
public class BuscarCadena {

    static Scanner s = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("BUSCAR ELEMENTO ITERATIVO = " + buscarElemento(llenarMatriz(s.nextInt()), s.next().toUpperCase()));
        System.out.println("BUSCAR ELEMENTO RECURSIVO = " + buscarelementoRecursivo(llenarMatrizR(0, 0, s.nextInt(), null), s.next().toUpperCase(), 0, 0));
    }

    private static String[][] llenarMatriz(int n) {
        String[][] matriz = new String[n][n];
        for (String[] matriz1 : matriz) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz1[j] = s.next().toUpperCase();
            }
        }
        return matriz;
    }

    private static String[][] llenarMatrizR(int i, int j, int ext, String[][] matriz) {
        if (i == 0 && j == 0) {
            String[][] m = new String[ext][ext];
            m[i][j] = s.next().toUpperCase();
            return llenarMatrizR(i, j + 1, ext, m);
        } else if (i != ext) {
            matriz[i][j] = s.next().toUpperCase();
            if (j == ext - 1) {
                return llenarMatrizR(i + 1, 0, ext, matriz);
            } else {
                return llenarMatrizR(i, j + 1, ext, matriz);
            }
        } else {
            return matriz;
        }
    }


    private static String buscarElemento(String[][] matriz, String elemento) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j].equals(elemento)) {
                    return elemento + " SE ENCUENTRA EN LA POSICIÓN [" + (i + 1) + "]-[" + (j + 1) + "]";
                }
            }
        }
        return "NO SE ENCONTRO A " + elemento + " EN LA MATRIZ";
    }

    private static String buscarelementoRecursivo(String[][] matriz, String elemento, int i, int j) {
        if (matriz[i][j].equals(elemento)) {
            return elemento + " SE ENCUENTRA EN LA POSICIÓN [" + (i + 1) + "]-[" + (j + 1) + "]";
        } else if (i == matriz.length - 1 && j == matriz.length - 1) {
            return "NO SE ENCONTRO A " + elemento + " EN LA MATRIZ";
        } else {
            if (j == matriz.length - 1) {
                return buscarelementoRecursivo(matriz, elemento, i + 1, 0);
            } else {
                return buscarelementoRecursivo(matriz, elemento, i, j + 1);
            }
        }
    }
}
