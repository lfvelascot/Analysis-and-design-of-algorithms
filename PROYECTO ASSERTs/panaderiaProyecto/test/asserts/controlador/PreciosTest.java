/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asserts.controlador;

import co.edu.usbbog.ingsistemas.ada.panaderia.controlador.logica.Gestion_Producto;
import co.edu.usbbog.ingsistemas.ada.panaderia.modelo.Producto;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author COMPURED
 */
public class PreciosTest {
    
    Gestion_Producto gp;
    
    public PreciosTest() {
        this.gp = new Gestion_Producto();
    }
    
    @Test
    public void preciosPanes() {
        Producto pan1 = new Producto("PAN HUEVO UNID.", "25/05/2020", 500.00, 5, "PROPIA", gp.fechaActual(), 2500.00);
        Producto pan2 = new Producto("PAN MOGOLLA UNID.", "30/05/2020", 800.00, 5, "PROPIA", gp.fechaActual(), 4000.00);
        if (pan1.getNombre().contains("UNID.")) {
            assertTrue(pan1.getCosto() <= 500.00 && pan1.getCosto() >= 200);
        }
        if (pan2.getNombre().contains("UNID.")) {
            assertFalse("EL PRECIO DEL PRODUCTO ESTA FUERA DEL RANGO PERMITIDO", pan2.getCosto() <= 500.00 && pan2.getCosto() >= 200);
        }
        pan1.setNombre("PAN TAJADO BLANCO");
        pan1.setMarca("BIMBO");
        pan1.setCosto(2600.00);
        pan1.setTotal(pan1.getCosto() * pan1.getCantidad());
        assertTrue(pan1.getCosto() >= 1500.00 && pan1.getCosto() <= 3500.00);
    }

    @Test
    public void maximoProductos() {
        Producto pan1 = new Producto("PAN HUEVO UNID.", "25/05/2020", 500.00, 5, "PROPIA", gp.fechaActual(), 2500.00);
        Producto pan2 = new Producto("PAN MOGOLLA UNID.", "30/05/2020", 800.00, 50, "PROPIA", gp.fechaActual(), 4000.00);
        if (pan1.getNombre().contains("UNID.")) {
            assertTrue(pan1.getCantidad() <= 40);
        }
        if (pan2.getNombre().contains("UNID.")) {
            assertFalse("EL PRECIO DEL PRODUCTO ESTA FUERA DEL RANGO PERMITIDO", pan2.getCantidad()<= 40);
        }
    }

}
