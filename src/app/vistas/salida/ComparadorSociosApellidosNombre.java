package app.vistas.salida;

import app.molelos.Socio;
import java.util.Comparator;

/**
 * Permite comparar Socios teniendo en cuenta los criterios de ordenación
 * (apellidos, nombre)
 *
 * @author Juan Carlos Vilarrubia
 */
public class ComparadorSociosApellidosNombre implements Comparator<Socio> {

    @Override
    public int compare(Socio o1, Socio o2) {
        int comparador = o1.getApellidos()
                .toLowerCase()
                .compareTo(o2.getApellidos().toLowerCase());

        if (comparador != 0) {
            return comparador;
        }

        return o1.getNombre()
                .toLowerCase()
                .compareTo(o2.getNombre().toLowerCase());
    }

}
