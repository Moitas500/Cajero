/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Tarjeta;
import Vista.Ventana;
import Vista.VentanaUsuario;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author camil
 */
public class Controlador2 implements ActionListener{
    private VentanaUsuario vista2;
    private Transaccion modelo;
    private int numTarjeta;
    private String tipo;
    private float cantidad;
    
    private void consignarRetirar(String tipo, float dinero, int tarjeta){
        System.out.println(dinero + " este es");
        if(tipo.equals("Consignar")){
            modelo.consignarDinero(dinero, tarjeta);
        }else{
            modelo.retirarDinero(dinero, tarjeta);
        }
    }
    
    public Controlador2(VentanaUsuario vista, Transaccion modelo, int numTarjeta){
        this.vista2 = vista;
        this.modelo = modelo;
        this.numTarjeta = numTarjeta;
        this.vista2.labelNombreUsuario.setText("Señor usuario, su saldo actual es de: ");
        this.vista2.labelNombreUsuario.setBounds(50, 50, 220, 20);
        this.vista2.labelSaldo.setText(Float.toString(modelo.consultarSaldo(numTarjeta)));
        this.vista2.labelNombreUsuario.setBounds(50, 100, 220, 20);
        this.vista2.labelSaldo.setFont(new Font("serif",Font.BOLD,32));
        this.vista2.labelSaldo.setBounds(200,200,220,50);
        this.vista2.diezMil.addActionListener(this);
        this.vista2.veinteMil.addActionListener(this);
        this.vista2.cincuentaMil.addActionListener(this);
        this.vista2.cienMil.addActionListener(this);
        this.vista2.doscientosMil.addActionListener(this);
        this.vista2.salir.addActionListener(this);
        this.vista2.consultar.addActionListener(this);
        this.vista2.retirar.addActionListener(this);
        this.vista2.consignar.addActionListener(this);
        this.vista2.setVisible(true);
        this.vista2.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String accion = ae.getActionCommand();
        cantidad = 0;
        if(accion.equals("Salir")){
            this.vista2.dispose();
            Ventana v = new Ventana();
            Transaccion t = new Transaccion();
            Controlador ctrl = new Controlador(v,t);
        }else if(accion.equals("Consultar")){
            this.vista2.labelSaldo.setText(Float.toString(modelo.consultarSaldo(numTarjeta)));
            this.vista2.labelNombreUsuario.setVisible(true);
            this.vista2.labelSaldo.setVisible(true);
            this.vista2.labelRetirar.setVisible(false);
            this.vista2.labelConsignar.setVisible(false);
            this.vista2.veinteMil.setVisible(false);
            this.vista2.diezMil.setVisible(false);
            this.vista2.cincuentaMil.setVisible(false);
            this.vista2.cienMil.setVisible(false);
            this.vista2.doscientosMil.setVisible(false);    
        }else if(accion.equals("Consignar")){
            this.vista2.labelNombreUsuario.setVisible(false);
            this.vista2.labelSaldo.setVisible(false);
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
            tipo = "Consignar";
        }else if(accion.equals("Retirar")){
            this.vista2.labelNombreUsuario.setVisible(false);
            this.vista2.labelSaldo.setVisible(false);
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
            tipo = "Retirar";
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
    }
}
