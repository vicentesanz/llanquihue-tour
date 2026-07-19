package ui;

import data.GestorDatos;
import data.GestorEntidades;
import data.GestorServicios;
import model.Tour;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal del sistema Llanquihue Tour.
 */
public class Main {

    /**
     * Punto de inicio de la aplicación.
     *
     * @param args argumentos de ejecución
     */
    public static void main(String[] args) {

        GestorDatos gestorDatos = new GestorDatos();

        ArrayList<Tour> tours = gestorDatos.cargarTours(
                "resources/tours.txt"
        );

        mostrarTours(
                "LISTA DE TOURS",
                tours
        );

        ArrayList<Tour> toursGastronomicos =
                gestorDatos.buscarPorTipo(
                        tours,
                        "Gastronomico"
                );

        mostrarTours(
                "TOURS GASTRONÓMICOS",
                toursGastronomicos
        );

        System.out.println(
                "\n=============================="
        );
        System.out.println("SERVICIOS TURÍSTICOS");
        System.out.println(
                "=============================="
        );

        GestorServicios gestorServicios =
                new GestorServicios();

        gestorServicios.mostrarServicios();

        GestorEntidades gestorEntidades =
                new GestorEntidades();

        gestorEntidades.mostrarEntidades();

        VentanaRegistro ventanaRegistro =
                new VentanaRegistro();

        ventanaRegistro.iniciar();
    }

    /**
     * Muestra una colección de tours con un título.
     *
     * @param titulo título de la sección
     * @param tours tours que se desean mostrar
     */
    private static void mostrarTours(
            String titulo,
            List<Tour> tours
    ) {

        System.out.println("\n=== " + titulo + " ===");

        if (tours.isEmpty()) {
            System.out.println(
                    "No existen tours para mostrar."
            );
            return;
        }

        for (Tour tour : tours) {
            System.out.println(tour);
        }
    }
}