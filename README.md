# LlanquihueTourApp

## Descripción

LlanquihueTourApp es una aplicación desarrollada en Java para la asignatura Desarrollo Orientado a Objetos I.

El sistema permite cargar información de tours turísticos desde un archivo de texto externo, almacenar los datos en una colección dinámica (`ArrayList`) y mostrar la información por consola. Además, incorpora búsquedas y filtros simples para facilitar la gestión de los registros.

En esta séptima semana el proyecto fue ampliado incorporando polimorfismo y colecciones genéricas. Los distintos servicios turísticos se almacenan en una colección de tipo `List<ServicioTuristico>`, permitiendo recorrerlos dinámicamente mediante referencias a la superclase e invocar métodos sobrescritos en cada subclase.

La aplicación utiliza principios de Programación Orientada a Objetos, incluyendo encapsulamiento, composición, herencia, polimorfismo, organización modular mediante paquetes, sobrescritura de métodos y manejo de excepciones.

---

# Paquetes Utilizados

## model

Contiene las clases que representan las entidades del sistema:

* ServicioTuristico
* RutaGastronomica
* PaseoLacustre
* ExcursionCultural
* Tour
* GuiaTuristico
* ProveedorTransporte

## data

Contiene las clases encargadas de la lectura y gestión de datos:

* GestorDatos
* GestorServicios

## ui

Contiene la interfaz de ejecución de la aplicación:

* Main

---

# Clases Implementadas

## ServicioTuristico

Clase base que representa un servicio turístico mediante atributos comunes como nombre y duración. Además, incorpora el método `mostrarInformacion()` que es sobrescrito por las subclases.

## RutaGastronomica

Subclase de ServicioTuristico que incorpora el número de paradas y sobrescribe el método `mostrarInformacion()`.

## PaseoLacustre

Subclase de ServicioTuristico que incorpora el tipo de embarcación y sobrescribe el método `mostrarInformacion()`.

## ExcursionCultural

Subclase de ServicioTuristico que incorpora el lugar histórico y sobrescribe el método `mostrarInformacion()`.

## Tour

Representa un tour turístico con información como nombre, tipo y precio.

## GuiaTuristico

Representa al guía asignado a un tour, incluyendo nombre, idioma y años de experiencia.

## ProveedorTransporte

Representa la empresa encargada del transporte y el tipo de vehículo utilizado.

## GestorDatos

Lee la información desde el archivo `tours.txt`, crea los objetos correspondientes y los almacena en una colección dinámica (`ArrayList`).

## GestorServicios

Gestiona una colección polimórfica de servicios turísticos utilizando `List<ServicioTuristico>`, crea instancias de las distintas subclases y muestra su información mediante el método `mostrarInformacion()`.

## Main

Clase principal encargada de ejecutar el sistema, mostrar los tours cargados desde el archivo y recorrer la colección polimórfica de servicios turísticos.

---

# Funcionalidades

* Lectura de datos desde archivo externo.
* Uso de colecciones (`ArrayList`).
* Creación de objetos a partir de los datos leídos.
* Visualización de información por consola.
* Filtrado de tours gastronómicos.
* Manejo básico de errores mediante `try-catch`.
* Aplicación de composición entre clases.
* Implementación de herencia simple.
* Uso de la palabra reservada `super()` en los constructores.
* Sobrescritura del método `toString()`.
* Creación de servicios turísticos de prueba.
* Uso de colecciones genéricas mediante `List<ServicioTuristico>`.
* Aplicación de polimorfismo utilizando el método `mostrarInformacion()`.

---

# Estructura del Proyecto

```text
LlanquihueTourApp
│
├── src
│   ├── data
│   │   ├── GestorDatos.java
│   │   └── GestorServicios.java
│   │
│   ├── model
│   │   ├── ServicioTuristico.java
│   │   ├── RutaGastronomica.java
│   │   ├── PaseoLacustre.java
│   │   ├── ExcursionCultural.java
│   │   ├── Tour.java
│   │   ├── GuiaTuristico.java
│   │   └── ProveedorTransporte.java
│   │
│   └── ui
│       └── Main.java
│
├── resources
│   └── tours.txt
│
└── README.md
```

---

# Instrucciones de Ejecución

1. Abrir el proyecto en IntelliJ IDEA o NetBeans.
2. Verificar que el archivo `tours.txt` se encuentre dentro de la carpeta `resources`.
3. Ejecutar la clase `Main` ubicada en el paquete `ui`.
4. El programa cargará la información desde el archivo de texto.
5. Se mostrará la lista completa de tours registrados.
6. Posteriormente se visualizarán los tours gastronómicos.
7. Finalmente se recorrerá una colección polimórfica de servicios turísticos mostrando la información específica de cada tipo mediante el método `mostrarInformacion()`.

---

# Tecnologías Utilizadas

* Java
* IntelliJ IDEA
* Git
* GitHub

---

# Autor

Vicente Sanz