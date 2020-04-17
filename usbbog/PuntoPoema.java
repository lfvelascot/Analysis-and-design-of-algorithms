package usbbog;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class PuntoPoema {
    
    static int v = 0, l = 0, e = 0;
    static ArrayList<Palabra> palabrasEncontradas = new ArrayList<>();
    static String aeiou = "aeiouáéíóú", sign = ",.¿?!¡':;'";

    public static void main(String[] args) throws IOException {
        // Revisar Ruta del Archivo
        leerArchivo("D:/Documents/NetBeansProjects/iterativosRecursivos/poema.txt", true, null, null);
        System.out.println("-----LISTA-----");
        contadorMuestra();
        System.out.println("Palabra repetidas:");
        listarPalabras(0);
    }

    public static void leerArchivo(String archivo, boolean flag, FileReader f, BufferedReader b) throws FileNotFoundException, IOException {
        String verso = "";
        if (flag) {
            FileReader file = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(file);
            verso = buffer.readLine();
            System.out.println("      Y TE BUSQUE POR PUEBLOS");
            System.out.println(verso);
            contarVocalesConsonantesEspacioa(verso, 0, verso.length() - 1);
            palabras(verso, 0, verso.length() - 1, "");
            leerArchivo(archivo, false, file, buffer);
        } else {
            verso = b.readLine();
            if (verso != null) {
                System.out.println(verso);
                contarVocalesConsonantesEspacioa(verso, 0, verso.length() - 1);
                palabras(verso, 0, verso.length() - 1, "");
                leerArchivo(archivo, false, f, b);
            } else {
                System.out.println("                       POR: Jose Marti");
                b.close();
            }
        }
    }

    private static void palabras(String verso, int i, int exts, String palabra) {
        if (i == exts) {
            addLista(palabra);
        } else {
            String letra = String.valueOf(verso.charAt(i)).toLowerCase();
            if (palabra.length() == 1){
                palabra = palabra.toUpperCase();
            }
            if (vocales(letra, aeiou, 0, aeiou.length() - 1) || letras(letra) && !espacios(letra)) {
                palabra += letra;
                palabras(verso, i + 1, exts, palabra);
            } else if (!palabra.equals("")) {
                addLista(palabra);
                palabras(verso, i + 1, exts, "");
            }
        }
    }

    public static void addLista(String palabra) {
        if (palabrasEncontradas.isEmpty()) {
            Palabra cl1 = new Palabra(palabra, 1);
            palabrasEncontradas.add(cl1);
        }else if (existsPalabra(0, palabra)) {
            int pos = ubicacionPalabra(0, palabra);
            Palabra cl = new Palabra(palabra, palabrasEncontradas.get(pos).getNum() + 1);
            palabrasEncontradas.set(pos, cl);
        } else {
            Palabra cl1 = new Palabra(palabra, 1);
            palabrasEncontradas.add(cl1);
        }
    }
    
    private static void contarVocalesConsonantesEspacioa(String verso, int i, int exts) {
        if (i == exts) {
            String letra = String.valueOf(verso.charAt(i)).toLowerCase();
            if (vocales(letra, aeiou, 0, aeiou.length() - 1)) {
                v++;
            } else if (espacios(letra)) {
                e++;
            } else if (letras(letra)) {
                l++;
            }            
        } else {
            String letra = String.valueOf(verso.charAt(i)).toLowerCase();
            if (vocales(letra, aeiou, 0, aeiou.length() - 1)) {
                v++;
                contarVocalesConsonantesEspacioa(verso, i + 1, exts);
            } else if (espacios(letra)) {
                e++;
                contarVocalesConsonantesEspacioa(verso, i + 1, exts);
            } else if (letras(letra)) {
                l++;
                contarVocalesConsonantesEspacioa(verso, i + 1, exts);
            } else {
                contarVocalesConsonantesEspacioa(verso, i + 1, exts);
            }
        }
    }
    
    private static boolean vocales(String letra, String aeiou, int i, int exts) {
        if (String.valueOf(aeiou.charAt(i)).equals(letra)) {
            return true;
        } else if (i == exts && !String.valueOf(aeiou.charAt(i)).equals(letra)) {
            return false;
        } else if (i == exts && String.valueOf(aeiou.charAt(i)).equals(letra)) {
            return true;
        } else {
            return vocales(letra, aeiou, i + 1, exts);
        }
    }
    
    private static boolean espacios(String letra) {
        return letra.equals(" ");
    }
    
    private static boolean letras(String letra) {
        return !signos(letra, sign, 0, sign.length() - 1);
    }
    
    private static boolean signos(String letra, String sign, int i, int exts) {
        if (String.valueOf(sign.charAt(i)).equals(letra)) {
            return true;
        } else if (i == exts && !String.valueOf(sign.charAt(i)).equals(letra)) {
            return false;
        } else if (i == exts && String.valueOf(sign.charAt(i)).equals(letra)) {
            return true;
        } else {
            return signos(letra, sign, i + 1, exts);
        }
    }
    
    private static void contadorMuestra() {
        System.out.println("-VOCALES: " + v + "\n"
                + "-CONSONANTES: " + l + "\n"
                + "-ESPACIOS: " + e + "\n"
                + "-LETRAS: " + (v + l));
    }
    
    private static void listarPalabras(int i) {
        if (i == 0){
           Collections.sort(palabrasEncontradas);
        }
        if (i == palabrasEncontradas.size() - 1) {
            System.out.println(" - " + palabrasEncontradas.get(i).toString());
        } else {
            System.out.println(" - " + palabrasEncontradas.get(i).toString());
            listarPalabras(i + 1);
        }
    }
    
    private static boolean existsPalabra(int i, String palabra) {
        if (palabrasEncontradas.isEmpty()){
            return false;
        } else if (i == palabrasEncontradas.size() - 1 && palabrasEncontradas.get(i).getPalabra().equals(palabra)) {
            return true;
        } else if (i == palabrasEncontradas.size() - 1 && !palabrasEncontradas.get(i).getPalabra().equals(palabra)) {
            return false;
        } else if (palabrasEncontradas.get(i).getPalabra().equals(palabra)) {
            return true;
        } else {
            return existsPalabra(i + 1, palabra);
        }
    }
    
    private static int ubicacionPalabra(int i, String palabra) {
        if (palabrasEncontradas.isEmpty()){
            return -2;
        }else if (i == palabrasEncontradas.size() - 1 && palabrasEncontradas.get(i).getPalabra().equals(palabra)) {
            return i;
        } else if (i == palabrasEncontradas.size() - 1 && !palabrasEncontradas.get(i).getPalabra().equals(palabra)) {
            return -1;
        } else if (palabrasEncontradas.get(i).getPalabra().equals(palabra)) {
            return i;
        } else {
            return ubicacionPalabra(i + 1, palabra);
        }
    }
    
    public static class Palabra implements Comparable<Palabra>{
        String palabra;
        int num;
        public Palabra(String palabra, int num) {
            this.palabra = palabra;
            this.num = num;
        }
        
        public String getPalabra() {
            return palabra;
        }
        
        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        @Override
        public String toString() {
            if (num == 1) {
                return palabra + ": " + num + " vez";
            } else {
                return palabra + ": " + num + " veces";
            }
        }
        @Override
        public int compareTo(Palabra t) {
            if (num > t.num) {
                return -1;
            } else if (num < t.num) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
