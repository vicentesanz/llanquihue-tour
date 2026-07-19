package data;

import model.GuiaTuristico;
import model.ProveedorTransporte;
import model.Tour;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona la lectura, conversión, búsqueda y filtrado de tours.
 */
public class GestorDatos {

    private static final int CANTIDAD_COLUMNAS = 8;

    /**
     * Carga tours desde un archivo de texto.
     *
     * @param rutaArchivo ruta del archivo que se desea leer
     * @return colección con los tours válidos
     */
    public ArrayList<Tour> cargarTours(String rutaArchivo) {

        if (rutaArchivo == null || rutaArchivo.isBlank()) {
            throw new IllegalArgumentException(
                    "La ruta del archivo no puede estar vacía."
            );
        }

        ArrayList<Tour> tours = new ArrayList<>();
        int numeroLinea = 0;

        try (BufferedReader lector =
                     new BufferedReader(
                             new FileReader(rutaArchivo)
                     )) {

            String linea;

            while ((linea = lector.readLine()) != null) {
                numeroLinea++;

                if (linea.isBlank()) {
                    continue;
                }

                try {
                    Tour tour = convertirLineaEnTour(linea);
                    tours.add(tour);

                } catch (IllegalArgumentException e) {
                    System.out.println(
                            "Error en la línea "
                                    + numeroLinea + ": "
                                    + e.getMessage()
                    );
                }
            }

        } catch (IOException e) {
            System.out.println(
                    "No fue posible leer el archivo: "
                            + e.getMessage()
            );
        }

        return tours;
    }

    /**
     * Convierte una línea del archivo en un objeto Tour.
     *
     * @param linea línea que se desea convertir
     * @return tour construido con los datos de la línea
     */
    private Tour convertirLineaEnTour(String linea) {

        String[] datos = linea.split(";", -1);

        if (datos.length != CANTIDAD_COLUMNAS) {
            throw new IllegalArgumentException(
                    "La línea debe contener "
                            + CANTIDAD_COLUMNAS
                            + " datos separados por punto y coma."
            );
        }

        String nombre = datos[0].trim();
        String tipo = datos[1].trim();

        int precio;
        int experiencia;

        try {
            precio = Integer.parseInt(datos[2].trim());
            experiencia = Integer.parseInt(datos[5].trim());

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "El precio y la experiencia deben ser números enteros."
            );
        }

        GuiaTuristico guia = new GuiaTuristico(
                datos[3].trim(),
                datos[4].trim(),
                experiencia
        );

        ProveedorTransporte transporte =
                new ProveedorTransporte(
                        datos[6].trim(),
                        datos[7].trim()
                );

        return new Tour(
                nombre,
                tipo,
                precio,
                guia,
                transporte
        );
    }

    /**
     * Filtra tours según su categoría.
     *
     * @param tours colección que se desea filtrar
     * @param tipo categoría buscada
     * @return colección con los tours encontrados
     */
    public ArrayList<Tour> buscarPorTipo(
            List<Tour> tours,
            String tipo
    ) {

        if (tours == null) {
            throw new IllegalArgumentException(
                    "La colección de tours no puede ser nula."
            );
        }

        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException(
                    "El tipo de tour no puede estar vacío."
            );
        }

        ArrayList<Tour> resultados = new ArrayList<>();

        for (Tour tour : tours) {
            if (tour.getTipo().equalsIgnoreCase(tipo.trim())) {
                resultados.add(tour);
            }
        }

        return resultados;
    }
}