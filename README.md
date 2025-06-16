Claro, aquí tienes un README.md completo y bien estructurado para tu proyecto de lista de tareas con Spring Boot.

***

# Proyecto TODO List con Spring Boot

Este es un proyecto básico de una aplicación de lista de tareas (**TODO list**) desarrollada con **Spring Boot**. La app permite realizar operaciones **CRUD** sobre tareas y gestionarlas a través de una API RESTful. Ahora utiliza **MySQL** como base de datos persistente, desplegada con **Docker**, y **PhpMyAdmin** como interfaz visual.

---

## 🎯 Objetivo

Demostrar los fundamentos de una aplicación RESTful usando Spring Boot con persistencia en MySQL. Este proyecto es ideal para desarrolladores que comienzan con Spring y desean conocer la integración con bases de datos externas.

**Nivel:** Básico
**Tiempo estimado de desarrollo:** 2-3 días

---

## ✨ Características Principales

* **Crear Tareas:** Añadir nuevas tareas con un título y una descripción.
* **Leer Tareas:** Obtener una lista de todas las tareas o una tarea específica por su ID.
* **Actualizar Tareas:** Modificar el título, la descripción o el estado de una tarea existente.
* **Eliminar Tareas:** Borrar una tarea de la base de datos.
* **Gestión de Estados:** Cada tarea puede tener uno de los siguientes estados:
    * `pendiente`
    * `progreso`
    * `completado`

---

## 🛠️ Tecnologías Utilizadas

* **Java 21+**: Lenguaje de programación principal.
* **Spring Boot**: Framework para crear aplicaciones autocontenidas y listas para producción.
* **Spring Web**: Proporciona funcionalidades para construir aplicaciones web, incluyendo APIs RESTful.
* **Spring Data JPA**: Facilita la implementación de la capa de acceso a datos y la comunicación con la base de datos.
* **MySQL (Docker)**: Sistema de gestión de bases de datos relacional ampliamente utilizado. En este proyecto se ejecuta dentro de un contenedor Docker para facilitar su despliegue sin instalación manual.
* **PhpMyAdmin (Docker)**: Herramienta web que permite administrar visualmente bases de datos MySQL. Se incluye como contenedor para consultar, editar y gestionar datos sin necesidad de línea de comandos.
* **Docker & Docker Compose**: Docker permite ejecutar servicios en contenedores livianos y reproducibles. Docker Compose facilita la definición y ejecución de múltiples contenedores mediante un único archivo `docker-compose.yml`.

* **Maven**: Herramienta para la gestión de dependencias y construcción del proyecto.

---

## 🚀 Cómo Ejecutar el Proyecto

Para poner en marcha este proyecto en tu entorno local, sigue estos sencillos pasos:

1.  **Clonar el Repositorio**
    ```bash
    git clone https://github.com/tu-usuario/tu-repositorio.git
    cd tu-repositorio
    ```

2. **Levanta la base de datos con Docker**

Asegúrate de tener Docker y Docker Compose instalados, y ejecuta:

    docker-compose up -d

Esto iniciará MySQL y PhpMyAdmin. Puedes acceder a PhpMyAdmin desde:

    http://localhost:8080

* **Servidor**: mysql-container

* **Usuario**: root

* **Contraseña**: admin


3.  **Ejecutar la Aplicación**
    Puedes ejecutar la aplicación utilizando el wrapper de Maven incluido en el proyecto.
    ```bash
    ./mvnw spring-boot:run
    ```
    La aplicación se iniciará en el puerto `8080` por defecto.

3.  **Acceder a PhpMyAdmin**
    Una vez que la aplicación esté en funcionamiento, puedes acceder al gestor de la base de datos MySQL para ver las tablas y ejecutar consultas SQL.

    * Abre tu navegador y ve a: `http://localhost/index.php`
    * Asegúrate de que la configuración sea la siguiente:
        * **JDBC URL:** `jdbc:mysql://localhost:3306/todolistdb`
        * **User Name:** `root`
        * **Password:** `admin`
    * Haz clic en **Iniciar sesión**.

---

## 📝 Modelo de Datos

La aplicación utiliza una única entidad llamada `Tarea` para representar las tareas en la base de datos.

### Entidad `Tarea`

| Campo             | Tipo de Dato    | Descripción                                      |
| ----------------- |-----------------| ------------------------------------------------ |
| `id`              | `Long`          | Identificador único de la tarea (autoincremental). |
| `titulo`          | `String`        | Título o nombre corto de la tarea.               |
| `descripcion`     | `String`        | Descripción detallada de lo que hay que hacer.   |
| `estado`          | `State`         | Estado actual de la tarea.                       |
| `fechaCreacion`   | `LocalDateTime` | Fecha y hora en que se creó la tarea.            |

---

## 🌐 Endpoints de la API

La API RESTful proporciona los siguientes endpoints para interactuar con las tareas.

| Método HTTP | URI                     | Descripción                                         |
| ----------- | ----------------------- | --------------------------------------------------- |
| `GET`       | `/api/tasks`            | Obtiene todas las tareas existentes.                |
| `GET`       | `/api/tasks/{id}`       | Obtiene una tarea específica por su ID.             |
| `POST`      | `/api/tasks`            | Crea una nueva tarea.                               |
| `PUT`       | `/api/tasks/{id}`       | Actualiza una tarea existente por su ID.            |
| `DELETE`    | `/api/tasks/{id}`       | Elimina una tarea específica por su ID.             |

### Ejemplo de Body para `POST` y `PUT`

Para crear o actualizar una tarea, el cuerpo de la solicitud debe ser un JSON con la siguiente estructura:

```json
{
  "titulo": "Implementar funcionalidad de login",
  "descripcion": "Añadir autenticación de usuarios con Spring Security.",
  "estado": "progreso"
}
```