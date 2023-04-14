package lib.utils.io;

import java.util.Scanner;

/**
 * Clase de utilidades de entrada por teclado
 *
 * @author Juan Carlos Vilarrubia
 */
public class Teclado {
    
    private static final int INT_FALSE = Integer.MIN_VALUE; 

    /**
     * Entrada de linea de texto por teclado
     *
     * @return Cadena de caracteres sin espacios al inicio y al final
     */
    public static String getInput() {

        Scanner sc = new Scanner(System.in, "UTF-8");

        return sc.nextLine().strip();
    }

    /**
     * Entrada de linea de texto por teclado con mensaje informativo
     *
     * @param mensaje Mensaje que aparecerá por pantalla
     * @return Cadena de caracteres sin espacios al inicio y al final
     */
    public static String getInput(String mensaje) {

        System.out.print(mensaje);
        return getInput();
    }

    /**
     * Entrada de número entero por teclado, si el valor ingresado no es unn
     * entero se muestra mensaje por pantalla
     *
     * @return Número entero, {@code Integer.MIN_VALUE} si lo que se introduce
     * por teclado no es un número entero
     */
    public static int getInteger() {

        int numero = INT_FALSE;
        Scanner sc = new Scanner(System.in);

        try {
            numero = sc.nextInt();
        } catch (Exception e) {
            // El mensaje de error al log

            System.out.println("Introduzca un número entero");
        }

        return numero;
    }

    /**
     * Entrada de número entero por teclado con mensaje informativo
     *
     * @param mensaje Mensaje que aparecerá por pantalla
     * @return Número entero, {@code Integer.MIN_VALUE} si lo que se introduce
     * por teclado no es un número entero
     * @see Teclado#getInteger
     */
    public static int getInteger(String mensaje) {

        System.out.print(mensaje);
        return getInteger();
    }

    /**
     * Entrada de número entero por teclado que se encuentre entre un valor
     * mínimo y máximo ambos incluidos
     *
     * @param min Valor Mínimo
     * @param max Valor Máximo
     * @return Número entero que se encuentre dentro [min, max] ambos incluidos,
     * {@code Integer.MIN_VALUE} si lo que se introduce por teclado no es un
     * número entero o no esta incluido en el rango
     * @see Teclado#getInteger
     */
    public static int getIntegerBetween(int min, int max) {

        int numero = getInteger();

        if (numero >= min && numero <= max) {
            return numero;
        }

        System.out.printf("Introduzca un número entero entre %d-%d%n", min, max);
        return INT_FALSE;
    }

    /**
     * Entrada de número entero por teclado que se encuentre entre un valor
     * mínimo y máximo ambos incluidos con mensaje informativo
     *
     * @param mensaje Mensaje que aparecerá en pantalla
     * @param min Valor Mínimo
     * @param max Valor Máximo
     * @return Número entero que se encuentre dentro [min, max] ambos incluidos,
     * {@code Integer.MIN_VALUE} si lo que se introduce por teclado no es un
     * número entero o no esta incluido en el rango
     * @see Teclado#getInteger
     * @see Teclado#getIntegerBetween
     */
    public static int getIntegerBetween(String mensaje, int min, int max) {

        System.out.print(mensaje);
        return getIntegerBetween(min, max);
    }

    /**
     * Entrada de número entero positivo por teclado con mensaje informativo
     *
     * @param mensaje Mensaje que aparecerá en pantalla
     * @return Número entero que se encuentre dentro
     * [{@code 1}, {@code Integer.MAX_VALUE}] ambos incluidos,
     * {@code Integer.MIN_VALUE} si lo que se introduce por teclado no es un
     * número entero o no esta incluido en el rango
     * @see Teclado#getInteger
     * @see Teclado#getIntegerBetween
     */
    public static int getPositiveInteger(String mensaje) {

        System.out.print(mensaje);
        return getIntegerBetween(1, Integer.MAX_VALUE);
    }

    /**
     * Compara si el valor introducido por teclado es igual a la cadena de
     * caracteres pasada como parámetro sin tener en cuenta mayúsculas y
     * minúsculas
     *
     * @param cadena Cadena de caracteres
     * @return {@code true} si la entrada por teclado es igual a la cadena
     * ignorando mayúsculas y minúsculas, {@code false} en caso contrario
     */
    public static boolean getBooleanIgnorecase(String cadena) {

        String entrada = getInput();

        return entrada.equalsIgnoreCase(cadena);
    }

    /**
     * Compara si el valor introducido por teclado es igual a la cadena de
     * caracteres pasada como parámetro sin tener en cuenta mayúsculas y
     * minúsculas, con mensaje informativo
     *
     * @param mensaje Mensaje a mostrar por pantalla
     * @param cadena Cadena de caracteres
     * @return {@code true} si la entrada por teclado es igual a la cadena
     * ignorando mayúsculas y minúsculas, {@code false} en caso contrario
     */
    public static boolean getBoolean(String mensaje, String cadena) {

        System.out.print(mensaje);
        return getBooleanIgnorecase(cadena);
    }
    
    
    /**
     * Muestra por pantalla el mensaje pasado como primer parámetro y espera el 
     * valor introducido por teclado, si este valor no es un número entero o 
     * no está dentro del rango [min, max] ambos incluidos muestra el mensaje de
     * error y repite el proceso hasta que se introduzca uno de los valores esperados
     * 
     * @param promptMsg Mensaje que se muestra solicitando la entrada
     * @param errorMsg  Mensaje que se muestra si la entrada no es válida
     * @param min       Valor mínimo
     * @param max       Valor máximo
     * @return Número entero dentro del rango [min. max] ambos incluidos
     */
    public static int getIntUntilTrue(String promptMsg, String errorMsg, int min, int max) {
        int entrada;

        do {
            entrada = Teclado.getIntegerBetween(String.format("%s [%d-%d]: ", promptMsg, min, max),
                    min,
                    max
            );

            if (entrada == Teclado.INT_FALSE) {
                System.out.println(errorMsg);
            }

        } while (entrada == Teclado.INT_FALSE);

        return entrada;
    }
    
    
    /**
     * Muestra por pantalla el mensaje pasado como primer parámetro y espera el 
     * valor introducido por teclado, si este valor es una cadena de carácteres
     * vacia muestra el mensaje de error y repite el proceso hasta que se introduzca 
     * al menos un carácter
     * 
     * @param promptMsg Mensaje que se muestra solicitando la entrada
     * @param errorMsg  Mensaje que se muestra si la entrada no es válida
     * @param min Longitud mínima de la cadena de caracteres a introducir por teclado
     * @return Cadena de caracteres con al menos {@code min} caracteres
     */
    public static String getStringUntilTrue(String promptMsg, String errorMsg, int min) {
        String entrada;
        boolean esValida = false;

        do {
            entrada = Teclado.getInput(promptMsg);

            if (entrada.isBlank() || entrada.length() < min) {
                System.out.println(errorMsg);
            } else {
                esValida = true;
            }

        } while (!esValida);

        return entrada;
    }
    
    
    /**
     * Muestra por pantalla el mensaje pasado como primer parámetro y espera el 
     * valor introducido por teclado, si este valor no es un número entero positivo
     * muestra el mensaje de error y repite el proceso hasta que se introduzca 
     * un número entero positivo.
     * 
     * @param promptMsg Mensaje que se muestra solicitando la entrada
     * @param errorMsg  Mensaje que se muestra si la entrada no es válida
     * @return Número entero positivo
     */
    public static int getPositiveIntUntilTrue(String promptMsg, String errorMsg) {
        int entrada;

        do {
            entrada = Teclado.getPositiveInteger(promptMsg);

            if (entrada == Teclado.INT_FALSE) {
                System.out.println(errorMsg);
            }

        } while (entrada == Teclado.INT_FALSE);

        return entrada;
    }
}
