/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Tarjeta;
import Vista.Ventana;
import Vista.VentanaUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author camil
 */
public class Controlador implements ActionListener{
    
    private Ventana vista1;
    private Transaccion modelo;
    
    private void consignarRetirar(boolean tipo, float dinero, int tarjeta){
        if(tipo){
            modelo.consignarDinero(dinero, tarjeta);
        }else{
            modelo.retirarDinero(dinero, tarjeta);
        }
    }
    
    public Controlador(Ventana vista, Transaccion modelo){
        this.vista1 = vista;
        this.modelo = modelo;
        this.vista1.setVisible(true);
        this.vista1.setLocationRelativeTo(null);
        this.vista1.ingTarjeta.addActionListener(this);
        this.vista1.borrar.addActionListener(this);
        this.vista1.numero0.addActionListener(this);
        this.vista1.numero9.addActionListener(this);
        this.vista1.numero8.addActionListener(this);
        this.vista1.numero7.addActionListener(this);
        this.vista1.numero6.addActionListener(this);
        this.vista1.numero4.addActionListener(this);
        this.vista1.numero5.addActionListener(this);
        this.vista1.numero3.addActionListener(this);
        this.vista1.numero2.addActionListener(this);
        this.vista1.numero1.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String accion = ae.getActionCommand();
        boolean tipo = false;
        Tarjeta tarjetaPrueba;
        float cantidad;
        int numTarjeta = 0;
        this.vista1.numTarjeta.setEditable(true);
        String texto = this.vista1.numTarjeta.getText();
        
        if(accion.equals("1")){
            texto += "1";
        }else if(accion.equals("2")){
            texto += "2";
        }else if(accion.equals("3")){
            texto += "3";
        }else if(accion.equals("4")){
            texto += "4";
        }else if(accion.equals("5")){
            texto += "5";
        }else if(accion.equals("6")){
            texto += "6";
        }else if(accion.equals("7")){
            texto += "7";
        }else if(accion.equals("8")){
            texto += "8";
        }else if(accion.equals("9")){
            texto += "9";
        }else if(accion.equals("0")){
            texto += "0";
        }else if(accion.equals("<-")){
            texto = "";
        }else if(accion.equals("ingTarjeta")){
            numTarjeta = Integer.parseInt(this.vista1.numTarjeta.getText());
            tarjetaPrueba = this.modelo.getDatosTarjeta(numTarjeta);
            if(tarjetaPrueba == null){
                JOptionPane.showMessageDialog(null, "La tarjeta ingresada no existe", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else{
                int contador = 0;
                boolean validado = false;
                while(contador < 3){
                    String pin = JOptionPane.showInputDialog("Escriba el pin de la cuenta");
                    if(Integer.parseInt(pin) == tarjetaPrueba.getPin()){
                        contador = 3;
                        validado = true;
                    }else{
                        JOptionPane.showMessageDialog(null, "El pin no es el correcto", "ERROR", JOptionPane.WARNING_MESSAGE);
                        contador += 1;
                    }
                }
                if(validado){
                    this.vista1.dispose();
                    VentanaUsuario v = new VentanaUsuario();
                    Transaccion t = new Transaccion();
                    Controlador2 ctrl = new Controlador2(v,t,numTarjeta);
                }else{
                    JOptionPane.showMessageDialog(null, "Se han excedido el numero de intentos", "ERROR", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        this.vista1.numTarjeta.setText(texto);
        this.vista1.numTarjeta.setEditable(false);
    }
    
}
