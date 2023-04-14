/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.molelos;

import java.util.LinkedHashMap;
import lib.utils.validaciones.Cadena;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class Serie extends Archivo {

    private String reparto;
    private String numTemporadas;

    public Serie(String titulo, String anyoPub, String creador, String genero,
            String reparto, String numTemporadas) {
        super(titulo, anyoPub, creador, genero);
        this.reparto = reparto;
        this.numTemporadas = numTemporadas;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public String getNumTemporadas() {
        return numTemporadas;
    }

    public void setNumTemporadas(String numTemporadas) {
        this.numTemporadas = numTemporadas;
    }

    @Override
    public LinkedHashMap<String, String> toHashMap() {
        LinkedHashMap<String, String> resultado = new LinkedHashMap<>(super.toHashMap());
        
        resultado.put("reparto", this.getReparto());
        resultado.put("numero de temporadas", this.getNumTemporadas());

        return resultado;
    }
    
    public static boolean validarReparto(String reparto) {
        String[] actores;
        
        if (reparto == null) {
            return false;
        }
        
        actores = reparto.split("\\s*,\\s*");
        
        for (String actor : actores) {
            if (!Cadena.validarPalabra(actor)) {
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean validarNumTemporadas(String numTemporadas) {
        return numTemporadas.matches("^[1-9]?[0-9]$");
    }
    
}
