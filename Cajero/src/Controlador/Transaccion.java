/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author jdros
 */
public class Transaccion {
    private Cajero cajero;
    static Connection con;
 static Conexion cx;
    
    public Transaccion (){
        cajero = new Cajero(147852369, 100000000.2541);
    }
    
    public void retirarDinero(float cantidad,int numTarjeta){
        Tarjeta t =getDatosTarjeta(numTarjeta);
        Cuenta c=getDatosCuenta(numTarjeta);
        int pin;
        int contador=0;
        boolean transaccionCorrecta=false;
        if(t!=null && t.getEstadotarjeta()!=false){
            if(c != null){
                while(!transaccionCorrecta && contador<3){
                    pin=Integer.parseInt(JOptionPane.showInputDialog("Ingrese su contraseña"));
                    if(pin!=t.getPin()){
                        JOptionPane.showMessageDialog(null, "Contraseña invalida","Error",JOptionPane.ERROR_MESSAGE);
                        contador++;
                    } else{
                        transaccionCorrecta=true;
                    }
                    
                }
                if(contador<3){
                    if(!(cantidad>cajero.getMonto())){
                        if(!(cantidad>c.getMaximoRetiro())){
                            if(!(cantidad>c.getSaldo())){
                                c.retirarDinero(cantidad);
                                cajero.retirarDinero(cantidad);
                                JOptionPane.showConfirmDialog(null, "Transacción realizada correctamente");
                            }else {
                                JOptionPane.showMessageDialog(null, "Fondos insuficientes en la cuenta","Transacción Cancelada",JOptionPane.ERROR_MESSAGE);
                            }
                        }else {
                            JOptionPane.showMessageDialog(null, "Cantidad supera el monto permitido","Transacción Cancelada",JOptionPane.ERROR_MESSAGE);
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "No hay fondos suficientes en el cajero","Transacción Cancelada",JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    t.bloquearTarjeta();
                    JOptionPane.showMessageDialog(null, "Demasiados intentos, tarjeta bloqueada","Transacción Cancelada",JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cuenta no encontrada","Transacción Cancelada",JOptionPane.ERROR_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(null, "Tarjeta Invalidad","Transacción Cancelada",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void consignarDinero(float cantidad, int numTarjeta){
        Tarjeta t =getDatosTarjeta(numTarjeta);
        Cuenta c=getDatosCuenta(numTarjeta);
        int pin;
        int contador=0;
        boolean transaccionCorrecta=false;
        if(t!=null && t.getEstadotarjeta()!=false){
            if(c != null){
                while(!transaccionCorrecta && contador<3){
                    pin=Integer.parseInt(JOptionPane.showInputDialog("Ingrese su contraseña"));
                    if(pin!=t.getPin()){
                        JOptionPane.showMessageDialog(null, "Contraseña invalida","Error",JOptionPane.ERROR_MESSAGE);
                        contador++;
                    } else{
                        transaccionCorrecta=true;
                    }    
                }
                if(contador<3){
                    c.ingresarDinero(cantidad);
                    cajero.consignarDinero(cantidad);
                    JOptionPane.showConfirmDialog(null, "Transacción realizada correctamente");
                }else{
                    t.bloquearTarjeta();
                    JOptionPane.showMessageDialog(null, "Demasiados intentos, tarjeta bloqueada","Transacción Cancelada",JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cuenta no encontrada","Transacción Cancelada",JOptionPane.ERROR_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(null, "Tarjeta Invalidad","Transacción Cancelada",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void consultarSaldo(int numTarjeta){
        Tarjeta t =getDatosTarjeta(numTarjeta);
        Cuenta c=getDatosCuenta(numTarjeta);
        int pin;
        int contador=0;
        boolean transaccionCorrecta=false;
        if(t!=null && t.getEstadotarjeta()!=false){
            if(c != null){
                while(!transaccionCorrecta && contador<3){
                    pin=Integer.parseInt(JOptionPane.showInputDialog("Ingrese su contraseña"));
                    if(pin!=t.getPin()){
                        JOptionPane.showMessageDialog(null, "Contraseña invalida","Error",JOptionPane.ERROR_MESSAGE);
                        contador++;
                    } else{
                        transaccionCorrecta=true;
                    }    
                }
                if(contador<3){
                    float saldo =c.getSaldo();
                    JOptionPane.showConfirmDialog(null, "Su saldo es: $"+Float.toString(saldo));
                }else{
                    t.bloquearTarjeta();
                    JOptionPane.showMessageDialog(null, "Demasiados intentos, tarjeta bloqueada","Transacción Cancelada",JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cuenta no encontrada","Transacción Cancelada",JOptionPane.ERROR_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(null, "Tarjeta Invalidad","Transacción Cancelada",JOptionPane.ERROR_MESSAGE);
        }
    }
    public Tarjeta getDatosTarjeta(int numTarjeta){
        /* Consultar datos en la base de datos
            Si existe retornar el objeto tarjeta si no devolver null
        */
       
          try {
        boolean consultaOK=false;
        Tarjeta tar=null;
        cx = new Conexion();
        con = cx.getConexion();
        con.setAutoCommit(false);
        Statement stmt = con.createStatement();
        PreparedStatement stmt2 = con.prepareStatement("SELECT * FROM cuenta where numCuenta = ?");
        ResultSet rs = stmt.executeQuery ("SELECT * FROM tarjeta where numTarjeta = " + numTarjeta);

        if (rs.next()==true) {
           stmt2.setString(1,rs.getString("numCuenta"));
           ResultSet rs2= stmt2.executeQuery();
           rs2.next();
           Cuenta c= new Cuenta(Integer.parseInt(rs2.getString("numCuenta")) , Float.parseFloat(rs2.getString("saldo")), Float.parseFloat(rs2.getString("max_retiro")));
            
           Boolean est= (rs.getString("estadoTarjeta").equals("Activo") || rs.getString("estadoTarjeta").equals("activo")); 
           tar= new Tarjeta(rs2.getString("nombre"),rs2.getString("apellido"),Integer.parseInt(rs.getString("numTarjeta")), Integer.parseInt(rs.getString("pin")),est , c);
            
           
            System.out.println(tar.getEstadotarjeta());
            consultaOK= true;
        }else{
            consultaOK=false;
        }

        stmt.close();
        stmt2.close();
        con.close();

        return tar;
    }
    catch ( Exception e ){
        System.out.println(e.getMessage());
        return null;
    }
          
        
    }
    public Cuenta getDatosCuenta(int numTarjeta){
     
       try {
        boolean consultaOK=false;
        Cuenta c=null;
        cx = new Conexion();
        con = cx.getConexion();
        con.setAutoCommit(false);
        Statement stmt = con.createStatement();
        PreparedStatement stmt2 = con.prepareStatement("SELECT * FROM cuenta where numCuenta = ?");
        ResultSet rs = stmt.executeQuery ("SELECT * FROM tarjeta where numTarjeta = " + numTarjeta);

        if (rs.next()==true) {
           stmt2.setString(1,rs.getString("numCuenta"));
           ResultSet rs2= stmt2.executeQuery();
           rs2.next();
          c= new Cuenta(Integer.parseInt(rs2.getString("numCuenta")) , Float.parseFloat(rs2.getString("saldo")), Float.parseFloat(rs2.getString("max_retiro")));
            
           
            
          
            System.out.println(c.getSaldo());
            consultaOK= true;
        }else{
            consultaOK=false;
        }

        stmt.close();
        stmt2.close();
        con.close();

        return c;
    }
    catch ( Exception e ){
        System.out.println(e.getMessage());
        return null;
    }
    }
     public Boolean ActualizarSaldo(Cuenta cuenta){
    try
            {
           cx = new Conexion();
           con = cx.getConexion();
           PreparedStatement stmt = con.prepareStatement("UPDATE cuenta SET saldo = " +
           cuenta.getSaldo()+ " WHERE (numCuenta = " + cuenta.getNumCuenta() + ")");

            

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
