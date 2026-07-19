package model;

/**
 * Representa la dirección de una persona registrada en el sistema.
 */
public class Direccion {

    private String calle;
    private int numero;
    private String comuna;

    /**
     * Construye una dirección con sus datos principales.
     *
     * @param calle nombre de la calle
     * @param numero número de la dirección
     * @param comuna comuna correspondiente
     */
    public Direccion(String calle, int numero, String comuna) {
        setCalle(calle);
        setNumero(numero);
        setComuna(comuna);
    }

    /**
     * Obtiene el nombre de la calle.
     *
     * @return calle registrada
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Modifica la calle evitando valores vacíos.
     *
     * @param calle nueva calle
     */
    public void setCalle(String calle) {
        if (calle == null || calle.isBlank()) {
            throw new IllegalArgumentException(
                    "La calle no puede estar vacía."
            );
        }

        this.calle = calle.trim();
    }

    /**
     * Obtiene el número de la dirección.
     *
     * @return número registrado
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Modifica el número de la dirección.
     *
     * @param numero nuevo número
     */
    public void setNumero(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException(
                    "El número de la dirección debe ser mayor que cero."
            );
        }

        this.numero = numero;
    }

    /**
     * Obtiene la comuna.
     *
     * @return comuna registrada
     */
    public String getComuna() {
        return comuna;
    }

    /**
     * Modifica la comuna evitando valores vacíos.
     *
     * @param comuna nueva comuna
     */
    public void setComuna(String comuna) {
        if (comuna == null || comuna.isBlank()) {
            throw new IllegalArgumentException(
                    "La comuna no puede estar vacía."
            );
        }

        this.comuna = comuna.trim();
    }

    /**
     * Entrega la dirección completa como texto.
     *
     * @return dirección formateada
     */
    @Override
    public String toString() {
        return calle + " #" + numero + ", " + comuna;
    }
}