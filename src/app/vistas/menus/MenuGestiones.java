/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.vistas.menus;

import app.controladores.ControladorAsociacionCultural;
import app.vistas.formularios.FormulariosCatalogo;
import app.vistas.formularios.FormulariosSocio;
import lib.utils.io.Teclado;
import lib.utils.menu.MenuNumerico;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class MenuGestiones {
    
    public static void mostrar(ControladorAsociacionCultural cac) {
        String opcion;
        final String tituloMenu = "Menú Asociación Cultural -> Gestion";
        
        MenuNumerico menu = new MenuNumerico(tituloMenu, 
                new String[] {"Alta Socio", "Baja Socio", "Alta Archivo", "Baja Archivo"}, 
                true);
        
        do {
            // Borra la pantala
            menu.mostrar();
            
            opcion = Teclado.getInput("Opcion a ejecutar: ");
            
            switch (opcion) {
                case "1" -> FormulariosSocio.darAlta(cac);
                case "2" -> FormulariosSocio.darBaja(cac);
                case "3" -> FormulariosCatalogo.darAltaArchivo(cac);
                case "4" -> FormulariosCatalogo.darBajaArchivo(cac);
            }

        } while(!opcion.equals("0"));
        
    }
}
