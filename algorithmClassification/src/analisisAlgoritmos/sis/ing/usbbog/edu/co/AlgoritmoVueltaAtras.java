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
public class AlgoritmoVueltaAtras {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("INGRESE EL PRECIO DEL PRODUCTO:");
        vueltaAtras(s.nextDouble());
    }

    private static void vueltaAtras(double precio) {
        // Se halla el valor del IVA
        double iva = (precio * 0.19);
        precio = precio - iva;
        System.out.printf("IVA 19%% = %.2f \n", iva);
        // Se halla el porcentaje para los trabajadores
        double trabajador = (precio * 0.005);
        precio = precio - trabajador;
        System.out.printf("PAGO A TRABAJADORES 0.5%% = %.2f \n", trabajador);
        // Se halla el valor de produccion
        double producion = (precio * 0.079);
        precio = precio - producion;
        System.out.printf("COSTO DE PRODUCCION 0.5%% = %.2f \n", producion);
        System.out.printf("PRECIO LIBRE DE PAGOS, IMPUESTOS Y DEMAS COSTOS DEL PRODUCTO = %.2f \n", precio);
    }
}

