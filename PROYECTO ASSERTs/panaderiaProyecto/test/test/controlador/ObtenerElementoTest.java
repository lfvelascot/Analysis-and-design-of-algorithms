/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.controlador;

import co.edu.usbbog.ingsistemas.ada.panaderia.controlador.logica.Gestion_Producto;
import co.edu.usbbog.ingsistemas.ada.panaderia.modelo.Producto;
import java.util.logging.Logger;
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
public class ObtenerElementoTest {

    Gestion_Producto gp;
    static Logger logger = null;

    /**
     * Se inicializa la clase de gestion de productos
     */
    public ObtenerElementoTest() {
        this.gp = new Gestion_Producto();
    }
    
    /**
     *Anotacion que verifica la iniciacion de la prueba
     */
    @BeforeClass
    public static void ejecutarAntes() {
        logger = Logger.getLogger("TestAnotacionesJUnit");
        logger.info("Se van a ejecutar los Tests…");
    }

    /**
     *Anotacion que verifica la finalizacion de la prueba
     */
    @AfterClass
    public static void ejecutarDespues() {
        logger.info("Se han ejecutado los Tests…");
        logger = null;
    }
    /**
     * Se imprime la lista para verificar la busqueda
     */
    @Before
    public void setUp() {
        System.out.println("Listado elementos");
        gp.listar(gp.getLita());
    }

   /**
    * En este metodo se valida que los productos en las posiciones 3 y 5 corresponden a los deseados
    */
    @Test
    public void testBusqueda() {
        assertTrue(gp.getProducto(3).toString().contains("PAN MOGOLLA INTEGRAL PROPIA"));
        assertTrue(gp.getProducto(5).toString().contains("MARGARINA GUSTOSITA"));
        assertNull(gp.getProducto(8));
    }
}
