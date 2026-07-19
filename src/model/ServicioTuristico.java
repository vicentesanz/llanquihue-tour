package model;

/**
 * Clase abstracta que representa un servicio turístico.
 */
public abstract class ServicioTuristico
        implements Registrable {

    private String nombre;
    private int duracionHoras;

    /**
     * Construye un servicio turístico.
     *
     * @param nombre nombre del servicio
     * @param duracionHoras duración expresada en horas
     */
    public ServicioTuristico(
            String nombre,
            int duracionHoras
    ) {
        setNombre(nombre);
        setDuracionHoras(duracionHoras);
    }

    /**
     * Obtiene el nombre del servicio.
     *
     * @return nombre registrado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del servicio.
     *
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                    "El nombre del servicio no puede estar vacío."
            );
        }

        this.nombre = nombre.trim();
    }

    /**
     * Obtiene la duración del servicio.
     *
     * @return duración expresada en horas
     */
    public int getDuracionHoras() {
        return duracionHoras;
    }

    /**
     * Modifica la duración del servicio.
     *
     * @param duracionHoras nueva duración
     */
    public void setDuracionHoras(int duracionHoras) {
        if (duracionHoras <= 0) {
            throw new IllegalArgumentException(
                    "La duración debe ser mayor que cero."
            );
        }

        this.duracionHoras = duracionHoras;
    }

    /**
     * Muestra la información del servicio turístico.
     */
    public void mostrarInformacion() {
        System.out.println(toString());
    }

    /**
     * Muestra un resumen general del servicio.
     *
     * @return resumen del servicio
     */
    @Override
    public String mostrarResumen() {
        return "Servicio: " + nombre
                + " | Duración: "
                + duracionHoras + " horas";
    }

    /**
     * Entrega la información general del servicio.
     *
     * @return información formateada
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre
                + ", Duración: "
                + duracionHoras + " horas";
    }
}