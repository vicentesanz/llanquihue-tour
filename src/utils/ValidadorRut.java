package utils;

import exception.RutInvalidoException;

/**
 * Clase utilitaria encargada de validar RUT chilenos.
 */
public final class ValidadorRut {

    /**
     * Evita crear objetos de esta clase utilitaria.
     */
    private ValidadorRut() {
    }

    /**
     * Valida un RUT utilizando el cálculo del dígito verificador.
     *
     * @param rut RUT ingresado por el usuario
     * @return RUT normalizado sin puntos y con guion
     * @throws RutInvalidoException si el RUT está vacío o no es válido
     */
    public static String validar(String rut) {

        if (rut == null || rut.isBlank()) {
            throw new RutInvalidoException("El RUT no puede estar vacío.");
        }

        String rutLimpio = rut.replace(".", "")
                .replace("-", "")
                .trim()
                .toUpperCase();

        if (!rutLimpio.matches("\\d{7,8}[0-9K]")) {
            throw new RutInvalidoException("El formato del RUT no es válido.");
        }

        String cuerpo = rutLimpio.substring(0, rutLimpio.length() - 1);
        char digitoIngresado = rutLimpio.charAt(rutLimpio.length() - 1);

        int suma = 0;
        int multiplicador = 2;

        for (int i = cuerpo.length() - 1; i >= 0; i--) {
            suma += Character.getNumericValue(cuerpo.charAt(i))
                    * multiplicador;

            multiplicador++;

            if (multiplicador > 7) {
                multiplicador = 2;
            }
        }

        int resultado = 11 - (suma % 11);
        char digitoCalculado;

        if (resultado == 11) {
            digitoCalculado = '0';
        } else if (resultado == 10) {
            digitoCalculado = 'K';
        } else {
            digitoCalculado = Character.forDigit(resultado, 10);
        }

        if (digitoIngresado != digitoCalculado) {
            throw new RutInvalidoException(
                    "El dígito verificador del RUT es incorrecto."
            );
        }

        return cuerpo + "-" + digitoCalculado;
    }
}