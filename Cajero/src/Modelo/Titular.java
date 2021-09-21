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
public class Titular {
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
}
