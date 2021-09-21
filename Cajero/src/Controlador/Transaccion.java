/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import javax.swing.JOptionPane;

/**
 *
 * @author jdros
 */
public class Transaccion {
    private Cajero cajero;
    
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
    private Tarjeta getDatosTarjeta(int numTarjeta){
        /* Consultar datos en la base de datos
            Si existe retornar el objeto tarjeta si no devolver null
        */
        return null;
    }
    private Cuenta getDatosCuenta(int numTarjeta){
        /* Consultar datos en la base de datos
            Si existe retornar el objeto Cuenta si no devolver null
        */
        return null;
    }
}
