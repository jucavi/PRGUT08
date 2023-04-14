/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lib.utils.validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class Cadena {
    
    public static boolean validarPalabras(String[] palabras) {
        if (palabras == null) {
            return false;
        }
        
        for (String palabra : palabras) {
            if (palabra == null || palabra.isEmpty()) {
                return false;
            }
            if (!validarPalabra(palabra))
                return false;
        }
        
        return true;
    }
    
    public static boolean validarPalabra(String cadena) {
        if (cadena == null) {
            return false;
        }
        if (cadena.isBlank()) {
            return false;
        }
        
        return cadena.matches("(?i)[\\p{IsLatin}]+\\.?");
    }
    
    public static boolean validarTelefono(String telefono) {
        if (telefono == null) {
            return false;
        }
        return telefono.matches("^(\\+34|0034|34)?[6789]\\d{8}$");
    }
    
    /**
     * Retorna {@code true} si y solo si el identificador pasado como parámetro
     * está formado por {@code 8} dígitos que no representen el valor {@code 0}
     * y un caractér de control válido en mayúscula
     *
     * @param identificador Identificador del documento nacional de identidad
     * @return {@code true} si el identificador está formado por {@code 8}
     * dígitos que no representen el valor {@code 0} y un caractér de control
     * válido, en caso contrario {@code false}
     */
    public static final boolean validarDni(String identificador) {

        int numero;
        char letraEsperada;
        char letraIdentificador;
        final String regex;
        final Matcher matcher;
        final Pattern pattern;
        final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

        if (identificador == null) {
            return false;
        }

        regex = String.format("^[0-9]{8}[%s]$", LETRAS_DNI);
        pattern = Pattern.compile(regex);
//        pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(identificador);

        // Dni tiene que cumplir el formato
        if (!matcher.find()) {
            return false;
        }

        // Como el identificador cumple el formato los primeros 8 caracteres 
        // son dígitos
        numero = Integer.parseInt(identificador.substring(0, 8));

        // Los 8 primeros caracteres no pueden ser 0
        if (numero == 0) {
            return false;
        }

        letraEsperada = LETRAS_DNI.charAt(numero % 23);
        letraIdentificador = Character.toUpperCase(identificador.charAt(8));

        // El último caracter tiene que correpsonder con el caracter obtenida 
        // por el método mod23
        return (letraEsperada == letraIdentificador);
    }
}
