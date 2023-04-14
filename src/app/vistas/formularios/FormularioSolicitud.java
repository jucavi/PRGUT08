/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.vistas.formularios;

import app.controladores.ControladorAsociacionCultural;
import app.molelos.Archivo;
import app.vistas.formularios.parcial.EntradasComunes;

/**
 * 
 * @author Juan Carlos Vilarrubia
 */
public class FormularioSolicitud {
    
    public static void crearSolicitud(ControladorAsociacionCultural cac) {
        String dni = EntradasComunes.obtenerDni();
        
        if (cac.existeSocio(dni)) {
            Archivo archivo = FormularioSeleccionarArchivo.obtener(
                    cac, 
                    "Cual es el archivo que desea solicitar? ");

            if (archivo != null) {        
                if (cac.anadirSolicitud(dni, archivo)) {
                    System.out.println("La solicitud se ha creado correctamente");
                } else {
                    System.out.println("Algo inesperado ha ocurrido, su solicitud no ha sido procesada.");
                }
            }
        } else {
            System.out.println("Socio con DNI " + dni + " no registrado.");
        }
    }
}
