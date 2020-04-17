package usbbog;


import java.util.Scanner;


public class TorresDeHanoi {

    static String disco1 = "   ( 1 )   ", disco2 = "  (  2  )  ", disco3 = " (   3   ) ", disco4 = "(    4    )", vacio = "    |    ";
    static String[] columna1 = {disco1, disco2, disco3, disco4};
    static final String[] discos = {disco1, disco2, disco3, disco4};
    static String[] columna2 = {vacio, vacio, vacio, vacio};
    static String[] columna3 = {vacio, vacio, vacio, vacio};
    static Scanner s = new Scanner(System.in);

    public static void main(String args[]) {
        //torresDeHanoi(4, 1, 2, 3, 0);
        System.out.println("--------------TORRES DE HANOI--------------");
        dibujar(0);
        System.out.println("INGRESE EL DISCO, LA COLUMNA DE ORIGEN Y LA COLUMNA DESTINO:");
        juego(s.nextInt(), s.nextInt(), s.nextInt(), 1);
    }

    public static void juego(int d, int o, int dest, int i) {
        if ((d == 0 && o == 0 && dest == 0) || validarColumna(0)) {
            System.out.println("FIN DEL JUEGO \n total de movimientos realizados = " + i);
        } else {
            moverDiscos(d, o, dest);
            dibujar(0);
            System.out.println("INGRESE EL DISCO, LA COLUMNA DE ORIGEN Y LA COLUMNA DESTINO:");
            juego(s.nextInt(), s.nextInt(), s.nextInt(), i + 1);
        }
    }

    public static void torresDeHanoi(int d, int inicio, int auxiliar, int fin, int i) {
        if (d != 0) {
            torresDeHanoi(d - 1, inicio, fin, auxiliar, i + 1);
            System.out.println("Mover Disco #" + d + " de " + inicio + " a " + fin + " I = " + i);
            moverDiscos(d, inicio, fin);
            dibujar(0);
            torresDeHanoi(d - 1, auxiliar, inicio, fin, i + 2);
        }
    }

    private static void dibujar(int i) {
        if (i == 3) {
            System.out.println("        " + columna1[i] + "        " + columna2[i] + "        " + columna3[i]);
        } else {
            System.out.println("        " + columna1[i] + "        " + columna2[i] + "        " + columna3[i]);
            dibujar(i + 1);
        }
    }

    private static void moverDiscos(int d, int inicio, int fin) {
        String[] start = hallarColumna(inicio), end = hallarColumna(fin);
        String disco = hallarDisco(d - 1, 0);
        if (start != null && end != null && disco != null && inicio != fin) {
            int pos = posicionDisco(disco, start, 3);
            if (pos > -1) {
                if (validarPos(pos, start)) {
                    int posLibre = posicionLibre(end, 3);
                    if (validarPosDestino(end, posLibre, d)) {
                        start[pos] = vacio;
                        end[posLibre] = disco;
                        ActualizarColumna(inicio, start);
                        ActualizarColumna(fin, end);
                    } else {
                        System.out.println("NO SE PUEDE UBICAR EL DISCO " + disco + " EN LA COLUMNA " + fin + " POS LIBRE = " + posLibre);
                    }
                } else {
                    System.out.println("NO SE PUEDE MOVER EL DISCO " + disco + " DE SU POSICION");
                }
            } else {
                System.out.println("NO SE ENCONTRO EL DISCO " + disco + " EN LA COLUMNA " + inicio);
            }
        } else {
            System.out.println("PROBLEMA CON LOS DATOS INGRESADOS :\n"
                    + "- Disco seleccionado debe ser 1,2,3,4\n"
                    + "- Columnas origen debe ser diferente a la columna destino\n"
                    + "- Columna origen y destino deben ser 1,2,3");
        }
    }

    public static String[] hallarColumna(int i) {
        switch (i) {
            case 1:
                return columna1;
            case 2:
                return columna2;
            case 3:
                return columna3;
        }
        return null;
    }

    public static void ActualizarColumna(int i, String[] c) {
        switch (i) {
            case 1:
                columna1 = c;
                break;
            case 2:
                columna2 = c;
                break;
            case 3:
                columna3 = c;
                break;
        }
    }

    private static int posicionLibre(String[] end, int i) {
        if (i < 0) {
            return -1;
        } else if ("    |    ".equals(end[i])) {
            return i;
        } else {
            return posicionLibre(end, i - 1);
        }
    }

    private static String hallarDisco(int d, int i) {
        if (i < 0 || i > 3) {
            return null;
        } else if (d == 3) {
            return discos[3];
        } else if (d == i) {
            return discos[i];
        } else {
            return hallarDisco(d, i + 1);
        }
    }

    private static int posicionDisco(String disco, String[] c, int i) {
        if (i < 0) {
            return -1;
        } else if (c[i].equals(disco)) {
            return i;
        } else {
            return posicionDisco(disco, c, i - 1);
        }
    }

    private static int pesoDisco(String disco, int i) {
        if (disco.equals(disco1)) {
            return 1;
        } else if (disco.equals(disco2)) {
            return 2;
        } else if (disco.equals(disco3)) {
            return 3;
        } else {
            return 4;
        }
    }

    private static boolean validarPos(int pos, String[] columna) {
        if (pos != 0) {
            return columna[pos - 1].equals(vacio);
        } else {
            return true;
        }
    }

    private static boolean validarPosDestino(String[] end, int posLibre, int disco) {
        switch (posLibre) {
            case -1:
                return false;
            case 3:
                return true;
            default:
                return pesoDisco(end[posLibre + 1], 3) > disco;
        }
    }

    private static boolean validarColumna(int i) {
        if (i == 3) {
            return discos[3].equals(columna3[3]);
        } else if (discos[i].equals(columna3[i])) {
            return validarColumna(i + 1);
        } else {
            return false;
        }
    }

}
