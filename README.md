# LlanquihueTourApp

## Descripción

LlanquihueTourApp es una aplicación desarrollada en Java para la asignatura Desarrollo Orientado a Objetos I.

El sistema permite cargar información de tours turísticos desde un archivo de texto externo, almacenar los datos en una colección dinámica (`ArrayList`) y mostrar la información por consola. Además, incorpora búsquedas y filtros simples para facilitar la gestión de los registros.

La aplicación utiliza principios de Programación Orientada a Objetos, incluyendo encapsulamiento, composición, organización modular mediante paquetes y manejo de excepciones.

---

## Paquetes Utilizados

### model

Contiene las clases que representan las entidades del sistema:

* Tour
* GuiaTuristico
* ProveedorTransporte

### data

Contiene las clases encargadas de la lectura y carga de datos:

* GestorDatos

### ui

Contiene la interfaz de ejecución de la aplicación:

* Main

---

## Clases Implementadas

### Tour

Representa un tour turístico con información como nombre, tipo y precio.

### GuiaTuristico

Representa al guía asignado a un tour, incluyendo nombre, idioma y años de experiencia.

### ProveedorTransporte

Representa la empresa encargada del transporte y el tipo de vehículo utilizado.

### GestorDatos

Lee la información desde el archivo `tours.txt`, crea los objetos correspondientes y los almacena en una colección dinámica.

### Main

Clase principal encargada de ejecutar el sistema, mostrar los tours cargados y aplicar filtros de búsqueda.

---

## Funcionalidades

* Lectura de datos desde archivo externo.
* Uso de colecciones (`ArrayList`).
* Creación de objetos a partir de los datos leídos.
* Visualización de información por consola.
* Filtrado de tours gastronómicos.
* Manejo básico de errores mediante `try-catch`.
* Aplicación de composición entre clases.

---

## Estructura del Proyecto

LlanquihueTourApp

├── src

│   ├── data

│   │   └── GestorDatos.java

│   ├── model

│   │   ├── Tour.java

│   │   ├── GuiaTuristico.java

│   │   └── ProveedorTransporte.java

│   └── ui

│       └── Main.java

├── resources

│   └── tours.txt

└── README.md

---

## Instrucciones de Ejecución

1. Abrir el proyecto en IntelliJ IDEA.
2. Verificar que el archivo `tours.txt` se encuentre dentro de la carpeta `resources`.
3. Ejecutar la clase `Main` ubicada en el paquete `ui`.
4. El programa cargará los datos desde el archivo.
5. Se mostrará la lista completa de tours registrados.
6. Posteriormente se visualizarán los tours gastronómicos filtrados.

---

## Autor

Vicente Sanz
