/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asserts.controlador;

import co.edu.usbbog.ingsistemas.ada.panaderia.controlador.logica.Gestion_Producto;
import co.edu.usbbog.ingsistemas.ada.panaderia.controlador.persistencia.DAO_Producto;
import co.edu.usbbog.ingsistemas.ada.panaderia.modelo.Producto;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author COMPURED
 */
public class baseDatosTest {
    
    DAO_Producto dp;
    Gestion_Producto gp;
    
    
    public baseDatosTest() {
        this.dp = new DAO_Producto();
        this.gp = new Gestion_Producto();
    }
    
    @After
    public void reporteTest(){
        String reporte = dp.accesosALaBase();
        //
        assertTrue(reporte.contains("eliminado"));
    }
    
    @Test
    public void todosLosReportes(){
        List<Producto> lp = dp.buscarTodosLosProductos();
        //
        assertFalse(lp.isEmpty());
        int t =  lp.size();
        Producto pan1 = new Producto("PAN HUEVO UNID.", "25/05/2020", 500.00, 5, "PROPIA", gp.fechaActual(), 2500.00);
        //
        assertTrue(dp.crearProducto(pan1));
        lp = dp.buscarTodosLosProductos();
        //
        assertNotEquals(t, lp.size());
        assertTrue(dp.eliminarProducto(pan1.getNombre(), pan1.getFechaC()));
    }
    
}
