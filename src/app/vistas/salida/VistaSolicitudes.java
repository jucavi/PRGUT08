/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.vistas.salida;

import app.controladores.ControladorAsociacionCultural;
import app.molelos.SolicitudArchivo;
import app.vistas.formularios.parcial.EntradasComunes;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class VistaSolicitudes {
    
    public static void mostrar(
            ControladorAsociacionCultural cac, 
            Comparator<SolicitudArchivo> comparador) {
        
        String dni = EntradasComunes.obtenerDni();
        
        if (cac.existeSocio(dni)) {
            ArrayList<SolicitudArchivo> solicitudes = cac.obtenerSolicitudes(dni);

            System.out.println("Solicitudes del sociocon DNI " + dni + ":");

            //socio registrado
            if ( solicitudes != null) {        
                if (comparador != null) {
                    Collections.sort(solicitudes, comparador);
                }
                
                solicitudes.forEach(solicitud -> {
                    System.out.println(
                            solicitud.getFechaSolicitud()
                                    .format(DateTimeFormatter.ofPattern("yyyy/MM/dd, hh:mm:ss")) 
                            + " " 
                            + solicitud.infoArchivoSolicitado());
                });
            } else {
                System.out.println("No hay solicitudes para ese socio");
            }
        } else {
            System.out.println("El socio no está registrado");
        }
    }
}
