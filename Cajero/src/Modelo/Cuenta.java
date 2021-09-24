/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author jdros
 */
public class Cuenta {
    static Connection con;
    static Conexion cx;
    private int numCuenta;
    private float saldo;
    private float maximoRetiro;
    
    public Cuenta (int numCuenta, float saldo, float maximoRetiro){
        this.numCuenta=numCuenta;
        this.saldo=saldo;
        this.maximoRetiro=maximoRetiro;
    }
    
    public float getMaximoRetiro(){
        return maximoRetiro;
    }
    public float getSaldo(){
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    public void ingresarDinero(float dinero){
        this.saldo+=dinero;
    }
    public void retirarDinero(float dinero){
        saldo-=dinero;
    }
     public Boolean ActualizarSaldo(){
    try
            {
           cx = new Conexion();
           con = cx.getConexion();
           PreparedStatement stmt = con.prepareStatement("UPDATE cuenta SET saldo = " +
           this.saldo+ " WHERE (numCuenta = " + this.numCuenta + ")");

            

            stmt.executeUpdate();
            stmt.close();
            
            con.close();
            return true;
            }
            catch ( Exception e )
            {
            System.out.println(e.getMessage());
            return false;
            }
   
   }
}
