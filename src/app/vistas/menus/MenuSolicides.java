/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.vistas.menus;

import app.controladores.ControladorAsociacionCultural;
import app.vistas.formularios.FormularioSolicitud;
import lib.utils.io.Teclado;
import lib.utils.menu.MenuNumerico;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class MenuSolicides {
    
    public static void mostrar(ControladorAsociacionCultural cac) {
        String opcion;
        String[] opcionesMenu = new String[] {
            "Nueva Solicitud"
        };
        String tituloMenu = "Menú Asociación Cultural -> Solicitudes";
        
        MenuNumerico menu = new MenuNumerico(tituloMenu, opcionesMenu, true);
        
        do {
            menu.mostrar();
            
            opcion = Teclado.getInput("Opcion a ejecutar: ");
            
            switch (opcion) {
                case "1" -> FormularioSolicitud.crearSolicitud(cac);
            }

        } while(!opcion.equals("0"));
 
    }
}
