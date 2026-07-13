package model;

/**
 * Representa un guía turístico de la agencia Llanquihue Tour.
 */
public class GuiaTuristico implements Registrable {

    private String nombre;
    private String idioma;
    private int experiencia;

    public GuiaTuristico(String nombre, String idioma, int experiencia) {
        this.nombre = nombre;
        this.idioma = idioma;
        this.experiencia = experiencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public String mostrarResumen() {
        return "Guía: " + nombre +
                " | Idioma: " + idioma +
                " | Experiencia: " + experiencia + " años";
    }

    @Override
    public String toString() {
        return nombre + " | Idioma: " + idioma + " | Experiencia: " + experiencia + " años";
    }
}