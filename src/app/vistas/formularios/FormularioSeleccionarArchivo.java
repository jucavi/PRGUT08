/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.vistas.formularios;

import app.controladores.ControladorAsociacionCultural;
import app.molelos.Archivo;
import app.vistas.salida.FilasTabla;
import java.util.ArrayList;
import java.util.List;
import lib.utils.io.Teclado;
import lib.utils.menu.MenuNumerico;
import lib.utils.string.OperacionesCadena;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class FormularioSeleccionarArchivo {
    
    public static Archivo obtener(ControladorAsociacionCultural cac, String mensaje) {
        
        int opcion;
        String titulo;
        boolean valido;
        List<Archivo> coincidencias;
        final MenuNumerico listaArchivos;
        
        System.out.println("Introduzca el título o parte título del archivo a dar de baja:");
        
        do {
            titulo = Teclado.getInput("Título: ");
            titulo = OperacionesCadena.capitalizarTexto(titulo);
            valido = Archivo.validarTitulo(titulo);

            if (!valido) {
                System.out.println("Introduzca un título válido");
            }
        } while(!valido);
        
        coincidencias = cac.encontrarArchivosTitulo(titulo);
        
        if (coincidencias == null) {
            System.out.println("No se encuentra ninguna coincidencia en el catálogo");
            return null;
        } else {
            int numArchivos = coincidencias.size();
            String filas = FilasTabla.toStringRows(
                    new ArrayList<>(coincidencias), 
                    25, 
                    false);
            
            listaArchivos = new MenuNumerico(
                    "Encontrados " + coincidencias.size() +" archivos que coinciden con su busqueda.",
                    filas.split(FilasTabla.EOF),
                    false);
            
            listaArchivos.mostrar();

            do {
                opcion = Teclado.getIntegerBetween(mensaje, 1, numArchivos);
            } while (opcion == Integer.MIN_VALUE);
            
            return coincidencias.get(opcion - 1);
        }
    }
    
}
