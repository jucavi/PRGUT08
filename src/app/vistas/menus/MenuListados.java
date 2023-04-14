/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.vistas.menus;

import app.controladores.ControladorAsociacionCultural;
import app.vistas.salida.ComparadorArchivosAnyoTitulo;
import app.vistas.salida.ComparadorSociosApellidosNombre;
import app.vistas.salida.VistaArchivos;
import app.vistas.salida.VistaSocios;
import app.vistas.salida.VistaSolicitudes;
import app.vistas.salida.VistaTipoArchivo;
import lib.utils.io.Teclado;
import lib.utils.menu.MenuNumerico;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class MenuListados {
    
    public static void mostrar(ControladorAsociacionCultural cac) {
                String opcion;
        String[] opcionesMenu = new String[] {
            "Listado de socios", 
            "Listado de archivos multimedia", 
            "Listado de películas, series y libros por separado",
            "Listado de archivos solicitados por un socio"
        };
        String tituloMenu = "Menú Asociación Cultural -> Listado";
        
        MenuNumerico menu = new MenuNumerico(tituloMenu, opcionesMenu, true);
        
        do {
            menu.mostrar();
            
            opcion = Teclado.getInput("Opcion a ejecutar: ");
            
            switch (opcion) {
                case "1" -> VistaSocios.mostrar(cac, new ComparadorSociosApellidosNombre());
                case "2" -> VistaArchivos.mostrar(cac, new ComparadorArchivosAnyoTitulo());
                case "3" -> VistaTipoArchivo.mostrar(cac, new ComparadorArchivosAnyoTitulo());
                case "4" -> VistaSolicitudes.mostrar(cac, null);
            }

        } while(!opcion.equals("0"));
 
    }
}
