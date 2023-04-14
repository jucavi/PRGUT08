/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.vistas.formularios;

import app.molelos.Archivo;
import lib.utils.io.Teclado;
import lib.utils.string.OperacionesCadena;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
class FormularioArchivo {
    
    protected static String obtenerTitulo() {
        String titulo;
        boolean valido;
        
        do {
            titulo = Teclado.getInput("Título: ");
            titulo = OperacionesCadena.capitalizarTexto(titulo);
            valido = Archivo.validarTitulo(titulo);

            if (!valido) {
                System.out.println("Introduzca un título válido");
            }
        } while(!valido);
        
        return titulo;
    }
    
    protected static String obtenerAnyoPublicacion() {
        String anyoPub;
        boolean valido;
        
        do {
            anyoPub = Teclado.getInput("Año de Publicación: ");
            valido = Archivo.validarAnyoPub(anyoPub);

            if (!valido) {
                System.out.println("Introduzca un año de publicación válido");
            }
        } while(!valido);
        
        return anyoPub;
    }
    
    protected static String obtenerCreador() {
        String creador;
        boolean valido;
        
        do {
            creador = Teclado.getInput("Creador: ");
            creador = OperacionesCadena.capitalizarTexto(creador);
            valido = Archivo.validarCreador(creador);

            if (!valido) {
                System.out.println("Introduzca un autor válido");
            }
        } while(!valido);
        
        return creador;
    }
    
    protected static String obtenerGenero() {
        String genero;
        boolean valido;
        
        do {
            genero = Teclado.getInput("Género: ");
            genero = OperacionesCadena.capitalizarTexto(genero);
            valido = Archivo.validarCreador(genero);

            if (!valido) {
                System.out.println("Introduzca un género válido");
            }
        } while(!valido);
        
        return genero;
    }
    
}
