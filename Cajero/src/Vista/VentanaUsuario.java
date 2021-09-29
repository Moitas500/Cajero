/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author camil
 */
public class VentanaUsuario extends JFrame{ 
    public JPanel panel;
    public JPanel panelUser;
    public JLabel imagen;
    public JLabel labelConsignar;
    public JLabel labelRetirar;
    public JLabel labelNombreUsuario;
    public JLabel labelSaldo;
    public ImageIcon image;
    public Icon icono;
    public JButton consultar;
    public JButton retirar;
    public JButton consignar;
    public JButton salir;
    public JButton diezMil;
    public JButton veinteMil;
    public JButton cincuentaMil;
    public JButton cienMil;
    public JButton doscientosMil;
    
    //Funcion para cambiar un color de hexadecimal a entero
    private int hex( String color_hex )
    {
        return Integer.parseInt(color_hex,  16 );
    }
    
    public VentanaUsuario(){
        //Configuración de la ventana
        setSize(800,650);
        setLocation(500,200);
        setTitle("Ventana usuario");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Creacion del panel 
        panel = new JPanel();
        panelUser = new JPanel();    
        panelUser.setBounds(250, 50, 500, 500);
        panelUser.setBackground(new Color(hex("D4DFEE")));
        panelUser.setLayout(null);
        panel.setLayout(null);
        getContentPane().add(panel);
        panel.setBackground(new Color(hex("d4242c")));
        
        //Creacion de la imagen
        imagen = new JLabel();
        labelConsignar = new JLabel();
        labelRetirar = new JLabel();
        labelSaldo = new JLabel();
        labelNombreUsuario = new JLabel();
        imagen.setBounds(30, 10, 200, 200);
        image = new ImageIcon("Davivienda.jpg");
        icono = new ImageIcon(image.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
        imagen.setIcon(icono);
        
        //Creacion y colocacion de los botones
        consultar = new JButton("Consultar saldo");
        retirar = new JButton("Retirar saldo");
        consignar = new JButton("Consignar saldo");
        salir = new JButton("Salir");
        diezMil = new JButton("10.000");
        veinteMil = new JButton("20.000");
        cincuentaMil = new JButton("50.000");
        cienMil = new JButton("100.000");
        doscientosMil = new JButton("200.000");
        diezMil.setActionCommand("diezMil");
        diezMil.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        veinteMil.setActionCommand("diezMil");
        veinteMil.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        cincuentaMil.setActionCommand("veinteMil");
        cincuentaMil.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        cienMil.setActionCommand("cienMil");
        cienMil.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        doscientosMil.setActionCommand("doscientosMil");
        doscientosMil.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        salir.setBounds(50, 500, 150, 50);
        salir.setActionCommand("Salir");
        salir.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        consultar.setBounds(50, 200, 150, 50);
        consultar.setActionCommand("Consultar");
        consultar.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        retirar.setBounds(50, 300, 150, 50);
        retirar.setActionCommand("Retirar");
        retirar.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        consignar.setBounds(50, 400, 150, 50);
        consignar.setActionCommand("Consignar");
        consignar.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        
        //Se agregan los componentes al panel
        panel.add(panelUser);
        panel.add(imagen);
        panel.add(retirar);
        panel.add(consignar);
        panel.add(consultar);
        panel.add(salir);
        
        panelUser.add(diezMil);
        panelUser.add(veinteMil);
        panelUser.add(doscientosMil);
        panelUser.add(cienMil);
        panelUser.add(cincuentaMil);
        panelUser.add(labelConsignar);
        panelUser.add(labelRetirar);
        panelUser.add(labelNombreUsuario);
        panelUser.add(labelSaldo);
    }
}
