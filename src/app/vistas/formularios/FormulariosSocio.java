/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.vistas.formularios;

import app.controladores.ControladorAsociacionCultural;
import app.molelos.Socio;
import app.vistas.formularios.parcial.EntradasComunes;
import lib.utils.io.Teclado;
import lib.utils.string.OperacionesCadena;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class FormulariosSocio {
    
    public static void darAlta(ControladorAsociacionCultural cac) {
        
        String dni;
        String nombre;
        String apellidos;
        String direccion;
        String telefono;
        boolean valido;
        boolean estadoAlta;

        System.out.println("Facilite los datos del socio:");
        
        dni = EntradasComunes.obtenerDni();
        
        if (cac.obtenerSocio(dni) != null) {
            System.out.println("Socio con identificador " 
                    + dni 
                    + " ya registrado.");
        } else {
        
            do {
                nombre = Teclado.getInput("Nombre: ");
                nombre = OperacionesCadena.capitalizarTexto(nombre);
                valido = Socio.validarNombre(nombre);

                if (!valido) {
                    System.out.println("Introduzca un nombre válido");
                }
            } while(!valido);

            do {
                apellidos = Teclado.getInput("Apellidos: ");
                apellidos = OperacionesCadena.capitalizarTexto(apellidos);
                valido = Socio.validarApellidos(apellidos);

                if (!valido) {
                    System.out.println("Introduzca unos apellidos válidos");
                }
            } while(!valido);
            
            do {
                direccion = Teclado.getInput("Dirección: ");
                direccion = OperacionesCadena.capitalizarTexto(direccion);
                valido = Socio.validarDireccion(direccion);

                if (!valido) {
                    System.out.println("Introduzca una direccion válida");
                }
            } while(!valido);
            
            do {
                telefono = Teclado.getInput("Teléfono: ");
                valido = Socio.validarTelefono(telefono);

                if (!valido) {
                    System.out.println("Introduzca un telefono válido");
                }
            } while(!valido);
            
            estadoAlta = cac.anadirSocio(new Socio(nombre, apellidos, dni, direccion, telefono));
            
            if (estadoAlta) {
                System.out.println("Socio con identificador " 
                        + dni + 
                        " dado de alta correctamente.");
            } else {
                System.out.println("Lo sentimos, no se ha podido dar de alta al socio.");
            }
        }
    }
    
    public static void darBaja(ControladorAsociacionCultural cac) {
        
        String dni;
        boolean estadoBaja;
            
        System.out.println("Datos necesarios para dar de baja al socio:");
        dni = EntradasComunes.obtenerDni();
        
        estadoBaja = cac.eliminarSocio(dni);
        
        if (estadoBaja) {
           System.out.println("Socio con identificador " 
                        + dni + 
                        " ha sido dado de baja correctamente.");
        } else {
            System.out.println("El socio no está dado de alta.");
        } 
        
    }
}
