/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero;

import Controlador.Transaccion;
import Modelo.Cuenta;
import Modelo.Tarjeta;
import Modelo.Titular;
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
        v.setVisible(true);
         Transaccion t= new Transaccion();
         Cuenta c= t.getDatosCuenta(784596);
         Tarjeta tar= t.getDatosTarjeta(784596);
         c.setSaldo(4000);
         c.ActualizarSaldo();
    }
    
}
