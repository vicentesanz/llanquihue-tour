package model;

/**
 * Representa un paseo lacustre.
 */
public class PaseoLacustre
        extends ServicioTuristico {

    private String tipoEmbarcacion;

    /**
     * Construye un paseo lacustre.
     *
     * @param nombre nombre del paseo
     * @param duracionHoras duración en horas
     * @param tipoEmbarcacion embarcación utilizada
     */
    public PaseoLacustre(
            String nombre,
            int duracionHoras,
            String tipoEmbarcacion
    ) {
        super(nombre, duracionHoras);
        setTipoEmbarcacion(tipoEmbarcacion);
    }

    /**
     * Obtiene el tipo de embarcación.
     *
     * @return embarcación registrada
     */
    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    /**
     * Modifica el tipo de embarcación.
     *
     * @param tipoEmbarcacion nueva embarcación
     */
    public void setTipoEmbarcacion(
            String tipoEmbarcacion
    ) {
        if (tipoEmbarcacion == null
                || tipoEmbarcacion.isBlank()) {

            throw new IllegalArgumentException(
                    "El tipo de embarcación no puede estar vacío."
            );
        }

        this.tipoEmbarcacion =
                tipoEmbarcacion.trim();
    }

    /**
     * Muestra un resumen específico del paseo.
     *
     * @return resumen del paseo
     */
    @Override
    public String mostrarResumen() {
        return "Paseo Lacustre: " + getNombre()
                + " | Duración: "
                + getDuracionHoras() + " horas"
                + " | Embarcación: "
                + tipoEmbarcacion;
    }

    /**
     * Muestra información utilizando polimorfismo.
     */
    @Override
    public void mostrarInformacion() {
        System.out.println(
                "Paseo Lacustre -> " + toString()
        );
    }

    /**
     * Entrega todos los datos del paseo.
     *
     * @return datos formateados
     */
    @Override
    public String toString() {
        return super.toString()
                + ", Tipo de embarcación: "
                + tipoEmbarcacion;
    }
}