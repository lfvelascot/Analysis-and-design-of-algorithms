package co.edu.usbbog.ingsistemas.ada.panaderia.controlador.persistencia;

import co.edu.usbbog.ingsistemas.ada.panaderia.modelo.Producto;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DAO_Producto implements Interface_Producto {

    private final ConexionOracle oracle;

    public DAO_Producto() {
        this.oracle = new ConexionOracle();
    }


    @Override
    public boolean crearProducto(Producto e) {
        if (e != null) {
            String sql = "INSERT INTO producto VALUES('";
            sql += e.getFechaC() + "', ";
            sql += "'" + e.getNombre() + "'" + ", ";
            sql += "'" + e.getMarca() + "'" + ", ";
            sql += "'" + e.getFechaVencimiento() + "'" + ", ";
            sql += "" + e.getCosto() + "" + ", ";
            sql += "" + e.getCantidad() + "" + ",";
            sql += "" + e.getTotal() + "" + " ";
            sql += ")";
            if (this.oracle.conector()) {
                Connection con = this.oracle.getCon();
                try {
                    Statement stm = con.createStatement();
                    stm.execute(sql);
                    stm.close();
                    con.close();
                    return true;
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public String crearInsertProducto(Producto e) {
        if (e != null) {
            String sql = "INSERT INTO producto VALUES('";
            sql += e.getFechaC() + "', ";
            sql += "'" + e.getNombre() + "'" + ", ";
            sql += "'" + e.getMarca() + "'" + ", ";
            sql += "'" + e.getFechaVencimiento() + "'" + ", ";
            sql += "" + e.getCosto() + "" + ", ";
            sql += "" + e.getCantidad() + "" + ",";
            sql += "" + e.getTotal() + "" + " ";
            sql += ")";
            return sql;
        }
        return null;
    }

    @Override
    public boolean editarProducto(Producto e, String nombre) {
        if (e != null && !"".equals(nombre)) {
            String sql = "UPDATE producto SET nombre = '" + e.getNombre() + "',"
                    + "marca = '" + e.getMarca() + "',"
                    + "fechav = '" + e.getFechaVencimiento() + "',"
                    + "costo = " + e.getCosto() + ","
                    + "cantidad = " + e.getCantidad() + ","
                    + "total = " + e.getTotal() + " WHERE nombre = '" + nombre + "'";
            if (this.oracle.conector()) {
                Connection con = this.oracle.getCon();
                try {
                    Statement stm = con.createStatement();
                    stm.execute(sql);
                    stm.close();
                    con.close();
                    return true;
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    @Override
    public boolean eliminarProducto(String nombreP, String fechaP) {
        if (!"".equals(nombreP)) {
            String sql = "DELETE FROM producto WHERE nombre = '" + nombreP + "' AND fecha LIKE '" + fechaP + "%'";
            if (this.oracle.conector()) {
                Connection con = this.oracle.getCon();
                try {
                    Statement stm = con.createStatement();
                    stm.execute(sql);
                    stm.close();
                    con.close();
                    return true;
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    @Override
    public List<Producto> buscarTodosLosProductos() {
        String sql = "SELECT * FROM producto ORDER BY fecha";
        List<Producto> listaProductos = new ArrayList<>();
        if (this.oracle.conector()) {
            try {
                Connection con = this.oracle.getCon();
                Statement stm = con.createStatement();
                ResultSet rs = (ResultSet) stm.executeQuery(sql);
                System.out.println(" - * - * "+rs.getRow());
                while (rs.next()) {
                    Producto e = new Producto((String) rs.getObject("nombre"),
                            (String) rs.getObject("fechav"),
                            toDouble(rs,"costo"),
                            toInteger(rs, "cantidad"),
                            (String) rs.getObject("marca"),
                            (String) rs.getObject("fecha"),
                            toDouble(rs,"total"));
                    listaProductos.add(e);
                }
                rs.close();
                stm.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Producto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaProductos;
    }
    
    public double toDouble(ResultSet rs, String casilla) throws SQLException {
        BigDecimal b = (BigDecimal) rs.getObject(casilla);
        String s = b.toString();
        return Double.parseDouble(s);
    }

    public Integer toInteger(ResultSet rs, String casilla) throws SQLException {
        BigDecimal b = (BigDecimal) rs.getObject(casilla);
        String s = b.toString();
        return Integer.parseInt(s);
    }

    @Override
    public List<Producto> buscarProductoPorNombre(String nombreP) {
        String sql = "SELECT * FROM producto WHERE nombre = '" + nombreP + "' ORDER BY fecha";
        List<Producto> listaProductos = new ArrayList<>();
        if (this.oracle.conector()) {
            try {
                Connection con = this.oracle.getCon();
                Statement stm = con.createStatement();
                ResultSet rs = (ResultSet) stm.executeQuery(sql);
                while (rs.next()) {
                    Producto e = new Producto((String) rs.getObject("nombre"),
                            (String) rs.getObject("fechav"),
                            toDouble(rs,"costo"),
                            toInteger(rs, "cantidad"),
                            (String) rs.getObject("marca"),
                            (String) rs.getObject("fecha"),
                            toDouble(rs,"total"));
                    listaProductos.add(e);
                }
                rs.close();
                stm.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Producto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaProductos;
    }


    @Override
    public String accesosALaBase() {
        String actualizacion = "", sql = "SELECT proceso, fecha FROM log WHERE id = (SELECT MAX(id) FROM log) ORDER BY fecha";
        if (this.oracle.conector()) {
            try {
                Connection con = this.oracle.getCon();
                Statement stm = con.createStatement();
                ResultSet rs = (ResultSet) stm.executeQuery(sql);
                while (rs.next()) {
                    actualizacion = ((String) rs.getObject("proceso")) + " hecho " + ((String) rs.getObject("fecha"));
                }
                rs.close();
                stm.close();
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        return actualizacion;
    }


    @Override
    public List<Producto> buscarVentasDia(String fecha) {
        String sql = "SELECT * FROM producto WHERE fecha like '" + fecha + "%' ORDER BY fecha";
        List<Producto> listaProductos = new ArrayList<>();
        if (this.oracle.conector()) {
            try {
                Connection con = this.oracle.getCon();
                Statement stm = con.createStatement();
                ResultSet rs = (ResultSet) stm.executeQuery(sql);
                while (rs.next()) {
                    Producto e = new Producto((String) rs.getObject("nombre"),
                            (String) rs.getObject("fechav"),
                            toDouble(rs,"costo"),
                            toInteger(rs, "cantidad"),
                            (String) rs.getObject("marca"),
                            (String) rs.getObject("fecha"),
                            toDouble(rs,"total"));
                    listaProductos.add(e);
                }
                rs.close();
                stm.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Producto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaProductos;
    }
}
