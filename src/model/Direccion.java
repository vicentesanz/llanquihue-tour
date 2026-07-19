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
        this.calle = calle;
        this.numero = numero;
        this.comuna = comuna;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
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