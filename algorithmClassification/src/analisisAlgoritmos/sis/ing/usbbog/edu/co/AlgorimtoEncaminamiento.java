package analisisAlgoritmos.sis.ing.usbbog.edu.co;

import java.util.Scanner;

/**
 * @author Luis Felipe Velasco
 */
public class AlgorimtoEncaminamiento {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        Producto producto1 = new Producto(1010465, "Leche Alpina", 1600.15);
        Producto producto2 = new Producto(1010465, "Arroz Diana", 1550.20);
        Producto producto3 = new Producto(1010465, "Arroz FlorHuila", 1650.00);
        Producto producto4 = new Producto(1010465, "Arroz Supremo", 1700.15);
        Producto producto5 = new Producto(1010465, "Leche Algarra", 1500.15);
        Producto producto6 = new Producto(1010465, "Aceite Gourmet", 10400.15);
        Producto producto7 = new Producto(1010465, "Aceite Premier", 15471.15);
        Producto producto8 = new Producto(1010465, "Torta Ramo", 15471.15);
        Producto[] listaProductos = new Producto[8];
        listaProductos[0] = producto1;
        listaProductos[1] = producto2;
        listaProductos[2] = producto3;
        listaProductos[3] = producto4;
        listaProductos[4] = producto5;
        listaProductos[5] = producto6;
        listaProductos[6] = producto7;
        listaProductos[7] = producto8;
        System.out.println("INGRESE LOS DIAS QUE QUIERA SIMULAR:");
        int dias = s.nextInt();
        System.out.println("-----LISTA INICIAL-----");
        imprimirLis(listaProductos);
        variacion(listaProductos, dias);
    }

    public static void imprimirLis(Producto[] listaProductos) {
        for (Producto aux : listaProductos) {
            System.out.println(aux.toString());
        }
    }

    public static void variacion(Producto[] listaProductos, int dias) {
        int x = 0;
        while (dias != x) {
            System.out.println("-----DIA " + (x + 1) + "-----\n Ingrese la variación de los precios al publico para los productos:\n"
                    + "1.Ingrese la variacion de la leche\n"
                    + "2. Ingrese la variacion de los arroces\n"
                    + "3. Ingrese la variacion de los aceites");
            double leche = s.nextDouble(), arroz = s.nextDouble(), aceite = s.nextDouble();
            for (Producto aux : listaProductos) {
                asignación(leche, arroz, aceite, aux);
            }
            System.out.println("------LISTA DE PRODUCTOS DIA " + (x + 1) + "-----");
            imprimirLis(listaProductos);
            x++;
        }
    }

    private static void asignación(double leche, double arroz, double aceite, Producto aux) {
        double variacion = 0.0;
        if (aux.getNombre().contains("Arroz")) {
            variacion = Math.round(aux.getPrecio() * (arroz + 0.01));
            aux.setPrecio(variacion);
        } else if (aux.getNombre().contains("Leche")) {
            variacion = Math.round(aux.getPrecio() * (leche) + 3.4);
            aux.setPrecio(variacion);
        } else if (aux.getNombre().contains("Aceite")) {
            variacion = Math.round(aux.getPrecio() * (aceite + 0.14));
            aux.setPrecio(variacion);
        } else {
            System.out.println("------------------- PRODUCTO SIN CLASIFICACIÓN-------------------\n"
                    + aux.toString());
        }

    }

    public static class Producto {

        int cod;
        String nombre;
        double precio;

        public Producto(int cod, String nombre, double precio) {
            this.cod = cod;
            this.nombre = nombre;
            this.precio = precio;
        }

        public int getCod() {
            return cod;
        }
        
        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        @Override
        public String toString() {
            return " - " + nombre + " - Codigo:" + cod + " Precio : $" + precio;
        }
    }

}
