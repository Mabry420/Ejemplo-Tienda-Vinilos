# Tienda de Vinilos 🎵

Aplicación de escritorio para gestionar una tienda de vinilos, desarrollada como ejemplo para un examen de **Programación Orientada a Objetos**.

## Tecnologías utilizadas

- **Java 17** — Lenguaje de programación
- **JavaFX + SceneBuilder** — Interfaz gráfica
- **MySQL** — Base de datos
- **Maven** — Gestión de dependencias y construcción del proyecto
- **JDBC** — Conexión con la base de datos

## Estructura del proyecto

```
src/main/java/com/tiendavinilos/
├── App.java                  # Clase principal (entrada de la aplicación)
├── model/
│   └── Vinilo.java           # Modelo de datos del vinilo
├── view/
│   └── PrincipalController.java  # Controlador de la interfaz gráfica
└── database/
    ├── DatabaseConnection.java   # Conexión con MySQL
    └── ViniloDAO.java            # Operaciones CRUD (Crear, Leer, Actualizar, Eliminar)

src/main/resources/
├── fxml/
│   └── Principal.fxml        # Diseño de la interfaz (SceneBuilder)
├── css/
│   └── estilos.css           # Estilos de la interfaz
└── db/
    ├── config.properties     # Configuración de conexión a la BD
    └── schema.sql            # Script para crear la base de datos y tabla
```

## Requisitos

- JDK 17 o superior
- MySQL Server 8.x
- Maven
- SceneBuilder (opcional, para editar la interfaz)

## Configuración inicial

### 1. Base de datos

Abre **MySQL Workbench** y ejecuta el script:

```
src/main/resources/db/schema.sql
```

Esto creará la base de datos `tienda_vinilos` y la tabla `vinilos` con datos de ejemplo.

### 2. Configuración de conexión

Edita el archivo `src/main/resources/db/config.properties` y coloca tus credenciales de MySQL:

```
db.url=jdbc:mysql://localhost:3306/tienda_vinilos?useSSL=false&serverTimezone=UTC
db.user=tu_usuario
db.password=tu_contraseña
```

### 3. Ejecutar la aplicación

```bash
mvn clean compile javafx:run
```

O desde **IntelliJ IDEA**: abre el proyecto, espera a que Maven cargue las dependencias y ejecuta `App.java`.

## Paquetes explicados

| Paquete | Responsabilidad |
|---------|----------------|
| `com.tiendavinilos` | Clase principal que inicia la aplicación |
| `com.tiendavinilos.model` | Clases que representan los datos (Vinilo) |
| `com.tiendavinilos.view` | Controladores de la interfaz gráfica (FXML) |
| `com.tiendavinilos.database` | Conexión y operaciones con la base de datos |

## Autor

Desarrollado como práctica para examen de POO.
