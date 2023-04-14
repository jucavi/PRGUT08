/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.vistas.salida;

import app.controladores.ControladorAsociacionCultural;
import app.molelos.Archivo;
import app.molelos.Mapeable;
import app.vistas.formularios.FormularioTipoArchivo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class VistaTipoArchivo {
    
    public static void mostrar(ControladorAsociacionCultural cac, Comparator<Archivo> comparador) {
        
        List<Archivo> archivosTipo;

        String tipo = FormularioTipoArchivo.obtenerTipoArchivo(
                "Elija el tipo de archivo que desea listar");
        
        archivosTipo  = cac.obtenerCatalogo().stream()
                .filter(archivo -> archivo.getClass()
                        .getSimpleName()
                        .equalsIgnoreCase(tipo.toLowerCase()))
                .collect(Collectors.toList());
        
        if (comparador != null) {
            Collections.sort(archivosTipo, comparador);
        }

        System.out.println(FilasTabla.toStringRows(
                new ArrayList<Mapeable>(archivosTipo),
                25,
                true));
    }
}
