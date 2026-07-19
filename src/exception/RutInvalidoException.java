package exception;

/**
 * Excepción personalizada utilizada cuando se ingresa un RUT inválido.
 */
public class RutInvalidoException extends IllegalArgumentException {

    /**
     * Construye la excepción con un mensaje explicativo.
     *
     * @param mensaje descripción del error encontrado
     */
    public RutInvalidoException(String mensaje) {
        super(mensaje);
    }
}