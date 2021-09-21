/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author jdros
 */
public class Usuario extends Titular{
    private int identificacion;
    private int edad;
    private ArrayList<Cuenta> cuentas;
    
    public Usuario(String nombre, String apellido,int identificacion, int edad, ArrayList<Cuenta> cuentas){
        super(nombre,apellido);
        this.identificacion=identificacion;
        this.edad=edad;
        this.cuentas=cuentas;
    }
    
    public void cambiarIdentificacion(int identificacion){
        this.identificacion=this.identificacion;
    }
    public void cambiarEdad(int edad){
        this.edad=edad;
    }
    /*
    
    Acá irían los metodos de añadir o eliminar una cuenta... pero no se si sea 
    necesario ya que estamos trabajando un cajero y no un banco
    */
    
}
