package data;

import model.ExcursionCultural;
import model.PaseoLacustre;
import model.RutaGastronomica;

/**
 * Crea servicios turísticos de prueba.
 */
public class GestorServicios {

    public void mostrarServicios() {

        RutaGastronomica ruta1 = new RutaGastronomica(
                "Ruta de Sabores", 4, 5);

        RutaGastronomica ruta2 = new RutaGastronomica(
                "Ruta del Chocolate", 3, 4);

        PaseoLacustre paseo1 = new PaseoLacustre(
                "Paseo Lago Llanquihue", 2, "Catamarán");

        PaseoLacustre paseo2 = new PaseoLacustre(
                "Paseo Río Maullín", 3, "Lancha");

        ExcursionCultural excursion1 = new ExcursionCultural(
                "Museo Colonial", 2, "Fuerte San Antonio");

        ExcursionCultural excursion2 = new ExcursionCultural(
                "Centro Histórico", 5, "Iglesia Patrimonial");

        System.out.println("=== RUTAS GASTRONÓMICAS ===");
        System.out.println(ruta1);
        System.out.println(ruta2);

        System.out.println("\n=== PASEOS LACUSTRES ===");
        System.out.println(paseo1);
        System.out.println(paseo2);

        System.out.println("\n=== EXCURSIONES CULTURALES ===");
        System.out.println(excursion1);
        System.out.println(excursion2);
    }
}