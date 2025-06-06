package com.todoapp.todolist;

import com.todoapp.todolist.model.State;
import com.todoapp.todolist.model.Task;

public class TestDataUtil {

    public static Task createTask1() {
        Task task = new Task();

        task.setTitle("Realizar pruebas de carga");
        task.setDescription("Evaluar rendimiento de la aplicación bajo alta demanda");
        task.setState(State.pendiente);

        return task;
    }

    public static Task createTask2() {
        Task task = new Task();

        task.setTitle("Optimizar consultas SQL");
        task.setDescription("Mejorar tiempos de respuesta en la API mediante optimización de queries");
        task.setState(State.progreso);

        return task;
    }

    public static Task createTask3() {
        Task task = new Task();

        task.setTitle("Implementar autenticación multifactor");
        task.setDescription("Agregar autenticación adicional para mejorar la seguridad de los usuarios");
        task.setState(State.completado);

        return task;
    }

    public static Task createTask4() {
        Task task = new Task();

        task.setTitle("Refactorizar código");
        task.setDescription("Reestructurar el código para mejorar la mantenibilidad y eficiencia");
        task.setState(State.pendiente);

        return task;
    }

    public static Task createTask5() {
        Task task = new Task();

        task.setTitle("Mejorar el diseño de UI");
        task.setDescription("Actualizar la interfaz gráfica para mejorar la experiencia del usuario");
        task.setState(State.progreso);

        return task;
    }


}
