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
public class AlgoritmoEncaminamiento {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Calle calle1 = new Calle("Calle 38", 8.4, "Calle 100");
        Calle calle2 = new Calle("Calle 100", 10.5, "Calle 50");
        Calle calle3 = new Calle("Calle 78", 8.4, "Calle 3");
        Calle calle4 = new Calle("Calle 50", 8.4, "Calle 12");
        Calle calle5 = new Calle("Calle 101", 8.4, "Calle 100");
        Calle calle6 = new Calle("Calle 12", 8.4, "Calle 6");
        Calle calle7 = new Calle("Calle 3", 8.4, "Calle 100");
        Calle calle8 = new Calle("Calle 4", 8.4, "Calle 6");
        Calle calle9 = new Calle("Calle 5", 8.4, "Calle 12");
        Calle calle10 = new Calle("Calle 6", 8.4, "Ciega");
        Calle[] calles = new Calle[11];
        calles[1] = calle1;
        calles[2] = calle2;
        calles[3] = calle3;
        calles[4] = calle4;
        calles[5] = calle5;
        calles[6] = calle6;
        calles[7] = calle7;
        calles[8] = calle8;
        calles[9] = calle9;
        calles[10] = calle10;
        System.out.println("----Lista de cale----");
        imprimirLista(calles);
        System.out.println("Ingrese la calle origen y la calle destino");
        String calleOrigen = s.nextLine(), calleDestino = s.nextLine();
        encaminamiento(calleOrigen, calleDestino, calles);

    }

    private static void imprimirLista(Calle[] calles) {
        for (int i = 1; i < calles.length; i++) {
            System.out.println(calles[i].toString());
        }
    }

    private static void encaminamiento(String calle1, String calle2, Calle[] calles) {
        Calle calleOrigen = existenciaCalle(calle1, calles);
        Calle calleDestino = existenciaCalle(calle2, calles);
        if (calleOrigen != null && calleDestino != null) {
            distanciarecorrida(calleOrigen, calleDestino, calles);
        } else {
            System.out.println(" Por favor revice los parametros ingresados");
        }
    }

    private static Calle existenciaCalle(String calleOrigen, Calle[] calles) {
        for (int i = 1; i < calles.length; i++) {
            if (calles[i].getNombre().equals(calleOrigen)) {
                return calles[i];
            }
        }
        return null;
    }

    private static void distanciarecorrida(Calle calleOrigen, Calle calleDestino, Calle[] calles) {
        Calle interm = existenciaCalle(calleOrigen.getSiguiente(), calles);
        double dist1 = 0.0, dist2 = 0.0;
        if (calleOrigen.getSiguiente().equals(calleDestino.getNombre())) {
            dist1 = calleOrigen.getDistancia();
        } else if (interm.getSiguiente().equals(calleDestino.getNombre())) {
            dist2 = calleOrigen.getDistancia() + interm.getDistancia();
        }
        if (dist1 != 0.0 && dist2 == 0.0) {
            System.out.println("Desde la calle: " + calleOrigen.getNombre() + " a la calle: " + calleDestino.getNombre() + " solo son " + calleOrigen.getDistancia());
        } else if (dist2 != 0.0 && dist1 == 0.0) {
            System.out.println("Desde la calle origen hasta la calle destino\nse hace el siguiente recorrido con una distancia de " + dist2 + " km. : \n"
                    + "1. " + calleOrigen.getNombre() + "\n"
                    + "2. " + interm.getNombre() + "\n"
                    + "2. " + calleDestino.getNombre() + "\n");
        } else {
            System.out.println("No hay forma de llegar desde la calle : " + calleOrigen.getNombre() + " hasta la calle :" + calleDestino.getNombre() + " cruzando solo dos calles");
        }
    }

    static class Calle {

        String nombre;
        double distancia;
        String siguiente;

        public Calle(String nombre, double distancia, String siguiente) {
            this.nombre = nombre;
            this.distancia = distancia;
            this.siguiente = siguiente;
        }

        public Calle() {
        }

        public String getNombre() {
            return nombre;
        }

        public double getDistancia() {
            return distancia;
        }


        public String getSiguiente() {
            return siguiente;
        }


        @Override
        public String toString() {
            return nombre + " - Extension : " + distancia + " km. - Calle Siguiente : " + siguiente + "\n";
        }
    }

}
