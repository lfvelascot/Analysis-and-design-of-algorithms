package Controlador;

import java.util.ArrayList;
import java.util.Collections;
import modelo.Pais;


public class ListaPaises {

    private  ArrayList<Pais> listaPaises;
    private final Archivo a;
    

    public ListaPaises() {
        this.a = new Archivo();
        this.listaPaises = a.leer();
        Collections.sort(listaPaises);
        this.a.escribir(listaPaises);
    }

    public boolean crearPais(Pais p) {
        if (existePais(p.getNomPais())) {
            return false;
        } else {
            listaPaises.add(p);
            Collections.sort(listaPaises);
            a.escribir(listaPaises);
            return true;
        }
    }
    
    public boolean eliminarDatos(String nomString, int opc){
        Pais p = buscarPais(nomString);
        if (p != null){
            switch (opc) {
                case 1:
                    p.setNumContagiados(0);
                    break;
                case 2:
                    p.setNumMuertos(0);
                    break;
                case 3:
                    p.setNumContagiados(0);
                    p.setNumMuertos(0);
                    break;
            }
        listaPaises.set(buscarPosicion(nomString), p);
        Collections.sort(listaPaises);
        a.escribir(listaPaises);
        return true;
        }
        return false;
    }

    public boolean modificarPais(Pais p, String nomPais) {
        if (existePais(nomPais)) {
            listaPaises.set(buscarPosicion(nomPais), p);
            Collections.sort(listaPaises);
            a.escribir(listaPaises);
            return true;
        } else {
            return false;
        }
    }

    private boolean existePais(String nomPais) {
        return listaPaises.stream().anyMatch((p) -> (p.getNomPais().toLowerCase().equals(nomPais.toLowerCase())));
    }

    public Pais buscarPais(String nomString) {
        for (Pais p : listaPaises) {
            if (nomString.toLowerCase().equals(p.getNomPais().toLowerCase())){
                return p;
            }
        }
        return null;
    }
    
    public int buscarPosicion(String nomPais) {
        int pos = 0;
        for (int i = 0; i < listaPaises.size();i++) {
            if (nomPais.toLowerCase().equals(listaPaises.get(i).getNomPais().toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    public void eliminarPais(String nomPais) {
        Pais p = buscarPais(nomPais);
        if (p != null) {
            listaPaises.remove(p);
            Collections.sort(listaPaises);
            a.escribir(listaPaises);
        }
    }

    public String imprimirPaises() {
        if (listaPaises.isEmpty()) {
            return "NO HAY PAISES EN LA LISTA\n";
        } else {
            String list = "";
            for (Pais p : listaPaises) {
                list += p.toString() + "\n";
            }
            return list;
        }
    }

    public String totalMuertos() {
        if (listaPaises.isEmpty()){
            return "0";
        } else {
            int total = 0;
            listaPaises = a.leer();
            for (Pais p : listaPaises){
                total += p.getNumMuertos();
            }
            return String.valueOf(total);
        }
    }

    public String totalContagiados() {
        if (listaPaises.isEmpty()){
            return "0";
        } else {
            int total = 0;
            listaPaises = a.leer();
            for (Pais p : listaPaises) {
                total += p.getNumContagiados();
            }
            return String.valueOf(total);
        }
    }
    
    public ArrayList<Pais> listaPorMuertos(){
        ArrayList <Pais> listaMuertos = new ArrayList<>();
        listaPaises = a.leer();
        for (int i = 0; i < listaPaises.size(); i ++){
            for (int j = i+1;j < listaPaises.size()-1;j++){
                Pais aux = null;
                if (listaPaises.get(i).compareToMuertos(listaPaises.get(j)) == 1){
                    aux = listaPaises.get(i);
                    listaPaises.set(i, listaPaises.get(j));
                    listaPaises.set(j, aux);
                }
            }
        }
        listaMuertos = listaPaises;
        return listaMuertos;
    }

    public boolean estaVacia() {
        return listaPaises.isEmpty();
    }

    public int tamanio() {
        return listaPaises.size();
    }

    public Pais getPais(int i) {
        return listaPaises.get(i);
    }

}
