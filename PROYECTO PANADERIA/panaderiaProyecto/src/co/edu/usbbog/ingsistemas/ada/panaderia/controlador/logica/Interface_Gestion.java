/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.ingsistemas.ada.panaderia.controlador.logica;

import co.edu.usbbog.ingsistemas.ada.panaderia.modelo.Producto;
import java.util.List;

/**
 *
 * @author COMPURED
 */
public interface Interface_Gestion {

    boolean anadirElemento(Producto ob);

    boolean retirarElemento(String ob, String fecha);

    boolean modificar(Producto ob, String id);

    void actualizarLista();
    
    List getLita();
    
    boolean existsElemento(Producto p);
}
