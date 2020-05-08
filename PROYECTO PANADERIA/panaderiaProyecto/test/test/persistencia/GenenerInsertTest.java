/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.persistencia;

import co.edu.usbbog.ingsistemas.ada.panaderia.controlador.persistencia.DAO_Producto;
import co.edu.usbbog.ingsistemas.ada.panaderia.modelo.Producto;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author COMPURED
 */
public class GenenerInsertTest {
    
    @Test
    public void test(){
        DAO_Producto gp = new DAO_Producto();
        List<Producto> pl = gp.buscarTodosLosProductos();
        for (int i = 0;i < pl.size();i++){
            System.out.println(gp.crearInsertProducto(pl.get(i))); 
        }
    }
}
