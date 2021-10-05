/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author jdros
 */
public class Tarjeta extends Titular{
    private int numTarjeta;
    private int pin;
    private boolean estadoTarjeta;
    private Cuenta cuenta;
    
    public Tarjeta(String nombre, String apellido,int numTarjeta, int pin, boolean estadoTarjeta, Cuenta cueta){
        super(nombre,apellido);
        this.numTarjeta=numTarjeta;
        this.pin=pin;
        this.estadoTarjeta=estadoTarjeta;
        this.cuenta=cuenta;
    }
    
   public int getPin()
   {
       return pin;
   }

    public int getNumTarjeta() {
        return numTarjeta;
    }
   
   public void cambiarPin(int pin){
       this.pin=pin;
   }
   public boolean getEstadotarjeta(){
       return estadoTarjeta;
   }
   public void bloquearTarjeta(){
       estadoTarjeta=false;
   }
   public void desbloqueartarjeta(){
       estadoTarjeta=true;
   }
    
}
