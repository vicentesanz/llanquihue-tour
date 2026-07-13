package model;

/**
 * Representa un paseo lacustre.
 */
public class PaseoLacustre extends ServicioTuristico {

    private String tipoEmbarcacion;

    public PaseoLacustre(String nombre, int duracionHoras, String tipoEmbarcacion) {
        super(nombre, duracionHoras);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    @Override
    public String mostrarResumen() {
        return "Paseo Lacustre: " + getNombre()
                + " | Embarcación: " + tipoEmbarcacion;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Paseo Lacustre -> " + toString());
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Tipo de embarcación: " + tipoEmbarcacion;
    }
}