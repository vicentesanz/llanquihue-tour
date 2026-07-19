package model;

/**
 * Representa un guía turístico de la agencia Llanquihue Tour.
 */
public class GuiaTuristico extends Persona {

    private String idioma;
    private int experiencia;

    /**
     * Constructor utilizado para los datos antiguos del archivo tours.txt.
     *
     * @param nombre nombre del guía
     * @param idioma idioma que domina
     * @param experiencia años de experiencia
     */
    public GuiaTuristico(
            String nombre,
            String idioma,
            int experiencia
    ) {
        super(nombre);
        setIdioma(idioma);
        setExperiencia(experiencia);
    }

    /**
     * Construye un guía turístico con todos sus datos.
     *
     * @param rut RUT del guía
     * @param nombre nombre completo
     * @param direccion dirección del guía
     * @param idioma idioma que domina
     * @param experiencia años de experiencia
     */
    public GuiaTuristico(
            String rut,
            String nombre,
            Direccion direccion,
            String idioma,
            int experiencia
    ) {
        super(rut, nombre, direccion);
        setIdioma(idioma);
        setExperiencia(experiencia);
    }

    /**
     * Obtiene el idioma del guía.
     *
     * @return idioma registrado
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * Modifica el idioma, evitando valores vacíos.
     *
     * @param idioma nuevo idioma
     */
    public void setIdioma(String idioma) {
        if (idioma == null || idioma.isBlank()) {
            throw new IllegalArgumentException(
                    "El idioma no puede estar vacío."
            );
        }

        this.idioma = idioma.trim();
    }

    /**
     * Obtiene los años de experiencia.
     *
     * @return años de experiencia
     */
    public int getExperiencia() {
        return experiencia;
    }

    /**
     * Modifica los años de experiencia.
     *
     * @param experiencia nuevos años de experiencia
     */
    public void setExperiencia(int experiencia) {
        if (experiencia < 0) {
            throw new IllegalArgumentException(
                    "La experiencia no puede ser negativa."
            );
        }

        this.experiencia = experiencia;
    }

    /**
     * Muestra un resumen del guía turístico.
     *
     * @return resumen de sus datos
     */
    @Override
    public String mostrarResumen() {
        return "Guía turístico | " + super.toString()
                + " | Idioma: " + idioma
                + " | Experiencia: " + experiencia + " años";
    }

    /**
     * Entrega todos los datos del guía.
     *
     * @return datos formateados
     */
    @Override
    public String toString() {
        return super.toString()
                + " | Idioma: " + idioma
                + " | Experiencia: " + experiencia + " años";
    }
}