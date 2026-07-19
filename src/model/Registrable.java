package model;

/**
 * Define el comportamiento común de todas las entidades
 * que pueden almacenarse en una colección registrable.
 */
public interface Registrable {

    /**
     * Entrega un resumen de la información del objeto.
     *
     * @return resumen de los datos de la entidad
     */
    String mostrarResumen();
}