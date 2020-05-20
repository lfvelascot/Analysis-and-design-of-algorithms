/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.ingsistemas.ada.panaderia.controlador.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author COMPURED
 */
public class ConexionOracle extends Conexion{

    public Connection con;

    public ConexionOracle() {
    }
    
    @Override
    public boolean conector(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexion de la base de datos\n"+ex);
            return false;
        }
    }

    @Override
    public Connection getCon() {
        return con;
    }
    
    
}
