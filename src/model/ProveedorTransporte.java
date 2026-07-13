package model;

/**
 * Representa una empresa de transporte asociada a un tour.
 */
public class ProveedorTransporte implements Registrable {

    private String empresa;
    private String tipoVehiculo;

    public ProveedorTransporte(String empresa, String tipoVehiculo) {
        this.empresa = empresa;
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    @Override
    public String mostrarResumen() {
        return "Proveedor: " + empresa +
                " | Vehículo: " + tipoVehiculo;
    }

    @Override
    public String toString() {
        return empresa + " | Vehículo: " + tipoVehiculo;
    }
}