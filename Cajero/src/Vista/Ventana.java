/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author camil
 */
public class Ventana extends JFrame implements ActionListener{
    public JTextField numTarjeta;
    
    //Funcion para cambiar un color de hexadecimal a entero
    private int hex( String color_hex )
    {
        return Integer.parseInt(color_hex,  16 );
    }
    
    public Ventana(){
        //Configuración de la ventana 
        setSize(500,720);
        setLocation(500,200);
        setTitle("Ventana cajero");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Creacion del panel 
        JPanel panel = new JPanel();
        panel.setLayout(null);
        getContentPane().add(panel);
        panel.setBackground(new Color(hex("d4242c")));
        
        //Creacion de labels
        JLabel nTarjeta = new JLabel("Inserte el numero de la tarjeta");
        nTarjeta.setForeground(Color.WHITE);
        nTarjeta.setFont(new Font("Serif",Font.PLAIN,15));
        nTarjeta.setBounds(50, 435, 200, 15);
        
        //Creacion de JTextFields
        numTarjeta = new JTextField();
        numTarjeta.setBounds(250, 435, 200, 20);
        numTarjeta.setEditable(false);
        
        //Creacion de la imagen
        JLabel imagen = new JLabel(new ImageIcon("Davivienda.jpg"));
        imagen.setBounds(50, 10, 400, 400);
        
        //Creacion y colocacion de los botones
        JButton numero1 = new JButton("1");
        JButton numero2 = new JButton("2");
        JButton numero3 = new JButton("3");
        JButton numero4 = new JButton("4");
        JButton numero5 = new JButton("5");
        JButton numero6 = new JButton("6");
        JButton numero7 = new JButton("7");
        JButton numero8 = new JButton("8");
        JButton numero9 = new JButton("9");
        JButton numero0 = new JButton("0");
        JButton borrar = new JButton("<-");
        JButton ingTarjeta = new JButton("Ingresar tarjeta");
        numero1.setBounds(100, 480, 50, 20);
        numero1.addActionListener(this);
        numero1.setActionCommand("1");
        numero1.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        numero2.setBounds(230, 480, 50, 20);
        numero2.addActionListener(this);
        numero2.setActionCommand("2");
        numero2.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        numero3.setBounds(350, 480, 50, 20);
        numero3.addActionListener(this);
        numero3.setActionCommand("3");
        numero3.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        numero4.setBounds(100, 530, 50, 20);
        numero4.addActionListener(this);
        numero4.setActionCommand("4");
        numero4.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        numero5.setBounds(230, 530, 50, 20);
        numero5.addActionListener(this);
        numero5.setActionCommand("5");
        numero5.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        numero6.setBounds(350, 530, 50, 20);
        numero6.addActionListener(this);
        numero6.setActionCommand("6");
        numero6.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        numero7.setBounds(100, 580, 50, 20);
        numero7.addActionListener(this);
        numero7.setActionCommand("7");
        numero7.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        numero8.setBounds(230, 580, 50, 20);
        numero8.addActionListener(this);
        numero8.setActionCommand("8");
        numero8.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        numero9.setBounds(350, 580, 50, 20); 
        numero9.addActionListener(this);
        numero9.setActionCommand("9");
        numero9.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        numero0.setBounds(100, 630, 50, 20);
        numero0.addActionListener(this);
        numero0.setActionCommand("0");
        numero0.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        borrar.setBounds(350, 630, 50, 20);
        borrar.setActionCommand("<-");
        borrar.addActionListener(this);
        borrar.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        ingTarjeta.setBounds(180, 630, 150, 20);
        ingTarjeta.setActionCommand("ingTarjeta");
        ingTarjeta.addActionListener(this);
        ingTarjeta.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        
        //Se agregan los componentes al panel
        panel.add(numTarjeta);
        panel.add(nTarjeta);
        panel.add(imagen);
        panel.add(numero1);
        panel.add(numero2);
        panel.add(numero3);
        panel.add(numero4);
        panel.add(numero5);
        panel.add(numero6);
        panel.add(numero7);
        panel.add(numero8);
        panel.add(numero9);
        panel.add(ingTarjeta);
        panel.add(numero0);
        panel.add(borrar);
    }

    //Funcion para determinar la accion de los botones
    @Override
    public void actionPerformed(ActionEvent ae) {
        String accion = ae.getActionCommand();
        this.numTarjeta.setEditable(true);
        String texto = numTarjeta.getText();
        
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
            VentanaUsuario vUser = new VentanaUsuario();
            vUser.setVisible(true);
            this.dispose();
        }
        numTarjeta.setText(texto);
        numTarjeta.setEditable(false);
    }
}
