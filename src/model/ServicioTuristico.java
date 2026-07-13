package model;

/**
 * Clase base que representa un servicio turístico.
 */
public class ServicioTuristico implements Registrable {

    private String nombre;
    private int duracionHoras;

    public ServicioTuristico(String nombre, int duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    /**
     * Muestra la información del servicio turístico.
     */
    public void mostrarInformacion() {
        System.out.println(toString());
    }

    @Override
    public void mostrarResumen() {
        System.out.println("Servicio: " + getNombre());
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                ", Duración: " + duracionHoras + " horas";
    }
}