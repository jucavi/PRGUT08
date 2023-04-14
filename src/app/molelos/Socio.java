/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.molelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Objects;
import lib.utils.validaciones.Cadena;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class Socio implements Mapeable{
    
    private final String nombre;
    private final String apellidos;
    private final String dni;
    private String direccion;
    private String telefono;
    private final LocalDateTime fechaAlta;

    public Socio(String nombre, String apellidos, String dni, String direccion, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaAlta = LocalDateTime.now();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Socio other = (Socio) obj;
        return Objects.equals(this.dni, other.dni);
    }
    
    // Validaciones, métodos de clase
    public static boolean validarNombre(String nombre) {
        return Cadena.validarPalabras(nombre.split("[\\s-]+"));
    }
    
    public static boolean validarApellidos(String apellidos) {
        return Cadena.validarPalabras(apellidos.split("[\\s-]+"));
    }
    
    public static boolean validarDni(String identificador) {
        return Cadena.validarDni(identificador);
    }
    
    public static boolean validarDireccion(String direccion) {
        return direccion.matches("(?i)[\\p{IsLatin}\\d\\s\\.,]+");
    }
    
    public static boolean validarTelefono(String telefono) {
        return Cadena.validarTelefono(telefono);
    }
    
    @Override
    public LinkedHashMap<String, String> toHashMap() {
        LinkedHashMap<String, String> resultado = new LinkedHashMap<>();

        resultado.put("Nombre", this.getNombre());
        resultado.put("Apellidos", this.getApellidos());
        resultado.put("Dni", this.getDni());
        resultado.put("Teléfono", this.getTelefono());
        resultado.put("Fecha Alta", this.getFechaAlta().format(
                DateTimeFormatter.ofPattern("yyyy/MM/dd")));

        return resultado;
    }
}
