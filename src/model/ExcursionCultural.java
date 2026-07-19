package model;

/**
 * Representa una excursión cultural.
 */
public class ExcursionCultural
        extends ServicioTuristico {

    private String lugarHistorico;

    /**
     * Construye una excursión cultural.
     *
     * @param nombre nombre de la excursión
     * @param duracionHoras duración en horas
     * @param lugarHistorico lugar que se visita
     */
    public ExcursionCultural(
            String nombre,
            int duracionHoras,
            String lugarHistorico
    ) {
        super(nombre, duracionHoras);
        setLugarHistorico(lugarHistorico);
    }

    /**
     * Obtiene el lugar histórico.
     *
     * @return lugar registrado
     */
    public String getLugarHistorico() {
        return lugarHistorico;
    }

    /**
     * Modifica el lugar histórico.
     *
     * @param lugarHistorico nuevo lugar
     */
    public void setLugarHistorico(
            String lugarHistorico
    ) {
        if (lugarHistorico == null
                || lugarHistorico.isBlank()) {

            throw new IllegalArgumentException(
                    "El lugar histórico no puede estar vacío."
            );
        }

        this.lugarHistorico =
                lugarHistorico.trim();
    }

    /**
     * Muestra un resumen específico de la excursión.
     *
     * @return resumen de la excursión
     */
    @Override
    public String mostrarResumen() {
        return "Excursión Cultural: " + getNombre()
                + " | Duración: "
                + getDuracionHoras() + " horas"
                + " | Lugar histórico: "
                + lugarHistorico;
    }

    /**
     * Muestra información utilizando polimorfismo.
     */
    @Override
    public void mostrarInformacion() {
        System.out.println(
                "Excursión Cultural -> " + toString()
        );
    }

    /**
     * Entrega todos los datos de la excursión.
     *
     * @return datos formateados
     */
    @Override
    public String toString() {
        return super.toString()
                + ", Lugar histórico: "
                + lugarHistorico;
    }
}