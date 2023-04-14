/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.vistas.formularios;

import app.molelos.Pelicula;
import app.molelos.Serie;
import static app.vistas.formularios.FormularioArchivo.obtenerAnyoPublicacion;
import static app.vistas.formularios.FormularioArchivo.obtenerCreador;
import static app.vistas.formularios.FormularioArchivo.obtenerGenero;
import static app.vistas.formularios.FormularioArchivo.obtenerTitulo;
import app.vistas.formularios.parcial.EntradasComunes;
import lib.utils.io.Teclado;
import lib.utils.string.OperacionesCadena;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class FormularioPelicula extends FormularioArchivo {
    
    public static Pelicula crear() {
        String saga;
        String reparto;
        boolean valido;
        String titulo = obtenerTitulo();
        String anyoPub = obtenerAnyoPublicacion();
        String creador= obtenerCreador();
        String genero = obtenerGenero();       

        do {
            reparto = Teclado.getInput("Reparto, actores separados por comas: ");
            reparto = OperacionesCadena.capitalizarLista(reparto);
            valido = Serie.validarReparto(reparto);

            if (!valido) {
                System.out.println("Introduzca una reparto con al menos un actor");
            }
        } while(!valido);

        saga = EntradasComunes.obtenerSaga();
        
        return new Pelicula(titulo, anyoPub, creador, genero, reparto, saga);
    }
}
