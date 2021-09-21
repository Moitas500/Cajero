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
public class VentanaUsuario extends JFrame implements ActionListener{ 
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
        
        //Creacion del panel 
        JPanel panel = new JPanel();
        JPanel panelUser = new JPanel();    
        panelUser.setBounds(250, 50, 500, 500);
        panelUser.setBackground(new Color(hex("D4DFEE")));
        panel.setLayout(null);
        getContentPane().add(panel);
        panel.setBackground(new Color(hex("d4242c")));
        
        //Creacion de la imagen
        JLabel imagen = new JLabel();
        imagen.setBounds(30, 10, 200, 200);
        ImageIcon image = new ImageIcon("Davivienda.jpg");
        Icon icono = new ImageIcon(image.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
        imagen.setIcon(icono);
        
        //Creacion y colocacion de los botones
        JButton consultar = new JButton("Consultar saldo");
        JButton retirar = new JButton("Retirar saldo");
        JButton consignar = new JButton("Consignar saldo");
        JButton salir = new JButton("Salir");
        salir.setBounds(50, 500, 150, 50);
        salir.setActionCommand("Salir");
        salir.addActionListener(this);
        salir.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        consultar.setBounds(50, 200, 150, 50);
        consultar.setActionCommand("Consultar");
        consultar.addActionListener(this);
        consultar.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        retirar.setBounds(50, 300, 150, 50);
        retirar.setActionCommand("Retirar");
        retirar.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        consignar.setBounds(50, 400, 150, 50);
        consignar.setActionCommand("Consignar");
        consignar.addActionListener(this);
        consignar.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        
        //Se agregan los componentes al panel
        panel.add(panelUser);
        panel.add(imagen);
        panel.add(retirar);
        panel.add(consignar);
        panel.add(consultar);
        panel.add(salir);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String accion = ae.getActionCommand();
        
        if(accion.equals("Salir")){
            this.dispose();
            Ventana v = new Ventana();
            v.setVisible(true);
        }
    }
}
