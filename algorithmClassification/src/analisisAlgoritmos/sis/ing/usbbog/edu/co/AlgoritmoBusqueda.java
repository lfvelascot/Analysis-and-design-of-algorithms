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
public class AlgoritmoBusqueda {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] animales = {"Perro", "Gato", "Elefante", "Jirafa", "Gusano", "Araña", "Pelicano", "Pato", "Mariposa", "Avestruz"};
        int opc;
        do {
            System.out.println("----ANIMALES----\n"
                    + "1. Mostrar todo\n"
                    + "2. Buscar un animal por su nombre\n"
                    + "3. Buscar animales por inicial\n"
                    + "4. Salir\n");
            opc = s.nextInt();
            switch (opc) {
                case 1:
                    for (int i = 0; i < animales.length; i++) {
                        System.out.println(i + ". " + animales[i]);
                    }
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Ingrese el animal que quiere encontrar");
                    String busqueda = s.next();
                    boolean flag = false;
                    for (String animale : animales) {
                        if (animale.toUpperCase().equals(busqueda.toUpperCase())) {
                            flag = !flag;
                            break;
                        }
                    }
                    if (flag) {
                        System.out.println(busqueda + " si se encuentra en la lista");
                    } else {
                        System.out.println(busqueda + " no se encuentra en la lista");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese la inicial (en MAY) de los animales que quiere buscar");
                    char b = s.next().charAt(0);
                    String lista = "";
                    for (String animale : animales) {
                        if (animale.charAt(0) == b) {
                            lista += " - " + animale + "\n";
                        }
                    }
                    if (!"".equals(lista)) {
                        System.out.println("LISTA DE ANIMALES CON LA LETRA " + b + "\n" + lista);
                    } else {
                        System.out.println("No hay animales que inicien por la letra " + b);
                    }
                    break;
                case 4:
                    System.out.println("FIN PROGRAMA");
                    break;
                default:
                    System.out.println("Valor invalido");
                    break;
            }
        } while (opc != 4);
    }
}
