/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.molelos;

import java.util.LinkedHashMap;
import java.util.Objects;
import lib.utils.validaciones.Cadena;

/**
 * La clase {@code Archivo} representa la información básica de un archivo
 * 
 * @author Juan Carlos Vilarrubia
 */
public abstract class Archivo implements Mapeable {
    
    private String titulo;
    private String anyoPub;
    private String creador;
    private String genero;

    public Archivo(String titulo, String anyoPub, String creador, String genero) {
        this.titulo = titulo;
        this.anyoPub = anyoPub;
        this.creador = creador;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnyoPub() {
        return anyoPub;
    }

    public void setAnyoPub(String anyoPub) {
        this.anyoPub = anyoPub;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.titulo);
        hash = 47 * hash + Objects.hashCode(this.anyoPub);
        hash = 47 * hash + Objects.hashCode(this.creador);
        hash = 47 * hash + Objects.hashCode(this.genero);
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
        final Archivo other = (Archivo) obj;
        if (!Objects.equals(this.genero.toLowerCase(), other.genero.toLowerCase())) {
            return false;
        }
        if (!Objects.equals(this.anyoPub, other.anyoPub)) {
            return false;
        }
        if (!Objects.equals(this.genero.toLowerCase(), other.genero.toLowerCase())) {
            return false;
        }
        return Objects.equals(this.genero.toLowerCase(), other.genero.toLowerCase());
    }
    
    
    @Override
    public LinkedHashMap<String, String> toHashMap() {
        LinkedHashMap<String, String> resultado = new LinkedHashMap<>();

        resultado.put("tipo", this.getClass().getSimpleName());
        resultado.put("titulo", this.getTitulo());
        resultado.put("año publicación", this.getAnyoPub());
        resultado.put("creador", this.getCreador());
        resultado.put("genero", this.getGenero());

        return resultado;
    }
    
    public static boolean validarTitulo(String titulo) {
        
        if (titulo == null || titulo.isEmpty()) {
            return false;
        }
  
        return titulo.strip().matches("(?i)[a-z¡¿!\\?\\d\\s\\.,]+");
    }
    
    public static boolean validarCreador(String creador) {
        return Cadena.validarPalabras(creador.strip().split("[\\s,-]+"));
    }
    
    public static boolean validarGenero(String genero) {
        return Cadena.validarPalabra(genero);
    }
    
    public static boolean validarAnyoPub(String anyoPub) {
        return anyoPub.matches("^-?[1-9][0-9]{0,3}$");
    }
    
}
