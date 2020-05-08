package co.edu.usbbog.ingsistemas.ada.panaderia.controlador.persistencia;

import co.edu.usbbog.ingsistemas.ada.panaderia.modelo.Producto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_Producto implements Interface_Producto{

    private final ConexionMySQL mySQL;

    public DAO_Producto() {
        this.mySQL = new ConexionMySQL();
    }

    @Override
    public boolean crearProducto(Producto e) {
        if (e != null) {
            String sql = "INSERT INTO panaderia_db.producto VALUES('";
            sql += e.getFechaC()+ "', ";
            sql += "\"" + e.getNombre() + "\"" + ", ";
            sql += "\"" + e.getMarca() + "\"" + ", ";
            sql += "\"" + e.getFechaVencimiento() + "\"" + ", ";
            sql += "\"" + e.getCosto() + "\"" + ", ";
            sql += "\"" + e.getCantidad() + "\"" + ", ";
            sql += "\"" + e.getTotal() + "\"" + " ";
            sql += ");";
            try {
                if (this.mySQL.conector()) {
                    Connection con = this.mySQL.getCon();
                    try {
                        Statement stm = con.createStatement();
                        stm.execute(sql);
                        stm.close();
                        con.close();
                        return true;
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                        return false;
                    }
                } else {
                    return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Producto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            return false;
        }
        return false;
    }
    
    
    @Override
    public boolean editarProducto(Producto e, String nombre) {
        if (e != null && nombre != "") {
            String sql = "UPDATE panaderia_db.producto SET fecha = '" + e.getFechaC()
                    + "', nombre = '" + e.getNombre() + "',"
                    + "marca = '" + e.getMarca() + "',"
                    + "fechav = '" + e.getFechaVencimiento() + "',"
                    + "costo = '" + e.getCosto() + "',"
                    + "cantidad = '" + e.getCantidad() + "',"
                    + "total = '" + e.getTotal() + "' WHERE nombre = '" + nombre + "';";
            try {
                if (this.mySQL.conector()) {
                    Connection con = this.mySQL.getCon();
                    try {
                        Statement stm = con.createStatement();
                        stm.execute(sql);
                        stm.close();
                        con.close();
                        return true;
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                        return false;
                    }
                } else {
                    return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Producto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            return false;
        }
        return false;
    }

    @Override
    public boolean eliminarProducto(String nombreP, String fechaP) {
        if (nombreP != "") {
            String sql = "DELETE FROM panaderia_db.producto WHERE nombre = '" + nombreP + "' AND fecha LIKE '"+fechaP+"%';";
            try {
                if (this.mySQL.conector()) {
                    Connection con = this.mySQL.getCon();
                    try {
                        Statement stm = con.createStatement();
                        stm.execute(sql);
                        stm.close();
                        con.close();
                        return true;
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                        return false;
                    }
                } else {
                    return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Producto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            return false;
        }
        return false;
    }

    @Override
    public List<Producto> buscarTodosLosProductos() {
        String sql = "SELECT * FROM panaderia_db.producto;";
        List<Producto> listaProductos = new ArrayList<>();
        try {
            if (this.mySQL.conector()) {
                try {
                    Connection con = this.mySQL.getCon();
                    Statement stm = con.createStatement();
                    ResultSet rs = (ResultSet) stm.executeQuery(sql);
                    while (rs.next()) {
                        Producto e = new Producto((String) rs.getObject("nombre"),
                                (String) rs.getObject("fechav"),
                                (double) rs.getObject("costo"),
                                (Integer) rs.getObject("cantidad"),
                                (String) rs.getObject("marca"),
                                (String) rs.getObject("fecha"),
                                (double) rs.getObject("total"));
                        listaProductos.add(e);
                    }
                    rs.close();
                    stm.close();
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_Producto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProductos;
    }

    @Override
    public List<Producto> buscarProductoPorNombre(String nombreP) {
        String sql = "SELECT * FROM panaderia_db.producto WHERE nombre = '" + nombreP + "';";
        List<Producto> listaProductos = new ArrayList<>();
        try {
            if (this.mySQL.conector()) {
                try {
                    Connection con = this.mySQL.getCon();
                    Statement stm = con.createStatement();
                    ResultSet rs = (ResultSet) stm.executeQuery(sql);
                    while (rs.next()) {
                        Producto e = new Producto((String) rs.getObject("nombre"),
                                (String) rs.getObject("fechav"),
                                (double) rs.getObject("costo"),
                                (Integer) rs.getObject("cantidad"),
                                (String) rs.getObject("marca"),
                                (String) rs.getObject("fecha"),
                                (double) rs.getObject("total"));
                        listaProductos.add(e);
                    }
                    rs.close();
                    stm.close();
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_Producto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProductos;
    }

    @Override
    public String accesosALaBase() {
        String actualizacion = "", sql = "SELECT proceso, fecha FROM log WHERE id = (SELECT MAX(id) FROM log);";
        try {
            if (this.mySQL.conector()) {
                try {
                    Connection con = this.mySQL.getCon();
                    Statement stm = con.createStatement();
                    ResultSet rs = (ResultSet) stm.executeQuery(sql);
                    while (rs.next()) {
                        actualizacion = ((String) rs.getObject("proceso")) + " hecho " + ((String) rs.getObject("fecha"));
                    }
                    rs.close();
                    stm.close();
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return actualizacion;
    }

    @Override
    public List<Producto> buscarVentasDia(String fecha) {
        String sql = "SELECT * FROM panaderia_db.producto WHERE fecha like '"+fecha+"%';";
        List<Producto> listaProductos = new ArrayList<>();
        try {
            if (this.mySQL.conector()) {
                try {
                    Connection con = this.mySQL.getCon();
                    Statement stm = con.createStatement();
                    ResultSet rs = (ResultSet) stm.executeQuery(sql);
                    while (rs.next()) {
                        Producto e = new Producto((String) rs.getObject("nombre"),
                                (String) rs.getObject("fechav"),
                                (double) rs.getObject("costo"),
                                (Integer) rs.getObject("cantidad"),
                                (String) rs.getObject("marca"),
                                (String) rs.getObject("fecha"),
                                (double) rs.getObject("total"));
                        listaProductos.add(e);
                    }
                    rs.close();
                    stm.close();
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_Producto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProductos;
    }
}
