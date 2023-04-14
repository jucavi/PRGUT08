package app.molelos;

import java.util.LinkedHashMap;
import java.util.Objects;
import lib.utils.validaciones.Cadena;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class Libro extends Archivo {

    private String editorial;
    private String saga;

    public Libro(String titulo, String anyoPub, String creador, String genero,
            String editorial, String saga) {
        super(titulo, anyoPub, creador, genero);
        this.editorial = editorial;
        this.saga = saga;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getSaga() {
        return saga;
    }

    public void setSaga(String saga) {
        this.saga = saga;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 29 * hash + Objects.hashCode(this.editorial);
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
        if (!super.equals(obj)) {
            return false;
        }
        final Libro other = (Libro) obj;
        return Objects.equals(other.editorial.toLowerCase(), other.editorial.toLowerCase());
    }

    @Override
    public LinkedHashMap<String, String> toHashMap() {
        LinkedHashMap<String, String> resultado = new LinkedHashMap<>(super.toHashMap());

        resultado.put("editorial", this.getEditorial());
        resultado.put("saga", this.getSaga());

        return resultado;
    }
    
    public static boolean validarEditorial(String editorial) {
        return Cadena.validarPalabra(editorial);
    }
}
