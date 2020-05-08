package co.edu.usbbog.ingsistemas.ada.panaderia.controlador.persistencia;

import co.edu.usbbog.ingsistemas.ada.panaderia.modelo.Producto;
import java.util.List;

public interface Interface_Producto {

    public boolean crearProducto(Producto p);

    public boolean editarProducto(Producto e, String nombre);

    public boolean eliminarProducto(String nombreP, String fechaP);
    
    public List<Producto> buscarTodosLosProductos();

    public List<Producto> buscarProductoPorNombre(String nombre);
    
    public String accesosALaBase();
    
    public List<Producto> buscarVentasDia (String fecha);

}
