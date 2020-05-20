
package test.controlador;

import co.edu.usbbog.ingsistemas.ada.panaderia.controlador.logica.Gestion_Producto;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TotalVentasTest {

    Gestion_Producto gp;
    static Logger logger = null;
    double total = 0.0;

    /**
     *
     */
    public TotalVentasTest() {
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
     * Anotacion que verifica la finalizacion de la prueba
     */
    @AfterClass
    public static void ejecutarDespues() {
        logger.info("Se han ejecutado los Tests…");
        logger = null;
    }

    /**
     * antes de la ejecucion del test se obtiene la lista para relacionarla con
     * el valor del total
     */
    @Before
    public void obtenerTotal() {
        gp.listar(gp.getLita());
        total = 21500.0;
    }

    /**
     * Metodo de testeo en donde se relaciona el valor esperado deltotal con el
     * entregado por el metodo totalPagos
     */
    @Test
    public void testTotalVentasGeneral() {
        System.out.println("----------" + total + "\n" + gp.totalPagos(gp.getLita()));
        assertTrue(total == gp.totalPagos(gp.getLita()));
    }

    /**
     * Metodo de testeo posterior al pincipal en donde se relaciona las ventas
     * de un dia, dando la fecha con en valor esperado
     */
    @Test
    public void testTotalVentasPorDia() {
        gp.listar(gp.reportePorDia("28/04/2020"));
        total = 10000.0;
        System.out.println("----------" + total + "\n" + gp.totalPagos(gp.reportePorDia("28/04/2020")));
        assertTrue(total == gp.totalPagos(gp.reportePorDia("28/04/2020")));
    }
    /**
     * Metodo de testeo para las ventas de una fecha no existente
     * en el sistema
     */
    @Test
    public void testTotalVentasFechaNoExitente() {
        assertTrue(0.0 == gp.totalPagos(gp.reportePorDia("30/04/2020")));
    }
}
