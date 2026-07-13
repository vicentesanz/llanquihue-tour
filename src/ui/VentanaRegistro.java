package ui;

import model.GuiaTuristico;
import model.ProveedorTransporte;
import model.Registrable;

import javax.swing.*;
import java.util.ArrayList;

public class VentanaRegistro {

    private final ArrayList<Registrable> entidades;

    public VentanaRegistro() {
        entidades = new ArrayList<>();
    }

    public void iniciar() {

        int opcion;

        do {
            String menu = """
                    === LLANQUIHUE TOUR ===
                    1. Registrar guía turístico
                    2. Registrar proveedor de transporte
                    3. Mostrar entidades registradas
                    0. Salir
                    """;

            String entrada = JOptionPane.showInputDialog(menu);

            if (entrada == null) {
                opcion = 0;
            } else {
                try {
                    opcion = Integer.parseInt(entrada);

                    switch (opcion) {
                        case 1 -> registrarGuia();
                        case 2 -> registrarProveedor();
                        case 3 -> mostrarEntidades();
                        case 0 -> JOptionPane.showMessageDialog(
                                null,
                                "Programa finalizado."
                        );
                        default -> JOptionPane.showMessageDialog(
                                null,
                                "Opción inválida."
                        );
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Debes ingresar un número válido."
                    );
                    opcion = -1;
                }
            }

        } while (opcion != 0);
    }

    private void registrarGuia() {

        String nombre = JOptionPane.showInputDialog("Nombre del guía:");
        String idioma = JOptionPane.showInputDialog("Idioma del guía:");
        String experienciaTexto = JOptionPane.showInputDialog(
                "Años de experiencia:"
        );

        try {
            int experiencia = Integer.parseInt(experienciaTexto);

            GuiaTuristico guia = new GuiaTuristico(
                    nombre,
                    idioma,
                    experiencia
            );

            entidades.add(guia);

            JOptionPane.showMessageDialog(
                    null,
                    "Guía turístico registrado correctamente."
            );

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "La experiencia debe ser un número válido."
            );
        }
    }

    private void registrarProveedor() {

        String empresa = JOptionPane.showInputDialog(
                "Nombre de la empresa:"
        );

        String tipoVehiculo = JOptionPane.showInputDialog(
                "Tipo de vehículo:"
        );

        ProveedorTransporte proveedor = new ProveedorTransporte(
                empresa,
                tipoVehiculo
        );

        entidades.add(proveedor);

        JOptionPane.showMessageDialog(
                null,
                "Proveedor registrado correctamente."
        );
    }

    private void mostrarEntidades() {

        if (entidades.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "No existen entidades registradas."
            );
            return;
        }

        StringBuilder resumen = new StringBuilder(
                "=== ENTIDADES REGISTRADAS ===\n\n"
        );

        for (Registrable entidad : entidades) {
            resumen.append(entidad.mostrarResumen())
                    .append("\n");
        }

        JOptionPane.showMessageDialog(
                null,
                resumen.toString()
        );
    }
}