package model;

/**
 * Representa una excursión cultural.
 */
public class ExcursionCultural extends ServicioTuristico {

    private String lugarHistorico;

    public ExcursionCultural(String nombre, int duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);
        this.lugarHistorico = lugarHistorico;
    }

    public String getLugarHistorico() {
        return lugarHistorico;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Excursión Cultural -> " + toString());
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Lugar histórico: " + lugarHistorico;
    }
}