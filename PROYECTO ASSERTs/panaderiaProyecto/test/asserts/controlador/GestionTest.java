/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asserts.controlador;

import co.edu.usbbog.ingsistemas.ada.panaderia.controlador.logica.Gestion_Producto;
import co.edu.usbbog.ingsistemas.ada.panaderia.modelo.Producto;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author COMPURED
 */
public class GestionTest {
    
    Gestion_Producto gp;
    
    public GestionTest() {
        this.gp = new Gestion_Producto();
    }
    
    @Before
    public void testTamañoLista(){
        List<Producto> lp = gp.getLita();
        lp.forEach((p) -> {
            System.out.println(" - "+p.toString());
        });
        assertTrue("El tamaño no coresponde", lp.size() == 8);
        assertFalse("El tamaño no coresponde", lp.size() == 10);
    }
    
    @Test
    public void testCrearBuscarEliminar(){
        Producto p = new Producto("PAN INTEGRAL", "10/06/2020", 3000.00, 2,
                "BIMBO", gp.fechaActual(), 6000.00);
        assertTrue(gp.anadirElemento(p));
        String[] productoO = {p.getNombre(),p.getFechaC(),String.valueOf(p.getTotal())};
        Producto pb = gp.buscarProducto(p.getNombre());
        String[] productoB = {pb.getNombre(),pb.getFechaC(),String.valueOf(pb.getTotal())};
        assertArrayEquals("Los productos no son iguales", productoO, productoB);
        assertTrue(gp.retirarElemento(p.getNombre(), "19/05/2020"));
    }
    @Test
    public void testEliminar(){
        Producto p = new Producto("PAN INTEGRAL", "10/06/2020", 3000.00, 2,
                "BIMBO", gp.fechaActual(), 6000.00);
        assertTrue(gp.anadirElemento(p));
        assertTrue("El objeto no fue eliminado", gp.retirarElemento(p.getNombre(),
                "19/05/2020"));
        assertNotNull(gp.getpEliminado());
        assertNotEquals(p, gp.getpEliminado());
    }
    
    @Test
    public void testFormatearFecha(){
        String fechaMal = "1/2/2009";
        String fechaBien = Gestion_Producto.parseFecha(fechaMal);
        assertEquals(fechaBien, "01/02/2009");
    }
    
    @Test
    public void testObtenerFechaAct(){
        String fecha = gp.fechaActual();
        System.out.println("fecha : -----"+fecha);
        Producto p = new Producto("PAN INTEGRAL", "10/06/2020",
                3000.00, 2, "BIMBO", fecha, 6000.00);
        gp.anadirElemento(p);
        gp.retirarElemento(p.getNombre(),fecha);
        String fechac = gp.fechaActual();
        System.out.println("fecha : -----"+fechac);
        //8
        assertFalse(fecha.equals(fechac));
    }
    
    @Test
    public void testModificarProducto(){
        Producto p = new Producto("PAN INTEGRAL", "10/06/2020", 3000.00, 2,
                "BIMBO", gp.fechaActual(), 6000.00);
        assertTrue(gp.anadirElemento(p));
        p.setNombre("PAN BLANCO");
        p.setFechaC(gp.fechaActual());
        p.setCosto(2700.00);
        p.setTotal(p.getCosto()*p.getCantidad());
        assertTrue(gp.modificar(p, "Pan INTEGRAL"));
        Producto pb = new Producto("PAN INTEGRAL", "10/06/2020", 3000.00,
                2, "BIMBO", gp.fechaActual(), 6000.00);
        Producto pe = gp.buscarProducto("PAN BLANCO");
        assertNotNull(pe);
        assertNotEquals(pe, pb);
    }
    
}
