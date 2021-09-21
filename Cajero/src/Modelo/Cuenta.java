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
public class Cuenta {
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
    public void ingresarDinero(float dinero){
        this.saldo+=dinero;
    }
    public void retirarDinero(float dinero){
        saldo-=dinero;
    }
}
