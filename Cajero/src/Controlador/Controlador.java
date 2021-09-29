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
    private VentanaUsuario vista2;
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
        this.vista1.numero5.addActionListener(this);
        this.vista1.numero5.addActionListener(this);
        this.vista1.numero3.addActionListener(this);
        this.vista1.numero2.addActionListener(this);
        this.vista1.numero1.addActionListener(this);
        this.vista2.diezMil.addActionListener(this);
        this.vista2.veinteMil.addActionListener(this);
        this.vista2.cincuentaMil.addActionListener(this);
        this.vista2.cienMil.addActionListener(this);
        this.vista2.doscientosMil.addActionListener(this);
        this.vista2.salir.addActionListener(this);
        this.vista2.consultar.addActionListener(this);
        this.vista2.retirar.addActionListener(this);
        this.vista2.consignar.addActionListener(this);
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
                    vista2 = new VentanaUsuario();
                    this.vista1.dispose();
                    vista2.setVisible(true);
                    vista2.setLocationRelativeTo(null);
                }else{
                    JOptionPane.showMessageDialog(null, "Se han excedido el numero de intentos", "ERROR", JOptionPane.WARNING_MESSAGE);
                }
            }
        }else if(accion.equals("Salir")){
            this.vista2.dispose();
            vista1 = new Ventana();
            vista1.setVisible(true);
            vista1.setLocationRelativeTo(null);
        }else if(accion.equals("Consultar")){
            this.vista2.labelRetirar.setVisible(false);
            this.vista2.labelConsignar.setVisible(false);
            this.vista2.veinteMil.setVisible(false);
            this.vista2.diezMil.setVisible(false);
            this.vista2.cincuentaMil.setVisible(false);
            this.vista2.cienMil.setVisible(false);
            this.vista2.doscientosMil.setVisible(false);
        }else if(accion.equals("Consignar")){
            this.vista2.labelRetirar.setVisible(false);
            this.vista2.labelConsignar.setVisible(true);
            this.vista2.labelConsignar.setText("¿Cuanto dinero desea consignar?");
            this.vista2.labelConsignar.setBounds(150, 50, 200, 50);
            this.vista2.veinteMil.setVisible(true);
            this.vista2.diezMil.setVisible(true);
            this.vista2.cincuentaMil.setVisible(true);
            this.vista2.cienMil.setVisible(true);
            this.vista2.doscientosMil.setVisible(true);
            this.vista2.veinteMil.setBounds(320, 200, 150, 50);
            this.vista2.diezMil.setBounds(50, 200, 150, 50);
            this.vista2.cincuentaMil.setBounds(50, 300, 150, 50);
            this.vista2.cienMil.setBounds(320, 300, 150, 50);
            this.vista2.doscientosMil.setBounds(180, 400, 150, 50);
            tipo = true;
        }else if(accion.equals("Retirar")){
            this.vista2.labelRetirar.setVisible(true);
            this.vista2.labelConsignar.setVisible(false);
            this.vista2.labelRetirar.setText("¿Cuanto dinero desea retirar?");
            this.vista2.labelRetirar.setBounds(150, 50, 200, 50);
            this.vista2.veinteMil.setVisible(true);
            this.vista2.diezMil.setVisible(true);
            this.vista2.cincuentaMil.setVisible(true);
            this.vista2.cienMil.setVisible(true);
            this.vista2.doscientosMil.setVisible(true);
            this.vista2.veinteMil.setBounds(320, 200, 150, 50);
            this.vista2.diezMil.setBounds(50, 200, 150, 50);
            this.vista2.cincuentaMil.setBounds(50, 300, 150, 50);
            this.vista2.cienMil.setBounds(320, 300, 150, 50);
            this.vista2.doscientosMil.setBounds(180, 400, 150, 50);
            tipo = false;
        }else if(accion.equals("diezMil")){
            this.vista2.labelRetirar.setVisible(false);
            this.vista2.labelConsignar.setVisible(false);
            this.vista2.veinteMil.setVisible(false);
            this.vista2.diezMil.setVisible(false);
            this.vista2.cincuentaMil.setVisible(false);
            this.vista2.cienMil.setVisible(false);
            this.vista2.doscientosMil.setVisible(false);
            cantidad = 10000;
            consignarRetirar(tipo,cantidad,numTarjeta);
        }else if(accion.equals("veinteMil")){
            this.vista2.labelRetirar.setVisible(false);
            this.vista2.labelConsignar.setVisible(false);
            this.vista2.veinteMil.setVisible(false);
            this.vista2.diezMil.setVisible(false);
            this.vista2.cincuentaMil.setVisible(false);
            this.vista2.cienMil.setVisible(false);
            this.vista2.doscientosMil.setVisible(false);
            cantidad = 20000;
            consignarRetirar(tipo,cantidad,numTarjeta);
        }else if(accion.equals("cincuentaMil")){
            this.vista2.labelRetirar.setVisible(false);
            this.vista2.labelConsignar.setVisible(false);
            this.vista2.veinteMil.setVisible(false);
            this.vista2.diezMil.setVisible(false);
            this.vista2.cincuentaMil.setVisible(false);
            this.vista2.cienMil.setVisible(false);
            this.vista2.doscientosMil.setVisible(false);
            cantidad = 50000;
            consignarRetirar(tipo,cantidad,numTarjeta);
        }else if(accion.equals("cienMil")){
            this.vista2.labelRetirar.setVisible(false);
            this.vista2.labelConsignar.setVisible(false);
            this.vista2.veinteMil.setVisible(false);
            this.vista2.diezMil.setVisible(false);
            this.vista2.cincuentaMil.setVisible(false);
            this.vista2.cienMil.setVisible(false);
            this.vista2.doscientosMil.setVisible(false);
            cantidad = 100000;
            consignarRetirar(tipo,cantidad,numTarjeta);
        }else if(accion.equals("doscientosMil")){
            this.vista2.labelRetirar.setVisible(false);
            this.vista2.labelConsignar.setVisible(false);
            this.vista2.veinteMil.setVisible(false);
            this.vista2.diezMil.setVisible(false);
            this.vista2.cincuentaMil.setVisible(false);
            this.vista2.cienMil.setVisible(false);
            this.vista2.doscientosMil.setVisible(false);
            cantidad = 200000;
            consignarRetirar(tipo,cantidad,numTarjeta);
        }
        this.vista1.numTarjeta.setText(texto);
        this.vista1.numTarjeta.setEditable(false);
    }
    
}
