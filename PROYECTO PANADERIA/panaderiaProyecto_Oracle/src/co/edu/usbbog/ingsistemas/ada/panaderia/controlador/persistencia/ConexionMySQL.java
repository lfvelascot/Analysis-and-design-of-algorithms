package co.edu.usbbog.ingsistemas.ada.panaderia.controlador.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionMySQL extends Conexion{

    private Connection con;
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String user = "panaderia_app";
    private final String pass = "password";
    private final String url = "jdbc:mysql://localhost:3306/panaderia_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public ConexionMySQL() {
    }

    @Override
    public boolean conector() throws SQLException {
        con = null;
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, pass);
            if (con != null) {
                return true;
            }
        } 
        catch (ClassNotFoundException | SQLException e) {
            return false;
        }
        return false;
    }
    @Override
    public Connection getCon() {
        return con;
    }
}
