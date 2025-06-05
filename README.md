Claro, aquí tienes un README.md completo y bien estructurado para tu proyecto de lista de tareas con Spring Boot.

***

# Proyecto TODO List con Spring Boot

Este es un proyecto básico de una aplicación de lista de tareas (TODO list) desarrollada con **Spring Boot**. La aplicación permite realizar operaciones **CRUD** (Crear, Leer, Actualizar, Eliminar) sobre tareas y gestionarlas a través de una API RESTful. Para simplificar el despliegue y las pruebas, utiliza una base de datos en memoria **H2**.

---

## 🎯 Objetivo

El objetivo principal de este proyecto es demostrar los fundamentos de la creación de una aplicación web RESTful utilizando el ecosistema de Spring. Es ideal para desarrolladores que están comenzando con Spring Boot y desean entender cómo integrar una base de datos, crear entidades y exponer endpoints.

**Nivel:** Básico
**Tiempo estimado de desarrollo:** 2-3 días

---

## ✨ Características Principales

* **Crear Tareas:** Añadir nuevas tareas con un título y una descripción.
* **Leer Tareas:** Obtener una lista de todas las tareas o una tarea específica por su ID.
* **Actualizar Tareas:** Modificar el título, la descripción o el estado de una tarea existente.
* **Eliminar Tareas:** Borrar una tarea de la base de datos.
* **Gestión de Estados:** Cada tarea puede tener uno de los siguientes estados:
    * `PENDIENTE`
    * `EN_PROGRESO`
    * `COMPLETADO`

---

## 🛠️ Tecnologías Utilizadas

* **Java 21+**: Lenguaje de programación principal.
* **Spring Boot**: Framework para crear aplicaciones autocontenidas y listas para producción.
* **Spring Web**: Proporciona funcionalidades para construir aplicaciones web, incluyendo APIs RESTful.
* **Spring Data JPA**: Facilita la implementación de la capa de acceso a datos y la comunicación con la base de datos.
* **H2 Database**: Base de datos en memoria, ideal para desarrollo y pruebas rápidas sin necesidad de configuración externa.
* **Maven**: Herramienta para la gestión de dependencias y construcción del proyecto.

---

## 🚀 Cómo Ejecutar el Proyecto

Para poner en marcha este proyecto en tu entorno local, sigue estos sencillos pasos:

1.  **Clonar el Repositorio**
    ```bash
    git clone https://github.com/tu-usuario/tu-repositorio.git
    cd tu-repositorio
    ```

2.  **Ejecutar la Aplicación**
    Puedes ejecutar la aplicación utilizando el wrapper de Maven incluido en el proyecto.
    ```bash
    ./mvnw spring-boot:run
    ```
    La aplicación se iniciará en el puerto `8080` por defecto.

3.  **Acceder a la Consola H2**
    Una vez que la aplicación esté en funcionamiento, puedes acceder a la consola de la base de datos H2 para ver las tablas y ejecutar consultas SQL.

    * Abre tu navegador y ve a: `http://localhost:8080/h2-console`
    * Asegúrate de que la configuración sea la siguiente:
        * **Driver Class:** `org.h2.Driver`
        * **JDBC URL:** `jdbc:h2:mem:tododb`
        * **User Name:** `sa`
        * **Password:** (dejar en blanco)
    * Haz clic en **Connect**.

---

## 📝 Modelo de Datos

La aplicación utiliza una única entidad llamada `Tarea` para representar las tareas en la base de datos.

### Entidad `Tarea`

| Campo             | Tipo de Dato | Descripción                                      |
| ----------------- | ------------ | ------------------------------------------------ |
| `id`              | `Long`       | Identificador único de la tarea (autoincremental). |
| `titulo`          | `String`     | Título o nombre corto de la tarea.               |
| `descripcion`     | `String`     | Descripción detallada de lo que hay que hacer.   |
| `estado`          | `String`     | Estado actual de la tarea.                       |
| `fechaCreacion`   | `LocalDateTime`| Fecha y hora en que se creó la tarea.            |

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
  "estado": "EN_PROGRESO"
}
```