package lib.utils.string;

/**
 * Calse que permite operar con cadenas de carácteres
 *
 * @author Juan Carlos Vilarrubia
 */
public class OperacionesCadena {

    /**
     * Genera un template dinamicamente para operar con cadenas
     *
     * @param numCol Número de columnas
     * @param anchoCol Anco de la columna
     * @param alineacionIzq En caso de ser {@code true} el texto estará alineado
     * a la izquierda
     * @return Un template de la forma "%[alineacion][anchoCol]s | 
     * %[alineacion][anchoCol]s ..."
     * @see String#format(java.lang.String, java.lang.Object...)
     */
    public static String crearStringTemplate(int numCol, int anchoCol, boolean alineacionIzq) {

        String[] marcador = new String[numCol];
        char alineacion = '+';

        if (alineacionIzq) {
            alineacion = '-';
        }

        for (int i = 0; i < numCol; i++) {
            marcador[i] = "%" + alineacion + anchoCol + "s";
        }

        return String.join(" | ", marcador);
    }

    /**
     * Devuelve la primera letra del texto pasado como parámetro en mayúsculas y
     * el resto en minúsculas
     *
     * @param texto Cadena de texto
     * @return Texto con la primera letra en mayúsculas el resto en minúsculas
     */
    public static String capitalizar(String texto) {

        if (texto == null || texto.isEmpty()) {
            return "";
        }

        if (texto.length() == 1) {
            return texto.toUpperCase();
        }

        return texto.substring(0, 1)
                .toUpperCase() + texto.substring(1).toLowerCase();
    }

    /**
     * Devuelve la primera letra de cada palabra del texto pasado como parámetro
     * en mayúscula y el resto en minúsculas, con solo un espacio entre palabras
     *
     * @param texto Cadena de texto
     * @return Texto con la primera letra en mayúsculas el resto en minúsculas
     */
    public static String capitalizarTexto(String texto) {
        if (texto == null) {
            return "";
        }

        String[] palabras = texto.split("\\s+");

        for (int i = 0; i < palabras.length; i++) {
            palabras[i] = capitalizar(palabras[i].strip());
        }

        return String.join(" ", palabras);
    }
    
    public static String capitalizarLista(String texto) {
        if (texto == null) {
            return "";
        }
        
        // ¿capitalizar texto? 
        
        String[] palabras = texto.split("\\s*,\\s*");

        for (int i = 0; i < palabras.length; i++) {
            palabras[i] = capitalizar(palabras[i].strip());
        }

        return String.join(", ", palabras);
    }
}
