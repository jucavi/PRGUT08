package lib.utils.menu;

/**
 * Permite crear un menú básico a partir de un arreglo de cadenas de caracteres
 * pasado como parámetro, pudiendo elegir si la opción {@code 0} de salida
 * aparece o no en el menu.
 *
 * @author Juan Carlos Vilarrubia
 */
public class MenuNumerico {

    /**
     * Lista de opciones
     */
    private String[] opciones;
    /**
     * Título del menú
     */
    private String titulo;
    private final boolean conSalida;

    /**
     * Constructor de la clase MenuNumerico
     *
     * @param titulo Titulo del menú
     * @param opciones Opciones a mostrar del menú
     * @param conSalida {@code true} aparece la opción {@code 0} de salida al
     * final del menú
     */
    public MenuNumerico(String titulo, String[] opciones, boolean conSalida) {
        this.opciones = opciones;
        this.titulo = titulo;
        this.conSalida = conSalida;
    }

    /**
     * Muestra por pantalla el menú con formato
     *
     * <p>
     * Titulo del menu
     * <li> 1. Opcion1
     * <li> 2. Opcion2
     * <li> 3. Opcion3
     * <li> 0. Salir (Solo en caso que {@code conSalida = true})
     *
     */
    public void mostrar() {

        final String TITULO = "Menú";
        final String FORMATO = "  %d. %s.%n";

        if (titulo == null || titulo.isBlank()) {
            titulo = TITULO;
        }

        if (opciones == null || opciones.length == 0) {
            opciones = new String[]{"Menu vacio"};

        }
        System.out.println(titulo);
        for (int i = 0; i < opciones.length; i++) {
            System.out.printf(FORMATO, i + 1, opciones[i]);
        }

        if (conSalida) {
            System.out.printf(FORMATO, 0, "Salir");
        }
    }

}
