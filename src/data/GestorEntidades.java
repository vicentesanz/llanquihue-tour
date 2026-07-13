package data;

import model.*;

import java.util.ArrayList;

public class GestorEntidades {

    private ArrayList<Registrable> entidades;

    public GestorEntidades() {

        entidades = new ArrayList<>();

        entidades.add(new GuiaTuristico("Carlos Vargas", "Español", 5));
        entidades.add(new ProveedorTransporte("TransLlanquihue", "Van"));
        entidades.add(new RutaGastronomica("Ruta de Sabores", 4, 5));

    }

    public void mostrarEntidades() {

        System.out.println("\n=== ENTIDADES REGISTRADAS ===");

        for (Registrable entidad : entidades) {

            entidad.mostrarResumen();

            if (entidad instanceof GuiaTuristico) {
                System.out.println("-> Es un guía turístico");
            } else if (entidad instanceof ProveedorTransporte) {
                System.out.println("-> Es un proveedor de transporte");
            } else if (entidad instanceof RutaGastronomica) {
                System.out.println("-> Es un servicio turístico");
            }

            System.out.println();
        }
    }
}