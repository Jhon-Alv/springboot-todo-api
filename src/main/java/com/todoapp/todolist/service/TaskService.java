package com.todoapp.todolist.service;

import com.todoapp.todolist.model.Task;
import com.todoapp.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id){
        return taskRepository.findById(id);
    }

    public Task createTask(Task newTask){
        return taskRepository.save(newTask);
    }

    public Task updateTask(Long id ,Task updatedTask){
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()){
            Task existingTask = optionalTask.get();

            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setState(updatedTask.getState());

            return taskRepository.save(existingTask);
        } else {
            return null;
        }

    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }


}
