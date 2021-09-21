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
public class Cajero{
    private int numCajero;
    private double monto;
    
    public Cajero(int numCajero, double monto){
        this.numCajero=numCajero;
        this.monto=monto;
    }
    
    public void consignarDinero(float dinero){
        monto+=dinero;
    }
    public void retirarDinero(float dinero){

        monto-=dinero;
    }
    public double getMonto(){
        return monto;
    }
}
