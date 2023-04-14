package app.vistas.salida;

import app.molelos.Archivo;
import java.util.Comparator;

/**
 * Permite comparar colecciones de arvivos multimedia teniendo en cuenta el
 * orden (Año, título) de forma ascendente.
 *
 * @author Juan Carlos Vilarrubia
 */
public class ComparadorArchivosAnyoTitulo implements Comparator<Archivo> {

    @Override
    public int compare(Archivo o1, Archivo o2) {
        // Comparamos los años de publicación
        int comparador = Integer.parseInt(o1.getAnyoPub()) - Integer.parseInt(o2.getAnyoPub());

        // Si no son iguales ya está ordenado
        if (comparador != 0) {
            return comparador;
        }

        // En caso de haber sido publicados el mismo año comparamos los títulos
        comparador = o1.getTitulo()
                .toLowerCase()
                .compareTo(o2.getTitulo().toLowerCase());

        if (comparador != 0) {
            return comparador;
        }

        // En caso de coincidir ordenamos por tipo
        return o1.getClass()
                .getSimpleName()
                .compareTo(o2.getClass().getSimpleName());
    }

}
