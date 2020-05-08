/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.ingsistemas.ada.panaderia.controlador.persistencia;

import java.sql.Connection;
import java.sql.SQLException;


public abstract class Conexion {
    private Connection con;

    public Conexion() {
    }
    
    public abstract boolean conector() throws SQLException;

    public Connection getCon() {
        return con;
    }
    
    
    
}
