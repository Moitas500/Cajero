/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Julie
 */
public class Conexion {
     public Connection getConexion(){
        String driver = "com.mysql.jdbc.Driver";
        String connectString = "jdbc:mysql://localhost:3306/cajero";
        String user = "root";
        String password = "";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user , password);
            return con;
        }
        catch ( Exception e ){
            System.out.println(e.getMessage());
            return null;
        }
     }
}
