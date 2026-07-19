# Llanquihue Tour App

## Evaluación Final Transversal

Proyecto desarrollado en Java para la asignatura **Desarrollo Orientado a Objetos I**.

Llanquihue Tour App es un prototipo modular que permite gestionar tours, servicios turísticos y distintas entidades relacionadas con una agencia de turismo de la Región de Los Lagos.

El sistema aplica encapsulamiento, abstracción, composición, herencia, polimorfismo, interfaces, colecciones genéricas, archivos externos, excepciones y validaciones de datos.

---

## Problema abordado

Llanquihue Tour realiza parte de sus procesos de manera manual, lo que puede provocar información duplicada, errores de registro y dificultades para administrar clientes, guías, proveedores y servicios turísticos.

Este prototipo entrega una base técnica reutilizable y extensible para digitalizar progresivamente estas operaciones.

---

## Funcionalidades

- Carga de tours desde el archivo externo `resources/tours.txt`.
- Conversión de líneas de texto en objetos Java.
- Control de líneas vacías, incompletas o con datos incorrectos.
- Visualización de todos los tours disponibles.
- Búsqueda y filtrado de tours por categoría.
- Gestión de una colección polimórfica de servicios turísticos.
- Registro de guías turísticos.
- Registro de proveedores de transporte.
- Registro de clientes.
- Visualización de entidades registradas.
- Filtrado de entidades según su tipo.
- Validación de RUT chileno y dígito verificador.
- Validación de correos electrónicos.
- Control de campos vacíos.
- Control de números inválidos, negativos o iguales a cero.
- Manejo de cancelaciones y opciones no numéricas.
- Interfaz gráfica desarrollada con `JOptionPane`.

---

## Principios de Programación Orientada a Objetos

### Encapsulamiento

Los atributos de las clases se declaran como `private` y se administran mediante constructores, getters y setters.

Los setters realizan validaciones para evitar nombres vacíos, precios incorrectos, duraciones negativas y objetos nulos.

### Abstracción

Las clases `Persona` y `ServicioTuristico` son abstractas y representan características comunes que son especializadas por sus subclases.

### Herencia

El proyecto contiene dos jerarquías principales:

```text
Persona
├── GuiaTuristico
└── Cliente
```

```text
ServicioTuristico
├── RutaGastronomica
├── PaseoLacustre
└── ExcursionCultural
```

### Polimorfismo

Los servicios se almacenan en una colección `List<ServicioTuristico>` y las entidades en una colección `ArrayList<Registrable>`.

Al recorrer estas colecciones se ejecutan los métodos sobrescritos correspondientes al tipo real de cada objeto.

### Composición

- `Persona` contiene un objeto `Direccion`.
- `Tour` contiene un objeto `GuiaTuristico`.
- `Tour` contiene un objeto `ProveedorTransporte`.

### Interfaces

La interfaz `Registrable` define el método común `mostrarResumen()`.

Es implementada directa o indirectamente por:

- `Cliente`
- `GuiaTuristico`
- `ProveedorTransporte`
- `ServicioTuristico`
- `RutaGastronomica`
- `PaseoLacustre`
- `ExcursionCultural`

### Sobrescritura

Las subclases sobrescriben métodos como:

- `mostrarResumen()`
- `mostrarInformacion()`
- `toString()`

### Sobrecarga

El sistema utiliza constructores y métodos sobrecargados, por ejemplo:

- Constructores de `Persona`.
- Constructores de `GuiaTuristico`.
- Constructores de `GestorEntidades`.
- Métodos `mostrarEntidades()` de `VentanaRegistro`.

---

## Colecciones utilizadas

El proyecto utiliza `ArrayList` y `List` para almacenar y gestionar objetos.

### Colección de tours

```java
ArrayList<Tour>
```

Permite cargar, recorrer y filtrar los tours obtenidos desde el archivo de texto.

### Colección de servicios

```java
List<ServicioTuristico>
```

Almacena distintos tipos de servicios dentro de una misma colección polimórfica.

### Colección de entidades

```java
ArrayList<Registrable>
```

Almacena clientes, guías, proveedores y servicios utilizando una interfaz común.

El operador `instanceof` permite identificar el tipo concreto de las entidades almacenadas.

---

## Validaciones y excepciones

El sistema controla:

- RUT vacío.
- Formato incorrecto del RUT.
- Dígito verificador incorrecto.
- Correos electrónicos inválidos.
- Campos vacíos.
- Opciones no numéricas.
- Números negativos.
- Precios iguales o menores que cero.
- Duraciones iguales o menores que cero.
- Objetos nulos.
- Líneas incompletas en el archivo.
- Columnas numéricas con texto.
- Archivos inexistentes o inaccesibles.

La clase `RutInvalidoException` representa una excepción personalizada utilizada por `ValidadorRut`.

---

## Estructura del proyecto

```text
LlanquihueTourApp
├── resources
│   └── tours.txt
├── src
│   ├── data
│   │   ├── GestorDatos.java
│   │   ├── GestorEntidades.java
│   │   └── GestorServicios.java
│   ├── exception
│   │   └── RutInvalidoException.java
│   ├── model
│   │   ├── Cliente.java
│   │   ├── Direccion.java
│   │   ├── ExcursionCultural.java
│   │   ├── GuiaTuristico.java
│   │   ├── PaseoLacustre.java
│   │   ├── Persona.java
│   │   ├── ProveedorTransporte.java
│   │   ├── Registrable.java
│   │   ├── RutaGastronomica.java
│   │   ├── ServicioTuristico.java
│   │   └── Tour.java
│   ├── ui
│   │   ├── Main.java
│   │   └── VentanaRegistro.java
│   └── utils
│       └── ValidadorRut.java
├── .gitignore
└── README.md
```

---

## Descripción de los paquetes

### `model`

Contiene las entidades, jerarquías, atributos, constructores, validaciones y relaciones de composición del sistema.

### `data`

Contiene las clases responsables de leer archivos y gestionar las colecciones de tours, servicios y entidades.

### `ui`

Contiene la clase principal y la interfaz gráfica basada en `JOptionPane`.

### `utils`

Contiene herramientas reutilizables, como la validación de RUT.

### `exception`

Contiene las excepciones personalizadas del proyecto.

### `resources`

Contiene el archivo externo con los tours utilizados por la aplicación.

---

## Clases principales

### `Persona`

Superclase abstracta de las personas vinculadas con la agencia. Contiene RUT, nombre y dirección.

### `Cliente`

Representa un cliente e incorpora teléfono y correo electrónico.

### `GuiaTuristico`

Representa un guía e incorpora idioma y años de experiencia.

### `Direccion`

Representa la calle, número y comuna de una persona.

### `Tour`

Representa un tour con nombre, categoría, precio, guía y proveedor de transporte.

### `ProveedorTransporte`

Representa una empresa y el tipo de vehículo que utiliza.

### `ServicioTuristico`

Superclase abstracta de los distintos servicios turísticos.

### `RutaGastronomica`

Especializa un servicio mediante su cantidad de paradas.

### `PaseoLacustre`

Especializa un servicio mediante el tipo de embarcación.

### `ExcursionCultural`

Especializa un servicio mediante el lugar histórico visitado.

### `GestorDatos`

Lee `tours.txt`, convierte sus líneas en objetos y permite filtrar tours.

### `GestorEntidades`

Agrega, obtiene, recorre y filtra objetos `Registrable`.

### `GestorServicios`

Gestiona la colección polimórfica de servicios turísticos.

### `VentanaRegistro`

Permite registrar, mostrar y filtrar entidades mediante una interfaz gráfica.

### `ValidadorRut`

Calcula y valida el dígito verificador de un RUT chileno.

---

## Formato de `tours.txt`

Cada línea contiene ocho datos separados por punto y coma:

```text
nombre;tipo;precio;guia;idioma;experiencia;proveedor;vehiculo
```

Ejemplo:

```text
Ruta del Sabor;Gastronomico;35000;Carlos Vargas;Español;5;TransLlanquihue;Van
```

---

## Requisitos

- IntelliJ IDEA.
- Java JDK 17 o superior.
- Git, si se desea clonar el repositorio.

---

## Clonar el repositorio

```bash
git clone https://github.com/vicentesanz/llanquihue-tour.git
```

Después se debe abrir la carpeta clonada desde IntelliJ IDEA.

---

## Ejecutar el proyecto

1. Abrir el proyecto en IntelliJ IDEA.
2. Configurar un JDK 17 o superior.
3. Verificar que exista `resources/tours.txt`.
4. Abrir `src/ui/Main.java`.
5. Ejecutar el método `main`.
6. Revisar los tours y servicios mostrados en la consola.
7. Utilizar el menú gráfico para registrar y filtrar entidades.

---

## Uso de la interfaz

El menú contiene las siguientes opciones:

```text
1. Registrar guía turístico
2. Registrar proveedor de transporte
3. Registrar cliente
4. Mostrar entidades registradas
5. Filtrar entidades por tipo
0. Salir
```

Los datos registrados en la interfaz se almacenan durante la ejecución actual del programa.

---

## Tecnologías utilizadas

- Java
- Java Swing
- JOptionPane
- IntelliJ IDEA
- Git
- GitHub

---

## Autor

**Vicente Sanz**
