/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.vistas.formularios;

import lib.utils.io.Teclado;
import lib.utils.menu.MenuNumerico;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class FormularioTipoArchivo {
    
    public static String obtenerTipoArchivo(String tituloMenu) {
        
        int opcion;
        boolean repite;
        String[] opcionesTipo = new String[] {"Libro", "Pelicula", "Serie"};
        MenuNumerico menu = new MenuNumerico(tituloMenu, opcionesTipo, false);
        
        do {
            menu.mostrar();
            
            opcion = Teclado.getInteger("Que tipo de archivo desea? ");
            
            repite = opcion < 1 || opcion > 3;
            if (repite) {
                System.out.println("Por favor elija un tipo válido");
            }
        
        } while(repite);
        
        return opcionesTipo[opcion - 1];
    }
    
}
