package test.controlador;

import co.edu.usbbog.ingsistemas.ada.panaderia.controlador.logica.Gestion_Producto;
import co.edu.usbbog.ingsistemas.ada.panaderia.modelo.Producto;
import static junit.framework.Assert.assertTrue;
import org.junit.After;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

public class AnadirBuscarEliminarTest {

    Gestion_Producto gp;
    Producto p;

    /**
     * Inicializacion de los objetos
     * @param Gestion_Product gp = objeto con todos los metodos de acceso al
     * sistema
     * @param Producto p = producto con valores aleatorios para el ejercicio
     */
    public AnadirBuscarEliminarTest() {
        this.gp = new Gestion_Producto();
        this.p = new Producto("PAN INTEGRAL", "05/06/2020", 1500.00, 2, "PROPIO", gp.fechaActual(), 3000.00);
    }

    /**
     * Este metodo de testeo se ejecutara antes, en el cual se comprobara el
     * correcto indexado del producto al sistema
     *
     * @param Gestion_Product gp = objeto con todos los metodos de acceso al
     * sistema
     * @param Producto p = producto con valores aleatorios para el ejercio
     */
    @Before
    public void testInicio() {
        assertTrue("SE AÑADIO EL ELEMENTO", gp.anadirElemento(p));
        assertTrue(!(gp.anadirElemento(p)));
    }

    /**
     * Metodo de testeo que se ejecutara despues del metodo de testeto principal
     * en donde se realizara el listado y la eliminacion del producto
     *
     * @param Gestion_Product gp = objeto con todos los metodos de acceso al
     * sistema
     * @param Producto p = producto con valores aleatorios para el ejercio
     */
    @After
    public void testConteo() {
        System.out.println(" - " + gp.tamanio());
        gp.listar(gp.getLita());
        assertTrue(gp.tamanio() == 8);
        assertTrue("SE ELIMINO EL ELEMENTO", gp.retirarElemento(p.getNombre(), gp.fechaActual()));
        assertTrue(gp.tamanio() == 7);
    }

    /**
     * Metodo principal donde se comprobara la busqueda del producto ingresado
     * al sistema
     *
     * @param Gestion_Product gp = objeto con todos los metodos de acceso al
     * sistema
     * @param Producto p = producto con valores aleatorios para el ejercio
     * @param Producto pb = objeto donde se almacenara la busqueda del producto
     * indexado
     */
    @Test
    public void testBuscarValor() {
        Producto pb = gp.buscarProducto(p.getNombre());
        assertNotNull(pb);
        assertTrue(pb.getNombre().equals(p.getNombre())
                && pb.getFechaC().equals(p.getFechaC())
                && pb.getFechaVencimiento().equals(p.getFechaVencimiento()));
    }
}
