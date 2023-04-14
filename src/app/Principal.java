/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import app.controladores.ControladorAsociacionCultural;
import app.vistas.menus.MenuPrincipal;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class Principal {
    
    public static void main(String[] args) {
        ControladorAsociacionCultural cac = new ControladorAsociacionCultural();
        
        MenuPrincipal.mostrar(cac);
    }
}
