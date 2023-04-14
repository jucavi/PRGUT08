/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.vistas.formularios;

import app.molelos.Serie;
import lib.utils.io.Teclado;
import lib.utils.string.OperacionesCadena;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class FormularioSerie extends FormularioArchivo {
    
    public static Serie crear() {
        String numTemp;
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

        do {
            numTemp = Teclado.getInput("Número de temporadas [1-99]: ");
            valido = Serie.validarNumTemporadas(numTemp);

            if (!valido) {
                System.out.println("Introduzca un número de temporadas válido");
            }
        } while(!valido);
        
        return new Serie(titulo, anyoPub, creador, genero, reparto, numTemp);
    }
    
}
