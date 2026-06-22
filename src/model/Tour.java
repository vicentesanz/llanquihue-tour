package model;

/**
 * Clase que representa un tour turístico.
 */
public class Tour {

    private String nombre;
    private String tipo;
    private int precio;

    private GuiaTuristico guia;
    private ProveedorTransporte transporte;

    public Tour(String nombre, String tipo, int precio,
                GuiaTuristico guia,
                ProveedorTransporte transporte) {

        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.guia = guia;
        this.transporte = transporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        if (precio > 0) {
            this.precio = precio;
        } else {
            System.out.println("El precio debe ser mayor que cero.");
        }
    }

    public GuiaTuristico getGuia() {
        return guia;
    }

    public ProveedorTransporte getTransporte() {
        return transporte;
    }

    @Override
    public String toString() {
        return "Tour: " + nombre +
                " | Tipo: " + tipo +
                " | Precio: $" + precio +
                " | Guia: " + guia +
                " | Transporte: " + transporte;
    }
}