
package test.persistencia;

import co.edu.usbbog.ingsistemas.ada.panaderia.controlador.persistencia.ConexionOracle;
import java.sql.Connection;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class ConexionDBTest {

    ConexionOracle co;
    Connection con;
    static Logger logger = null;

    /**
     * Inicializacion de los objetos para la conexion a la base de datos
     */
    public ConexionDBTest() {
        this.co = new ConexionOracle();
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
     * Anotacion que verifica la finalizacion de la prueba
     */
    @AfterClass
    public static void ejecutarDespues() {
        logger.info("Se han ejecutado los Tests…");
        logger = null;
    }

    /**
     * Metodo de testeo para comprobar la correcta conexion del programa a la
     * base de datos
     */
    @Test
    public void testConexion() {
        assertTrue(co.conector());
        con = co.getCon();
    }

    /**
     * Metodo de testeo para comprobar la conexion existente del programa con la
     * base de datos
     */
    @Test
    public void testObtenerConexion() {
        assertTrue(con == co.getCon());
    }
}
