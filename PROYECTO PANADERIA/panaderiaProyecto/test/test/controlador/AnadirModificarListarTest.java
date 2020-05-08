
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

public class AnadirModificarListarTest {

    Gestion_Producto gp;
    Producto p, pb;
    static Logger logger = null;

    /**
     *Se inicializan los objetos requeridos para la prueba
     * @param gp = objeto de gestion de los productos del sistema
     * @param p,pb = productos que se usaran para la prueba
     * @see El objeto logger se inicializa afuera debido a que se requiere que sea de tipo estatico
     */
    public AnadirModificarListarTest() {
        this.gp = new Gestion_Producto();
        this.p = new Producto("PAN INTEGRAL", "05/06/2020", 1500.00, 2, "PROPIO", gp.fechaActual(), 3000.00);
        this.pb = null;
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
     *En esta prueba que se realiza previamente
     * se valida la correcta indexacion
     * de los valores al sistema, y que no se puedan añadir objetos vacios
     */
    @Before
    public void testAnadirProducto() {
        assertTrue(gp.anadirElemento(p));
        assertTrue(!gp.anadirElemento(pb));
    }

    /**
     *
     */
    @After
    public void testEliminar() {
        System.out.println("Antes de Eliminar");
        gp.listar(gp.getLita());
        assertTrue(gp.retirarElemento(pb.getNombre(), "05/05/2020"));
        System.out.println("Despues de Eliminar");
        gp.listar(gp.getLita());
        System.out.println("**" + gp.getpEliminado().toString());
        assertTrue(gp.getpEliminado().toString().equals(pb.toString()));
    }

    /**
     * Metodo de testeo en donde se evalua 
     * la correcta modifiacion del objeto previamente añadido
     */
    @Test
    public void testModificar() {
        double costoM = 2550.00;
        int cantidadM = 3;
        double totalM = costoM * cantidadM;
        pb = new Producto("PAN ARABE", "10/07/2020", costoM, cantidadM, "BIMBO", gp.fechaActual(), totalM);
        assertNotSame(pb, p);
        assertTrue(gp.modificar(pb, p.getNombre()));
    }
}
