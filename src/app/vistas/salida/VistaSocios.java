/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.vistas.salida;

import app.controladores.ControladorAsociacionCultural;
import app.molelos.Socio;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class VistaSocios {
    
    public static void mostrar(ControladorAsociacionCultural cac, Comparator<Socio> comparador) {
        
        if (comparador != null) {
            Collections.sort(cac.obtenerSocios(), comparador);
        }
        
        System.out.println(FilasTabla.toStringRows(
                new ArrayList<>(cac.obtenerSocios()),
                25,
                true));
    }
}
