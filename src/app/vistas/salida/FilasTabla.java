/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.vistas.salida;

import app.molelos.Mapeable;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class FilasTabla {
    
    public static final String EOF = "\n";

    public static String toStringRows(List<Mapeable> listaObjs, 
            int ancho, 
            boolean mostrarCabecera) {
        Set<String> cabecera;
        String[] columnas;
        String formato;
        String componente = "%" + ancho + "s";
        StringBuilder resultado = new StringBuilder();
        
        if (listaObjs == null || listaObjs.isEmpty()) {
            System.out.println("Nada que mostrar");
            
        } else {
            cabecera = listaObjs.get(0).toHashMap().keySet();
            columnas = new String[cabecera.size()];
            Arrays.fill(columnas, componente);

            formato = String.join(" | ", columnas) + EOF;

            if (mostrarCabecera) {
                resultado.append(String.format(formato, cabecera.toArray()));
            }

            for (Mapeable obj : listaObjs) {
                resultado.append(String.format(formato, 
                        obj.toHashMap()
                                .values()
                                .toArray()));
            }
        }
        
        return resultado.toString();
    }
    
}
