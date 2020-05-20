/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.ingsistemas.ada.panaderia.controlador.logica;

import co.edu.usbbog.ingsistemas.ada.panaderia.controlador.persistencia.DAO_Producto;
import co.edu.usbbog.ingsistemas.ada.panaderia.modelo.Producto;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author COMPURED
 */
public class Gestion_Producto implements Interface_Gestion {

    private List<Producto> listaProductos = new ArrayList<>();
    private DAO_Producto productosDB = new DAO_Producto();
    private Producto pEliminado = null;

    public Gestion_Producto() {
        this.listaProductos.clear();
        this.listaProductos = productosDB.buscarTodosLosProductos();
    }

    @Override
    public void actualizarLista() {
        this.listaProductos.clear();
        listaProductos = productosDB.buscarTodosLosProductos();
    }

    @Override
    public List getLita() {
        return listaProductos;
    }

    @Override
    public boolean existsElemento(Producto p) {
        if (!listaProductos.isEmpty()) {
            for (int i = 0; i < listaProductos.size(); i++) {
                if (listaProductos.get(i).getFechaC().equals(p.getFechaC()) && listaProductos.get(i).getNombre().equals(p.getNombre())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean anadirElemento(Producto ob) {
        if (ob != null) {
            if (!existsElemento(ob)) {
                productosDB.crearProducto(ob);
                actualizarLista();
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    @Override
    public boolean retirarElemento(String ob, String fecha) {
        actualizarLista();
        if (!listaProductos.isEmpty()) {
            for (int i = 0; i < listaProductos.size(); i++) {
                if (listaProductos.get(i).getNombre().toUpperCase().equals(ob)) {
                    pEliminado = listaProductos.get(i);
                    fecha = parseFecha(fecha);
                    productosDB.eliminarProducto(ob,fecha);
                    actualizarLista();
                    return true;
                }
            }
        }
        return false;
    }

    public Producto getpEliminado() {
        return pEliminado;
    }
    
    public static String parseFecha(String f) {
        DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        try {
            fecha = hourdateFormat.parse(f);
        } catch (ParseException ex) {
            System.out.println("ex" + ex);
        }
        return hourdateFormat.format(fecha);
    }

    @Override
    public boolean modificar(Producto ob, String id) {
        if (ob != null && !"".equals(id) && !existsElemento(ob)){
            productosDB.editarProducto(ob, id);
            actualizarLista();
            return true;
        }
        return false;
    }

    public List<Producto> reportePorDia(String fecha){
        return productosDB.buscarVentasDia(fecha);
    }
    
    public double totalPagos(List<Producto> lista) {
        double total = 0.0;
        if (!lista.isEmpty()) {
            for (int i = 0; i < lista.size(); i++) {
                total += lista.get(i).getTotal();
            }
        }
        return total;
    }

    public Producto buscarProducto(String producto) {
        if (!listaProductos.isEmpty()) {
            for (int i = 0; i < listaProductos.size(); i++) {
                if (listaProductos.get(i).getNombre().equals(producto)) {
                    return listaProductos.get(i);
                }
            }
        }
        return null;
    }

    public String obtenerFechaActualizacionDB() {
        return productosDB.accesosALaBase();
    }

    public boolean estaVacia() {
        return listaProductos.isEmpty();
    }

    public Producto getProducto(int i) {
        if (i >= 0 && i < tamanio()) {
            return listaProductos.get(i);
        } else {
            return null;
        }
    }

    public int tamanio() {
        actualizarLista();
        return listaProductos.size();
    }

    public boolean validarFecha(String[] fecha) {
        try {
            int d = Integer.parseInt(fecha[0]),m = Integer.parseInt(fecha[1]),a = Integer.parseInt(fecha[2]);
            return (d >= 1 && d <= 31) && (m >= 1 && m <= 12);
        } catch (NumberFormatException e) {
            System.err.println(e);
            return false;
        }
    }
    
    public String fechaActual() {
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return hourdateFormat.format(date);
    }

    public void listar(List<Producto> lista) {
        if (!lista.isEmpty()) {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(i + " - " + lista.get(i).toString());
            }
        }
    }
}

