/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.vistas.formularios.parcial;

import app.controladores.ControladorAsociacionCultural;
import app.molelos.Socio;
import lib.utils.io.Teclado;
import lib.utils.string.OperacionesCadena;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class EntradasComunes {
    
    public static String obtenerDni() {
        String dni;
        boolean valido;
        
        do {
            dni = Teclado.getInput("Introduzca el DNI: ").toUpperCase();
            valido = Socio.validarDni(dni);
            
            if (!valido) {
                System.out.println("El idntificador introducido no es válido");
            }
        } while(!valido);
        
        return dni;
    }
    
    public static String obtenerSaga() {
        String saga;
        saga = Teclado.getInput("Saga (Campo no requerido): ");
        if (saga.isEmpty()) {
            saga = "N/A";
        } else {
            saga = OperacionesCadena.capitalizarTexto(saga);
        }
        return saga;
    }
    
    public static String obtenerDniSocioRgeistrado(ControladorAsociacionCultural cac) {
        String dni;
        boolean estaRegistrado;
        
        System.out.println("Identifique el usuario");
        do {
            dni = EntradasComunes.obtenerDni();
            
            estaRegistrado = cac.existeSocio(dni);
            
            if (!estaRegistrado) {
                System.out.println("Por favor introduzca un identificador de un socio registrado.");
            }
        } while(!estaRegistrado);
        
        return dni;
    }
    
}
