package ui;

import data.GestorDatos;
import data.GestorEntidades;
import data.GestorServicios;
import model.Tour;

import java.util.ArrayList;

/**
 * Clase principal del programa.
 */
public class Main {

    public static void main(String[] args) {

        // Funcionalidad de la semana anterior
        GestorDatos gestor = new GestorDatos();

        ArrayList<Tour> tours = gestor.cargarTours("resources/tours.txt");

        System.out.println("=== LISTA DE TOURS ===");

        for (Tour tour : tours) {
            System.out.println(tour);
        }

        System.out.println("\n=== TOURS GASTRONÓMICOS ===");

        for (Tour tour : tours) {
            if (tour.getTipo().equalsIgnoreCase("gastronomico")) {
                System.out.println(tour);
            }
        }

        // Funcionalidad de la Semana 7
        System.out.println("\n==============================");
        System.out.println("SERVICIOS TURÍSTICOS");
        System.out.println("==============================");

        GestorServicios gestorServicios = new GestorServicios();
        gestorServicios.mostrarServicios();

        // Funcionalidad de la Semana 8
        GestorEntidades gestorEntidades = new GestorEntidades();
        gestorEntidades.mostrarEntidades();
    }
}