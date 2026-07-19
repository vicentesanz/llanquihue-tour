package model;

/**
 * Representa un tour turístico ofrecido por la agencia.
 */
public class Tour {

    private String nombre;
    private String tipo;
    private int precio;
    private GuiaTuristico guia;
    private ProveedorTransporte transporte;

    /**
     * Construye un tour con un guía y un proveedor de transporte.
     *
     * @param nombre nombre del tour
     * @param tipo categoría del tour
     * @param precio precio del tour
     * @param guia guía responsable
     * @param transporte proveedor de transporte
     */
    public Tour(
            String nombre,
            String tipo,
            int precio,
            GuiaTuristico guia,
            ProveedorTransporte transporte
    ) {
        setNombre(nombre);
        setTipo(tipo);
        setPrecio(precio);
        setGuia(guia);
        setTransporte(transporte);
    }

    /**
     * Obtiene el nombre del tour.
     *
     * @return nombre registrado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del tour.
     *
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                    "El nombre del tour no puede estar vacío."
            );
        }

        this.nombre = nombre.trim();
    }

    /**
     * Obtiene el tipo de tour.
     *
     * @return tipo registrado
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Modifica el tipo de tour.
     *
     * @param tipo nuevo tipo
     */
    public void setTipo(String tipo) {
        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException(
                    "El tipo de tour no puede estar vacío."
            );
        }

        this.tipo = tipo.trim();
    }

    /**
     * Obtiene el precio.
     *
     * @return precio del tour
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Modifica el precio.
     *
     * @param precio nuevo precio
     */
    public void setPrecio(int precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException(
                    "El precio debe ser mayor que cero."
            );
        }

        this.precio = precio;
    }

    /**
     * Obtiene el guía responsable.
     *
     * @return guía del tour
     */
    public GuiaTuristico getGuia() {
        return guia;
    }

    /**
     * Modifica el guía responsable.
     *
     * @param guia nuevo guía
     */
    public void setGuia(GuiaTuristico guia) {
        if (guia == null) {
            throw new IllegalArgumentException(
                    "El guía no puede ser nulo."
            );
        }

        this.guia = guia;
    }

    /**
     * Obtiene el proveedor de transporte.
     *
     * @return proveedor asignado
     */
    public ProveedorTransporte getTransporte() {
        return transporte;
    }

    /**
     * Modifica el proveedor de transporte.
     *
     * @param transporte nuevo proveedor
     */
    public void setTransporte(
            ProveedorTransporte transporte
    ) {
        if (transporte == null) {
            throw new IllegalArgumentException(
                    "El proveedor de transporte no puede ser nulo."
            );
        }

        this.transporte = transporte;
    }

    /**
     * Entrega toda la información del tour.
     *
     * @return datos formateados
     */
    @Override
    public String toString() {
        return "Tour: " + nombre
                + " | Tipo: " + tipo
                + " | Precio: $" + precio
                + " | Guía: " + guia
                + " | Transporte: " + transporte;
    }
}