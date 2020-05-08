/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.controlador;

import co.edu.usbbog.ingsistemas.ada.panaderia.controlador.logica.Gestion_Producto;
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
public class FechasTest {

    Gestion_Producto gp;
    static Logger logger = null;

    public FechasTest() {
        this.gp = new Gestion_Producto();
    }

    /**
     * Anotacion que verifica la iniciacion de la prueba
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
     * En este metodo se comprueba el correcto formateo de la fecha y hora actual
     * requerida en la indexacion de los productos
     */
    @Test
    public void testFechas(){
        String  fecha = "05/05/2020";
        String hora  = "13";
        String fechaHActual = gp.fechaActual();
        System.out.println(" = "+fechaHActual);
        assertTrue(fechaHActual.contains(fecha) && fechaHActual.contains(hora));
    }
}
