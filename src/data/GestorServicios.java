package data;

import model.ExcursionCultural;
import model.PaseoLacustre;
import model.RutaGastronomica;
import model.ServicioTuristico;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona los servicios turísticos.
 */
public class GestorServicios {

    private List<ServicioTuristico> servicios;

    public GestorServicios() {
        servicios = new ArrayList<>();

        servicios.add(new RutaGastronomica(
                "Ruta de Sabores", 4, 5));

        servicios.add(new RutaGastronomica(
                "Ruta del Chocolate", 3, 4));

        servicios.add(new PaseoLacustre(
                "Paseo Lago Llanquihue", 2, "Catamarán"));

        servicios.add(new PaseoLacustre(
                "Paseo Río Maullín", 3, "Lancha"));

        servicios.add(new ExcursionCultural(
                "Museo Colonial", 2, "Fuerte San Antonio"));

        servicios.add(new ExcursionCultural(
                "Centro Histórico", 5, "Iglesia Patrimonial"));
    }

    /**
     * Muestra todos los servicios utilizando polimorfismo.
     */
    public void mostrarServicios() {

        System.out.println("=== SERVICIOS TURÍSTICOS ===");

        for (ServicioTuristico servicio : servicios) {
            servicio.mostrarInformacion();
        }
    }
}