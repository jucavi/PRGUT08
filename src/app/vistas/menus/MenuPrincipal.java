/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.vistas.menus;

import app.controladores.ControladorAsociacionCultural;
import lib.utils.io.Teclado;
import lib.utils.menu.MenuNumerico;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class MenuPrincipal {
    
    public static void mostrar(ControladorAsociacionCultural cac) {
        String opcion;
        final String tituloMenu = "Menú Asociación Cultural";     
        final MenuNumerico menu = new MenuNumerico(tituloMenu, 
                new String[] {"Gestión", "Solicitudes", "Listado"}, 
                true);

        do {
            // Borra la pantala
            menu.mostrar();
            
            opcion = Teclado.getInput("Opción a ejecutar: ");
            
            switch (opcion) {
                case "1" -> MenuGestiones.mostrar(cac);
                case "2" -> MenuSolicides.mostrar(cac);
                case "3" -> MenuListados.mostrar(cac);
            }

        } while(!opcion.equals("0"));
    }
    
}
