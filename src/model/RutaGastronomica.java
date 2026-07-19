package model;

/**
 * Representa una ruta gastronómica.
 */
public class RutaGastronomica
        extends ServicioTuristico {

    private int numeroDeParadas;

    /**
     * Construye una ruta gastronómica.
     *
     * @param nombre nombre de la ruta
     * @param duracionHoras duración en horas
     * @param numeroDeParadas cantidad de paradas
     */
    public RutaGastronomica(
            String nombre,
            int duracionHoras,
            int numeroDeParadas
    ) {
        super(nombre, duracionHoras);
        setNumeroDeParadas(numeroDeParadas);
    }

    /**
     * Obtiene el número de paradas.
     *
     * @return cantidad de paradas
     */
    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    /**
     * Modifica el número de paradas.
     *
     * @param numeroDeParadas nueva cantidad
     */
    public void setNumeroDeParadas(
            int numeroDeParadas
    ) {
        if (numeroDeParadas <= 0) {
            throw new IllegalArgumentException(
                    "El número de paradas debe ser mayor que cero."
            );
        }

        this.numeroDeParadas = numeroDeParadas;
    }

    /**
     * Muestra un resumen específico de la ruta.
     *
     * @return resumen de la ruta
     */
    @Override
    public String mostrarResumen() {
        return "Ruta Gastronómica: " + getNombre()
                + " | Duración: "
                + getDuracionHoras() + " horas"
                + " | Paradas: " + numeroDeParadas;
    }

    /**
     * Muestra información utilizando polimorfismo.
     */
    @Override
    public void mostrarInformacion() {
        System.out.println(
                "Ruta Gastronómica -> " + toString()
        );
    }

    /**
     * Entrega todos los datos de la ruta.
     *
     * @return datos formateados
     */
    @Override
    public String toString() {
        return super.toString()
                + ", Número de paradas: "
                + numeroDeParadas;
    }
}