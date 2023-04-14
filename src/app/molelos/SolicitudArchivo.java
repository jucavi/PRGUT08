/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.molelos;

import java.time.LocalDateTime;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class SolicitudArchivo {
    
    private final LocalDateTime fechaSolicitud = LocalDateTime.now();
    private final Archivo archivo;

    public SolicitudArchivo(Archivo archivo) {
        this.archivo = archivo;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public String infoArchivoSolicitado() {
        String resultado;
        
        if (archivo == null) {
            return "Archivo null, registro mal formado";
        }
        
        resultado = String.join(", ", archivo.toHashMap().values());
        
        return resultado;
    }
    
}
