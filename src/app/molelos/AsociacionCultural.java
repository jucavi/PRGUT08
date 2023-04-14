/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.molelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class AsociacionCultural {
    
    private final HashSet<Socio> socios= new HashSet<>();
    private final HashSet<Archivo> catalogo = new HashSet<>();
    private final HashMap<String, ArrayList<SolicitudArchivo>> solicitudes = new HashMap<>();

    public AsociacionCultural() {}

    public HashSet<Socio> getSocios() {
        return socios;
    }

    public HashSet<Archivo> getCatalogo() {
        return catalogo;
    }

    public HashMap<String, ArrayList<SolicitudArchivo>> getSolicitudes() {
        return solicitudes;
    }
    
    
}
