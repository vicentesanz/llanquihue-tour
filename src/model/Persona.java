package model;

import utils.ValidadorRut;

/**
 * Clase base que representa a una persona relacionada con la agencia.
 */
public abstract class Persona implements Registrable {

    private String rut;
    private String nombre;
    private Direccion direccion;

    /**
     * Construye una persona con todos sus datos.
     *
     * @param rut RUT de la persona
     * @param nombre nombre completo
     * @param direccion dirección de la persona
     */
    public Persona(String rut, String nombre, Direccion direccion) {
        setRut(rut);
        setNombre(nombre);
        setDireccion(direccion);
    }

    /**
     * Constructor sobrecargado para registros antiguos que solo poseen nombre.
     *
     * @param nombre nombre completo de la persona
     */
    public Persona(String nombre) {
        setNombre(nombre);
        this.rut = "No informado";
        this.direccion = null;
    }

    /**
     * Obtiene el RUT.
     *
     * @return RUT de la persona
     */
    public String getRut() {
        return rut;
    }

    /**
     * Modifica el RUT después de validarlo.
     *
     * @param rut nuevo RUT
     */
    public void setRut(String rut) {
        this.rut = ValidadorRut.validar(rut);
    }

    /**
     * Obtiene el nombre.
     *
     * @return nombre completo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre, evitando valores vacíos.
     *
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacío."
            );
        }

        this.nombre = nombre.trim();
    }

    /**
     * Obtiene la dirección.
     *
     * @return dirección registrada
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Modifica la dirección.
     *
     * @param direccion nueva dirección
     */
    public void setDireccion(Direccion direccion) {
        if (direccion == null) {
            throw new IllegalArgumentException(
                    "La dirección no puede ser nula."
            );
        }

        this.direccion = direccion;
    }

    /**
     * Entrega los datos generales de la persona.
     *
     * @return datos formateados
     */
    @Override
    public String toString() {
        String datos = "RUT: " + rut + " | Nombre: " + nombre;

        if (direccion != null) {
            datos += " | Dirección: " + direccion;
        }

        return datos;
    }
}