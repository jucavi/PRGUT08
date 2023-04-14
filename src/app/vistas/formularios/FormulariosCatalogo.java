/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.vistas.formularios;

import app.controladores.ControladorAsociacionCultural;
import app.molelos.Archivo;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class FormulariosCatalogo {
    
    public static void darAltaArchivo(ControladorAsociacionCultural cac) {

        boolean estadoAlta = false;
        
        String tipoArchivo = FormularioTipoArchivo.obtenerTipoArchivo(
                "Menú Asociación Cultural -> Gestion -> Archivo -> Alta");
        
        switch (tipoArchivo) {
            case "Libro" -> {
                estadoAlta = 
                        cac.anadirArchivo(FormularioLibro.crear());
            }
            
            case "Serie" -> {
                estadoAlta = 
                        cac.anadirArchivo(FormularioSerie.crear());
            }
            
            case "Pelicula" -> {
                estadoAlta = 
                        cac.anadirArchivo(FormularioPelicula.crear());
            }
        }
        
        if (estadoAlta) {
            System.out.println("El archivo multimedia ha sido dado de alta correctamente");
        } else {
            System.out.println("Lo sentimos es posible que el archivo ya esté dado de alta.");
        }
        
    }
    
    public static void darBajaArchivo(ControladorAsociacionCultural cac) {
        
        Archivo archivo = FormularioSeleccionarArchivo.obtener(
                cac, 
                "Cual es el archivo que desea eliminar? ");
        
        if (archivo != null) {
            
            if (cac.eliminarArchivo(archivo)) {
                System.out.println("El archivo multimedia ha sido dado de baja correctamente");
            } else {
                System.out.println("Algo inesperado ha ocurrido compruebe que el archivo haya sido dado de baja.");
            }
        }
    }
}
