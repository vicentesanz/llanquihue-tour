package data;

import model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona una colección polimórfica de entidades registrables.
 */
public class GestorEntidades {

    private final ArrayList<Registrable> entidades;

    /**
     * Construye el gestor incluyendo datos iniciales.
     */
    public GestorEntidades() {
        this(true);
    }

    /**
     * Construye el gestor y permite decidir si carga datos iniciales.
     *
     * @param cargarDatosIniciales indica si se agregan datos de ejemplo
     */
    public GestorEntidades(boolean cargarDatosIniciales) {
        entidades = new ArrayList<>();

        if (cargarDatosIniciales) {
            cargarDatosIniciales();
        }
    }

    /**
     * Agrega los datos utilizados para demostrar el funcionamiento.
     */
    private void cargarDatosIniciales() {

        entidades.add(
                new GuiaTuristico(
                        "Carlos Vargas",
                        "Español",
                        5
                )
        );

        entidades.add(
                new ProveedorTransporte(
                        "TransLlanquihue",
                        "Van"
                )
        );

        entidades.add(
                new Cliente(
                        "12.345.678-5",
                        "Camila Torres",
                        new Direccion(
                                "Los Arrayanes",
                                245,
                                "Llanquihue"
                        ),
                        "+56912345678",
                        "camila.torres@email.cl"
                )
        );

        entidades.add(
                new RutaGastronomica(
                        "Ruta de Sabores",
                        4,
                        5
                )
        );
    }

    /**
     * Agrega una entidad a la colección.
     *
     * @param entidad entidad que se desea registrar
     */
    public void agregarEntidad(Registrable entidad) {
        if (entidad == null) {
            throw new IllegalArgumentException(
                    "La entidad no puede ser nula."
            );
        }

        entidades.add(entidad);
    }

    /**
     * Obtiene una copia de las entidades registradas.
     *
     * @return lista de entidades
     */
    public List<Registrable> obtenerEntidades() {
        return new ArrayList<>(entidades);
    }

    /**
     * Busca entidades de un tipo determinado.
     *
     * @param tipo clase utilizada para realizar el filtro
     * @return lista con las coincidencias encontradas
     */
    public List<Registrable> buscarPorTipo(Class<?> tipo) {

        ArrayList<Registrable> coincidencias = new ArrayList<>();

        for (Registrable entidad : entidades) {
            if (tipo.isInstance(entidad)) {
                coincidencias.add(entidad);
            }
        }

        return coincidencias;
    }

    /**
     * Muestra todas las entidades utilizando polimorfismo e instanceof.
     */
    public void mostrarEntidades() {

        System.out.println("\n=== ENTIDADES REGISTRADAS ===");

        for (Registrable entidad : entidades) {

            System.out.println(entidad.mostrarResumen());

            if (entidad instanceof GuiaTuristico) {
                System.out.println("-> Es un guía turístico");
            } else if (entidad instanceof Cliente) {
                System.out.println("-> Es un cliente");
            } else if (entidad instanceof ProveedorTransporte) {
                System.out.println("-> Es un proveedor de transporte");
            } else if (entidad instanceof ServicioTuristico) {
                System.out.println("-> Es un servicio turístico");
            }

            System.out.println();
        }
    }
}