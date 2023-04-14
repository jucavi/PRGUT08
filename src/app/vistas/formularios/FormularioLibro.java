/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.vistas.formularios;

import app.molelos.Libro;
import app.vistas.formularios.parcial.EntradasComunes;
import lib.utils.io.Teclado;
import lib.utils.string.OperacionesCadena;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class FormularioLibro extends FormularioArchivo {
    
    public static Libro crear() {
        String saga;
        String editorial;
        boolean valido;
        String titulo = obtenerTitulo();
        String anyoPub = obtenerAnyoPublicacion();
        String creador= obtenerCreador();
        String genero = obtenerGenero();
        
                
        do {
            editorial = Teclado.getInput("Editorial: ");
            editorial = OperacionesCadena.capitalizarTexto(editorial);
            valido = Libro.validarCreador(editorial);

            if (!valido) {
                System.out.println("Introduzca una editorial válida");
            }
        } while(!valido);
                
        saga = EntradasComunes.obtenerSaga();
        
        return new Libro(titulo, anyoPub, creador, genero, editorial, saga);
    }
}
