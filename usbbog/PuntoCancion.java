package usbbog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PuntoCancion {

    public static void main(String[] args) throws IOException {
        //Revizar Rutas de los archivos
        System.out.println("                    SAY SO ");
        leerArchivo("D:/Documents/NetBeansProjects/iterativosRecursivos/cancionOriginal.txt", true,true, null, null);
        System.out.println("                SIN VOCALES");
        leerArchivo("D:/Documents/NetBeansProjects/iterativosRecursivos/cancionModificada.txt", true,false, null, null);
        //Si quiere conservar el contenido del fichero obtenido, documente la siguiente linea
        limpiarFichero("D:/Documents/NetBeansProjects/iterativosRecursivos/cancionModificada.txt");
    }

    public static void escribir(String cancion) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("D:/Documents/NetBeansProjects/iterativosRecursivos/cancionModificada.txt", true);
            pw = new PrintWriter(fichero);
            pw.println(cancion);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void leerArchivo(String archivo, boolean flag, boolean i, FileReader f, BufferedReader b) throws FileNotFoundException, IOException {
        String cancion = "";
        if (flag) {
            FileReader file = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(file);
            cancion = buffer.readLine();
            System.out.println(cancion);
            if (i) {
                quitarVocales(cancion, "", 0, cancion.length());
            }
            leerArchivo(archivo, false, i, file, buffer);
        } else {
            if ((cancion = b.readLine()) != null) {
                System.out.println(cancion);
                if (i) {
                    quitarVocales(cancion, "", 0, cancion.length());
                }
                leerArchivo(archivo, false, i, f, b);
            } else {
                b.close();
            }
        }
    }


    public static void quitarVocales(String cancion, String cancionMod, int i, int exts) {
        if (i == exts) {
           escribir(cancionMod);
        } else {
            String aeiou = "aeiou";
            String letra = String.valueOf(cancion.charAt(i)).toLowerCase();
            if (!vocales(letra,aeiou,0,aeiou.length()-1)) {
                quitarVocales(cancion, cancionMod, i + 1, exts);
            } else{
                cancionMod +=letra;
                quitarVocales(cancion, cancionMod, i + 1, exts);
            }
        }
    }

    private static boolean vocales(String letra, String aeiou, int i, int exts) {
        if (String.valueOf(aeiou.charAt(i)).equals(letra)) {
            return false;
        } else if (i == exts && !String.valueOf(aeiou.charAt(i)).equals(letra)) {
            return true;
        } else if (i == exts && String.valueOf(aeiou.charAt(i)).equals(letra)) {
            return false;
        } else {
            return vocales(letra, aeiou, i + 1, exts);
        }
    }

    private static void limpiarFichero(String fichero) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {
            bw.write("");
        }
    }
}
