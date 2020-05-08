
package test.persistencia;

import co.edu.usbbog.ingsistemas.ada.panaderia.controlador.logica.Gestion_Producto;
import co.edu.usbbog.ingsistemas.ada.panaderia.controlador.persistencia.DAO_Producto;
import co.edu.usbbog.ingsistemas.ada.panaderia.modelo.Producto;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class DaoProductoTest {

    static Logger logger = null;
    DAO_Producto dp;
    Producto pr, pm;
    Gestion_Producto gp;
    String busqueda;

    /**
     * Inicializacion de los objetos necesarios para la prueba
     *
     * @param dp: objecto con los metodos para la manipulacion de la base de
     * datos
     * @param gp: objeto con metodos de gestion de los productos
     * @param pr: objecto tipo producto el cual tendra los datos para ser
     * manipulados
     * @param pm: objeto clon de pr usado para la mosificacion.
     * @param busqueda: cadena de texto con el nombre del producto para ser
     * manipulado
     */
    public DaoProductoTest() {
        this.dp = new DAO_Producto();
        this.gp = new Gestion_Producto();
        this.pr = new Producto("PAN INTEGRAL", "05/06/2020", 1500.00, 2, "PROPIO", gp.fechaActual(), 3000.00);
        this.pm = this.pr;
        this.busqueda = pm.getNombre();
    }

    /**
     * Metodo de testeo de la insercion de datos a la base de datos
     */
    @Test
    public void insertTest() {
        assertTrue(dp.crearProducto((Producto) pr));
        assertTrue(!dp.crearProducto((Producto) pr));
    }

    /**
     * metodo de testeo de la eliminacion de un producto de la base de datos
     */
    @Test
    public void deleteTest() {
        assertTrue(dp.eliminarProducto(pr.getNombre(), "05/05/2020"));     
    }

    /**
     * Metodo de testeo de la modificacion de productos de la base de datos
     */
    @Test
    public void updateTest() {
        String nombre = "Pan Arabe", fechaV = "12/05/2020";
        double valor = 2500.00;
        pm.setNombre(nombre.toUpperCase());
        pm.setCosto(valor);
        pm.setFechaVencimiento(fechaV);
        pm.setTotal(valor * pm.getCantidad());
        System.out.println("**"+pm.toString());
        assertTrue(dp.editarProducto(pm, busqueda));
    }

    /**
     * Metodo de testeo de la busqueda de los objetos en la base de datos
     */
    @Test
    public void buscarTodosTest() {
        assertTrue(!dp.buscarTodosLosProductos().isEmpty()
                && dp.buscarTodosLosProductos().size() == 7);
        gp.listar(dp.buscarTodosLosProductos());
    }

    /**
     * Metodo de testeo del reporte de ventas de productos en una fecha
     * especifica
     */
    @Test
    public void reporteFechaTest() {
        assertTrue(!dp.buscarVentasDia("28/04/2020").isEmpty());
        gp.listar(dp.buscarVentasDia("28/04/2020"));
        assertTrue(dp.buscarVentasDia("30/04/2020").isEmpty());
    }

    /**
     * Metodo de testeo de la busqueda de un producto basandose en su nombre
     */
    @Test
    public void xbuscarPorNombreTest() {
        assertNotNull(dp.buscarProductoPorNombre(busqueda).get(0));
        System.out.println(dp.buscarProductoPorNombre(busqueda).get(0).toString());
    }

    /**
     * Metodo de testeo por medio del cual se realiza una consulta a la tabla
     * log en la base de datos, por medio de la busqueda del ultimo registro
     * ingresado en la tabla por medio del trigger
     */
    @After
    public void ReporteModificacionDB() {
        String acceso = dp.accesosALaBase();
        System.out.println(acceso);
        assertNotNull(acceso);
    }
}
