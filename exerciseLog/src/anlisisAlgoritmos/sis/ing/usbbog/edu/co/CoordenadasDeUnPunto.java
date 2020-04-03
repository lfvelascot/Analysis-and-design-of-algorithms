/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anlisisAlgoritmos.sis.ing.usbbog.edu.co;

import java.util.Scanner;

/**
 *
 * @author COMPURED
 */
public class CoordenadasDeUnPunto {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(coordenadas(s.nextDouble(), s.nextDouble()));
    }
    private static String coordenadas(double x, double y) {
        if (x == 0.0 && y != 0.0) {
            return "Eixo Y";
        } else if (x != 0.0 && y == 0.0) {
            return "Eixo X";
        } else if (x > 0) {
            if (y > 0) {
                return "Q1";
            } else  {
                return "Q4";
            }
        } else if (x < 0) {
            if (y > 0) {
                return "Q2";
            } else  {
                return "Q3";
            }
        } else {
            return "Origem";
        }
    }
}

