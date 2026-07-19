package model;

/**
 * Representa un cliente de la agencia Llanquihue Tour.
 */
public class Cliente extends Persona {

    private String telefono;
    private String correo;

    /**
     * Construye un cliente con sus datos personales y de contacto.
     *
     * @param rut RUT del cliente
     * @param nombre nombre completo
     * @param direccion dirección del cliente
     * @param telefono teléfono de contacto
     * @param correo correo electrónico
     */
    public Cliente(
            String rut,
            String nombre,
            Direccion direccion,
            String telefono,
            String correo
    ) {
        super(rut, nombre, direccion);
        setTelefono(telefono);
        setCorreo(correo);
    }

    /**
     * Obtiene el teléfono.
     *
     * @return teléfono del cliente
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Modifica el teléfono, evitando valores vacíos.
     *
     * @param telefono nuevo teléfono
     */
    public void setTelefono(String telefono) {
        if (telefono == null || telefono.isBlank()) {
            throw new IllegalArgumentException(
                    "El teléfono no puede estar vacío."
            );
        }

        this.telefono = telefono.trim();
    }

    /**
     * Obtiene el correo electrónico.
     *
     * @return correo del cliente
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Modifica el correo electrónico después de validar su formato.
     *
     * @param correo nuevo correo
     */
    public void setCorreo(String correo) {
        if (correo == null
                || correo.isBlank()
                || !correo.contains("@")
                || !correo.contains(".")) {

            throw new IllegalArgumentException(
                    "El correo electrónico no es válido."
            );
        }

        this.correo = correo.trim();
    }

    /**
     * Muestra un resumen del cliente.
     *
     * @return resumen de sus datos
     */
    @Override
    public String mostrarResumen() {
        return "Cliente | " + super.toString()
                + " | Teléfono: " + telefono
                + " | Correo: " + correo;
    }

    /**
     * Entrega todos los datos del cliente.
     *
     * @return datos formateados
     */
    @Override
    public String toString() {
        return super.toString()
                + " | Teléfono: " + telefono
                + " | Correo: " + correo;
    }
}