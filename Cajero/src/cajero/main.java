/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero;

import Controlador.Transaccion;
import Controlador.Controlador;
import Vista.Ventana;

/**
 *
 * @author camil
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ventana v = new Ventana();
        Transaccion t = new Transaccion();
        Controlador ctrl = new Controlador(v,t);
        
    }
    
}
