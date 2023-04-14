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
public class Pelicula extends Archivo {
    
    private String reparto;
    private String saga;

    public Pelicula(String titulo, String anyoPub, String creador, String genero, 
            String reparto, String saga) {
        super(titulo, anyoPub, creador, genero);
        this.reparto = reparto;
        this.saga = saga;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public String getSaga() {
        return saga;
    }

    public void setSaga(String saga) {
        this.saga = saga;
    }
    

    @Override
    public LinkedHashMap<String, String> toHashMap() {
        LinkedHashMap<String, String> resultado = new LinkedHashMap<>(super.toHashMap());
        
        resultado.put("reparto", this.getReparto());
        resultado.put("saga", this.getSaga());

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
}
