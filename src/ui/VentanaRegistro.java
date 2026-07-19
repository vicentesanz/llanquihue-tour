package ui;

import data.GestorEntidades;
import model.Cliente;
import model.Direccion;
import model.GuiaTuristico;
import model.ProveedorTransporte;
import model.Registrable;
import utils.ValidadorRut;

import javax.swing.*;
import java.util.List;

/**
 * Interfaz gráfica para registrar, mostrar y filtrar entidades.
 */
public class VentanaRegistro {

    private final GestorEntidades gestorEntidades;

    /**
     * Construye la ventana con un gestor inicialmente vacío.
     */
    public VentanaRegistro() {
        gestorEntidades = new GestorEntidades(false);
    }

    /**
     * Inicia el menú principal de la aplicación.
     */
    public void iniciar() {

        int opcion;

        do {
            String menu = """
                    === LLANQUIHUE TOUR ===
                    1. Registrar guía turístico
                    2. Registrar proveedor de transporte
                    3. Registrar cliente
                    4. Mostrar entidades registradas
                    5. Filtrar entidades por tipo
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
                        case 3 -> registrarCliente();
                        case 4 -> mostrarEntidades();
                        case 5 -> filtrarEntidades();
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
                            "Debes ingresar una opción numérica."
                    );
                    opcion = -1;
                }
            }

        } while (opcion != 0);
    }

    /**
     * Registra un guía turístico con RUT y dirección.
     */
    private void registrarGuia() {

        String rut = solicitarRut("RUT del guía:");
        if (rut == null) {
            return;
        }

        String nombre = solicitarTexto("Nombre del guía:");
        if (nombre == null) {
            return;
        }

        Direccion direccion = solicitarDireccion();
        if (direccion == null) {
            return;
        }

        String idioma = solicitarTexto("Idioma del guía:");
        if (idioma == null) {
            return;
        }

        Integer experiencia = solicitarEntero(
                "Años de experiencia:",
                0
        );

        if (experiencia == null) {
            return;
        }

        try {
            GuiaTuristico guia = new GuiaTuristico(
                    rut,
                    nombre,
                    direccion,
                    idioma,
                    experiencia
            );

            gestorEntidades.agregarEntidad(guia);

            JOptionPane.showMessageDialog(
                    null,
                    "Guía turístico registrado correctamente."
            );

        } catch (IllegalArgumentException e) {
            mostrarError(e.getMessage());
        }
    }

    /**
     * Registra un proveedor de transporte.
     */
    private void registrarProveedor() {

        String empresa = solicitarTexto(
                "Nombre de la empresa:"
        );

        if (empresa == null) {
            return;
        }

        String tipoVehiculo = solicitarTexto(
                "Tipo de vehículo:"
        );

        if (tipoVehiculo == null) {
            return;
        }

        try {
            ProveedorTransporte proveedor =
                    new ProveedorTransporte(
                            empresa,
                            tipoVehiculo
                    );

            gestorEntidades.agregarEntidad(proveedor);

            JOptionPane.showMessageDialog(
                    null,
                    "Proveedor registrado correctamente."
            );

        } catch (IllegalArgumentException e) {
            mostrarError(e.getMessage());
        }
    }

    /**
     * Registra un cliente con sus datos personales.
     */
    private void registrarCliente() {

        String rut = solicitarRut("RUT del cliente:");
        if (rut == null) {
            return;
        }

        String nombre = solicitarTexto("Nombre del cliente:");
        if (nombre == null) {
            return;
        }

        Direccion direccion = solicitarDireccion();
        if (direccion == null) {
            return;
        }

        String telefono = solicitarTexto(
                "Teléfono del cliente:"
        );

        if (telefono == null) {
            return;
        }

        String correo = solicitarCorreo();

        if (correo == null) {
            return;
        }

        try {
            Cliente cliente = new Cliente(
                    rut,
                    nombre,
                    direccion,
                    telefono,
                    correo
            );

            gestorEntidades.agregarEntidad(cliente);

            JOptionPane.showMessageDialog(
                    null,
                    "Cliente registrado correctamente."
            );

        } catch (IllegalArgumentException e) {
            mostrarError(e.getMessage());
        }
    }

    /**
     * Solicita los datos necesarios para construir una dirección.
     *
     * @return dirección ingresada o null si se cancela
     */
    private Direccion solicitarDireccion() {

        String calle = solicitarTexto("Calle:");
        if (calle == null) {
            return null;
        }

        Integer numero = solicitarEntero(
                "Número de la dirección:",
                1
        );

        if (numero == null) {
            return null;
        }

        String comuna = solicitarTexto("Comuna:");
        if (comuna == null) {
            return null;
        }

        return new Direccion(calle, numero, comuna);
    }

    /**
     * Solicita un RUT hasta que sea válido.
     *
     * @param mensaje mensaje mostrado al usuario
     * @return RUT validado o null si se cancela
     */
    private String solicitarRut(String mensaje) {

        while (true) {
            String rut = solicitarTexto(mensaje);

            if (rut == null) {
                return null;
            }

            try {
                return ValidadorRut.validar(rut);

            } catch (IllegalArgumentException e) {
                mostrarError(
                        e.getMessage()
                                + " Inténtalo nuevamente."
                );
            }
        }
    }

    /**
     * Solicita un texto obligatorio y controla campos vacíos.
     *
     * @param mensaje mensaje mostrado al usuario
     * @return texto válido o null si se cancela
     */
    private String solicitarTexto(String mensaje) {

        while (true) {
            String entrada = JOptionPane.showInputDialog(
                    mensaje
            );

            if (entrada == null) {
                return null;
            }

            if (!entrada.isBlank()) {
                return entrada.trim();
            }

            mostrarError("El campo no puede estar vacío.");
        }
    }

    /**
     * Solicita un correo hasta que su formato sea válido.
     *
     * @return correo válido o null si se cancela
     */
    private String solicitarCorreo() {

        while (true) {
            String correo = solicitarTexto(
                    "Correo electrónico del cliente:"
            );

            if (correo == null) {
                return null;
            }

            int posicionArroba = correo.indexOf('@');
            int posicionPunto = correo.lastIndexOf('.');

            boolean formatoValido =
                    posicionArroba > 0
                            && posicionPunto > posicionArroba + 1
                            && posicionPunto < correo.length() - 1;

            if (formatoValido) {
                return correo;
            }

            mostrarError(
                    "El correo electrónico no es válido. "
                            + "Inténtalo nuevamente."
            );
        }
    }

    /**
     * Solicita un número entero igual o superior al mínimo.
     *
     * @param mensaje mensaje mostrado al usuario
     * @param minimo valor mínimo permitido
     * @return número válido o null si se cancela
     */
    private Integer solicitarEntero(
            String mensaje,
            int minimo
    ) {

        while (true) {
            String entrada = JOptionPane.showInputDialog(
                    mensaje
            );

            if (entrada == null) {
                return null;
            }

            try {
                int numero = Integer.parseInt(entrada);

                if (numero >= minimo) {
                    return numero;
                }

                mostrarError(
                        "El número debe ser igual o mayor que "
                                + minimo + "."
                );

            } catch (NumberFormatException e) {
                mostrarError(
                        "Debes ingresar un número entero válido."
                );
            }
        }
    }

    /**
     * Muestra todas las entidades registradas.
     */
    private void mostrarEntidades() {
        mostrarEntidades(
                gestorEntidades.obtenerEntidades(),
                "ENTIDADES REGISTRADAS"
        );
    }

    /**
     * Muestra una lista de entidades. Este método demuestra sobrecarga.
     *
     * @param entidades entidades que se mostrarán
     * @param titulo título de la ventana
     */
    private void mostrarEntidades(
            List<Registrable> entidades,
            String titulo
    ) {

        if (entidades.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "No existen entidades para mostrar."
            );
            return;
        }

        StringBuilder resumen = new StringBuilder(
                "=== " + titulo + " ===\n\n"
        );

        for (Registrable entidad : entidades) {
            resumen.append(entidad.mostrarResumen())
                    .append("\n\n");
        }

        JOptionPane.showMessageDialog(
                null,
                resumen.toString()
        );
    }

    /**
     * Filtra las entidades según el tipo seleccionado.
     */
    private void filtrarEntidades() {

        String[] opciones = {
                "Guías turísticos",
                "Clientes",
                "Proveedores de transporte"
        };

        String seleccion = (String)
                JOptionPane.showInputDialog(
                        null,
                        "Selecciona el tipo de entidad:",
                        "Filtrar entidades",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opciones,
                        opciones[0]
                );

        if (seleccion == null) {
            return;
        }

        Class<?> tipo;

        switch (seleccion) {
            case "Guías turísticos" ->
                    tipo = GuiaTuristico.class;
            case "Clientes" ->
                    tipo = Cliente.class;
            default ->
                    tipo = ProveedorTransporte.class;
        }

        List<Registrable> resultados =
                gestorEntidades.buscarPorTipo(tipo);

        mostrarEntidades(
                resultados,
                seleccion.toUpperCase()
        );
    }

    /**
     * Muestra un mensaje de error.
     *
     * @param mensaje descripción del error
     */
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(
                null,
                mensaje,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}