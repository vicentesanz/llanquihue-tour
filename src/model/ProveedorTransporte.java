package model;

/**
 * Representa una empresa de transporte asociada a la agencia.
 */
public class ProveedorTransporte implements Registrable {

    private String empresa;
    private String tipoVehiculo;

    /**
     * Construye un proveedor de transporte.
     *
     * @param empresa nombre de la empresa
     * @param tipoVehiculo tipo de vehículo utilizado
     */
    public ProveedorTransporte(
            String empresa,
            String tipoVehiculo
    ) {
        setEmpresa(empresa);
        setTipoVehiculo(tipoVehiculo);
    }

    /**
     * Obtiene el nombre de la empresa.
     *
     * @return empresa registrada
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Modifica el nombre de la empresa.
     *
     * @param empresa nueva empresa
     */
    public void setEmpresa(String empresa) {
        if (empresa == null || empresa.isBlank()) {
            throw new IllegalArgumentException(
                    "El nombre de la empresa no puede estar vacío."
            );
        }

        this.empresa = empresa.trim();
    }

    /**
     * Obtiene el tipo de vehículo.
     *
     * @return tipo de vehículo registrado
     */
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    /**
     * Modifica el tipo de vehículo.
     *
     * @param tipoVehiculo nuevo tipo de vehículo
     */
    public void setTipoVehiculo(String tipoVehiculo) {
        if (tipoVehiculo == null || tipoVehiculo.isBlank()) {
            throw new IllegalArgumentException(
                    "El tipo de vehículo no puede estar vacío."
            );
        }

        this.tipoVehiculo = tipoVehiculo.trim();
    }

    /**
     * Muestra un resumen del proveedor.
     *
     * @return resumen de sus datos
     */
    @Override
    public String mostrarResumen() {
        return "Proveedor: " + empresa
                + " | Vehículo: " + tipoVehiculo;
    }

    /**
     * Entrega todos los datos del proveedor.
     *
     * @return datos formateados
     */
    @Override
    public String toString() {
        return empresa + " | Vehículo: " + tipoVehiculo;
    }
}