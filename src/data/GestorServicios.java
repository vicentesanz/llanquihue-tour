package data;

import model.ExcursionCultural;
import model.PaseoLacustre;
import model.RutaGastronomica;
import model.ServicioTuristico;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona una colección polimórfica de servicios turísticos.
 */
public class GestorServicios {

    private final List<ServicioTuristico> servicios;

    /**
     * Construye el gestor y carga servicios de prueba.
     */
    public GestorServicios() {
        servicios = new ArrayList<>();
        cargarServiciosIniciales();
    }

    /**
     * Carga los servicios turísticos utilizados como demostración.
     */
    private void cargarServiciosIniciales() {

        agregarServicio(
                new RutaGastronomica(
                        "Ruta de Sabores",
                        4,
                        5
                )
        );

        agregarServicio(
                new RutaGastronomica(
                        "Ruta del Chocolate",
                        3,
                        4
                )
        );

        agregarServicio(
                new PaseoLacustre(
                        "Paseo Lago Llanquihue",
                        2,
                        "Catamarán"
                )
        );

        agregarServicio(
                new PaseoLacustre(
                        "Paseo Río Maullín",
                        3,
                        "Lancha"
                )
        );

        agregarServicio(
                new ExcursionCultural(
                        "Museo Colonial",
                        2,
                        "Fuerte San Antonio"
                )
        );

        agregarServicio(
                new ExcursionCultural(
                        "Centro Histórico",
                        5,
                        "Iglesia Patrimonial"
                )
        );
    }

    /**
     * Agrega un servicio a la colección.
     *
     * @param servicio servicio que se desea agregar
     */
    public void agregarServicio(
            ServicioTuristico servicio
    ) {
        if (servicio == null) {
            throw new IllegalArgumentException(
                    "El servicio no puede ser nulo."
            );
        }

        servicios.add(servicio);
    }

    /**
     * Obtiene una copia de los servicios almacenados.
     *
     * @return lista de servicios turísticos
     */
    public List<ServicioTuristico> obtenerServicios() {
        return new ArrayList<>(servicios);
    }

    /**
     * Recorre y muestra los servicios utilizando polimorfismo.
     */
    public void mostrarServicios() {

        System.out.println(
                "=== SERVICIOS TURÍSTICOS ==="
        );

        for (ServicioTuristico servicio : servicios) {
            servicio.mostrarInformacion();
        }
    }
}