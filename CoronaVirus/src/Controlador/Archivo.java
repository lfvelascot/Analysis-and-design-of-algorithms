package Controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import modelo.Pais;


public class Archivo {
    
    private String fechaMod;

    public Archivo() {
        
    }


    public String obtenerFechaModificación() throws IOException {
        
        File fichero = new File("D:/Documents/NetBeansProjects/CoronaVirus/data/archivo.txt");
        long ms = fichero.lastModified();
        Date d = new Date(ms);
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        int dia = c.get(Calendar.MONTH);
        fechaMod = Integer.toString(c.get(Calendar.DAY_OF_MONTH)) + "/"
                + Integer.toString(c.get(Calendar.MONTH)) + "/"
                + Integer.toString(c.get(Calendar.YEAR))+"  "
                +Integer.toString(c.get(Calendar.HOUR_OF_DAY))+":"
                +Integer.toString(c.get(Calendar.MINUTE))+":"
                + Integer.toString(c.get(Calendar.SECOND));
        fechaMod = d.toString();
        return fechaMod;
    }
    public void escribir(ArrayList<Pais> lp) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("D:/Documents/NetBeansProjects/CoronaVirus/data/archivo.txt");
            pw = new PrintWriter(fichero);
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:/Documents/NetBeansProjects/CoronaVirus/data/archivo.txt"));
            bw.write("");
            bw.close();
            for (int i = 0; i < lp.size(); i++) {
                pw.println(lp.get(i).toString());
            }

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

    public ArrayList<Pais> leer() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        ArrayList<Pais> listaArchivo = new ArrayList<>();
        try {
            archivo = new File("D:/Documents/NetBeansProjects/CoronaVirus/data/archivo.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            String[] desco;
            while ((linea = br.readLine()) != null) {
                desco = linea.split("-");
                Pais p = new Pais(desco[0], Integer.parseInt(desco[1]), Integer.parseInt(desco[2]));
                listaArchivo.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return listaArchivo;
    }
}
