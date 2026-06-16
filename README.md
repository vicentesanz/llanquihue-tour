# Llanquihue Tour App

## Descripción

Aplicación desarrollada en Java para la actividad de la Semana 4 de Desarrollo Orientado a Objetos I.

El programa lee información de tours turísticos desde un archivo de texto llamado `tours.txt`, crea objetos de la clase `Tour` y los almacena en un `ArrayList`.

Posteriormente, muestra todos los tours registrados y realiza un filtro para visualizar únicamente los tours de tipo gastronómico.

## Estructura de carpetas

```text
LlanquihueTourApp
├── src
│   ├── data
│   │   └── GestorDatos.java
│   ├── model
│   │   └── Tour.java
│   └── ui
│       └── Main.java
├── resources
│   └── tours.txt
└── README.md
```

## Instrucciones de ejecución

1. Abrir el proyecto en IntelliJ IDEA.
2. Verificar que el archivo `tours.txt` se encuentre dentro de la carpeta `resources`.
3. Ejecutar la clase `Main` ubicada en el paquete `ui`.
4. El programa mostrará todos los tours cargados desde el archivo y luego los tours gastronómicos filtrados.

## Autor

Vicente Sanz