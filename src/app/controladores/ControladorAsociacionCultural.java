/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controladores;

import app.molelos.Archivo;
import app.molelos.AsociacionCultural;
import app.molelos.Socio;
import app.molelos.SolicitudArchivo;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class ControladorAsociacionCultural {
    
    private final AsociacionCultural asociacion;

    public ControladorAsociacionCultural() {
        this.asociacion = new AsociacionCultural();
    }
    
    public ArrayList<Socio> obtenerSocios() {
        return new ArrayList<>(asociacion.getSocios());
    }
    
    public Socio obtenerSocio(String dni) {
        if (!Socio.validarDni(dni)) {
            return null;
        }
        
        for (Socio socio : asociacion.getSocios()) {
            if (socio.getDni().equals(dni)) {
                return socio;
            }
        }
        
        return null;
                
    }
    
    public boolean existeSocio(String dni) {
        for (Socio socio : asociacion.getSocios()) {
            if (socio.getDni().toLowerCase().equals(dni.toLowerCase())) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean anadirSocio(Socio socio) {
        if (socio == null) {
            return false;
        }
        
        return asociacion.getSocios().add(socio);
    }
    
    public boolean eliminarSocio(String dni) {
        Socio socio;
        
        if (!Socio.validarDni(dni)) {
            return false;
        }
        
        socio = obtenerSocio(dni);
        
        if (socio == null) {
            return false;
        }
        
        return asociacion.getSocios().remove(socio);
    }
    
    public ArrayList<Archivo> obtenerCatalogo() {
        return new ArrayList<>(asociacion.getCatalogo());
    }
    
    public boolean anadirArchivo(Archivo archivo) {
        return asociacion.getCatalogo().add(archivo);
    }
    
    public boolean eliminarArchivo(Archivo archivo) {
        return asociacion.getCatalogo().remove(archivo);
    }
    
    public ArrayList<Archivo> encontrarArchivosTitulo(String titulo) {
        ArrayList<Archivo> archivosEncontrados = new ArrayList<>();
        
        if (titulo == null || titulo.isBlank()) {
            return null;
        }
        
        for (Archivo archivo : asociacion.getCatalogo()) {
            if (archivo.getTitulo()
                    .toLowerCase()
                    .contains(titulo.toLowerCase())) {
                archivosEncontrados.add(archivo);
            }
        }
        
        if (archivosEncontrados.isEmpty()) {
            return null;
        }
        
        return archivosEncontrados;
    }
    
    public boolean anadirSolicitud(String dni, Archivo archivo) {
        ArrayList<SolicitudArchivo> solicitudesSocio;
        HashMap<String, ArrayList<SolicitudArchivo>> solicitudes = asociacion.getSolicitudes();
        
        if (dni == null || archivo == null) {
            return false;
        }
        
        if (!existeSocio(dni)) {
            return false;
        }
        
        if (solicitudes.get(dni) == null) {
            solicitudes.put(dni, new ArrayList<>());
        }
        
        solicitudesSocio = solicitudes.get(dni);
        
        return solicitudesSocio.add(new SolicitudArchivo(archivo));
    }
    
    public ArrayList<SolicitudArchivo> obtenerSolicitudes(String dni) {
        Socio socio = obtenerSocio(dni);
        ArrayList<SolicitudArchivo> solicitudes;
        
        if (socio == null) {
            return  null;
        }
        
        solicitudes = asociacion.getSolicitudes().get(dni);
        
        if (solicitudes == null || solicitudes.isEmpty()) {
            return null;
        }
        
        return solicitudes;
    }
}
