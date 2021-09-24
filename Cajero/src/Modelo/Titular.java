/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author jdros
 */
public class Titular {
    static Connection con;
 static Conexion cx;
    protected String nombre;
    protected String apellido;
    
    public Titular (String nombre, String apellido){
        this.nombre=nombre;
        this.apellido=apellido;
    }
    
    protected void cambiarNombre(String nombre){
        this.nombre=nombre;
    }
    protected void cambiarApellido(String apellido){
        this.apellido=apellido;
    }
     public boolean ConsultarTitular(int IdentificacionABuscar){

    try {
        boolean consultaOK=false;
        cx = new Conexion();
        
        con = cx.getConexion();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery ("SELECT * FROM titular where Id_titular = " + IdentificacionABuscar);

        if (rs.next()==true) {
            rs.first();
            System.out.println(rs.getString("nombre"));
            consultaOK= true;
        }else{
            consultaOK=false;
        }

        stmt.close();
        con.close();

        return consultaOK;
    }
    catch ( Exception e ){
        System.out.println(e.getMessage());
        return false;
 }

 }
}
