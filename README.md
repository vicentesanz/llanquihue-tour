# LlanquihueTourApp

## Descripción

LlanquihueTourApp es una aplicación desarrollada en Java para la asignatura Desarrollo Orientado a Objetos I.

El sistema permite cargar información de tours turísticos desde un archivo de texto, gestionar distintos servicios turísticos mediante herencia y polimorfismo, y registrar entidades de la agencia utilizando una interfaz común.

En esta versión se incorporan interfaces, colecciones genéricas, validación mediante `instanceof` e interacción con el usuario mediante una interfaz gráfica construida con `JOptionPane`.

---

# Paquetes Utilizados

## model

Contiene las entidades del sistema:

- Registrable
- ServicioTuristico
- RutaGastronomica
- PaseoLacustre
- ExcursionCultural
- Tour
- GuiaTuristico
- ProveedorTransporte

## data

Contiene las clases encargadas de gestionar los datos:

- GestorDatos
- GestorServicios
- GestorEntidades

## ui

Contiene la interfaz de usuario:

- Main
- VentanaRegistro

---

# Clases e Interfaces

## Registrable

Interfaz que define el método `mostrarResumen()`, implementado por las entidades registrables del sistema.

## ServicioTuristico

Superclase de los servicios turísticos.

## RutaGastronomica

Subclase que incorpora el número de paradas.

## PaseoLacustre

Subclase que incorpora el tipo de embarcación.

## ExcursionCultural

Subclase que incorpora el lugar histórico.

## GuiaTuristico

Representa un guía turístico e implementa la interfaz `Registrable`.

## ProveedorTransporte

Representa una empresa de transporte e implementa la interfaz `Registrable`.

## GestorServicios

Gestiona la colección polimórfica de servicios turísticos.

## GestorEntidades

Gestiona una colección `ArrayList<Registrable>` utilizando polimorfismo y `instanceof`.

## VentanaRegistro

Interfaz gráfica desarrollada con `JOptionPane` que permite registrar y visualizar entidades.

## Main

Clase principal del proyecto.

---

# Funcionalidades

- Lectura de tours desde archivo de texto.
- Uso de ArrayList y colecciones genéricas.
- Herencia entre clases.
- Polimorfismo.
- Implementación de la interfaz `Registrable`.
- Uso de `instanceof`.
- Registro de guías turísticos.
- Registro de proveedores de transporte.
- Visualización de entidades mediante interfaz gráfica.
- Manejo básico de excepciones.
- Organización modular en paquetes.

---

# Estructura del Proyecto

```text
LlanquihueTourApp
│
├── src
│   ├── model
│   ├── data
│   └── ui
│
├── resources
│   └── tours.txt
│
└── README.md
```

---

# Instrucciones de Ejecución

1. Abrir el proyecto en IntelliJ IDEA.
2. Verificar que el archivo `tours.txt` se encuentre en la carpeta `resources`.
3. Ejecutar la clase `Main`.
4. El sistema cargará los tours desde el archivo.
5. Se mostrarán los servicios turísticos por consola.
6. Se abrirá la interfaz gráfica para registrar y visualizar entidades.

---

# Tecnologías Utilizadas

- Java
- IntelliJ IDEA
- Git
- GitHub
- JOptionPane (Swing)

---

# Autor

Vicente Sanz