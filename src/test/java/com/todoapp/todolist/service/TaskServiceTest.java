package com.todoapp.todolist.service;

import com.todoapp.todolist.TestDataUtil;
import com.todoapp.todolist.model.Task;
import com.todoapp.todolist.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private List<Task> mockTasks;

    @BeforeEach
    void setUp(){

        mockTasks = List.of(
                TestDataUtil.createTask1(),
                TestDataUtil.createTask2(),
                TestDataUtil.createTask3()
        );

    }

    @Test
    void testThatGetAllTasks() {

        when(taskRepository.findAll()).thenReturn(mockTasks);

        List<Task> result = taskService.getAllTasks();

        assertEquals(3, result.size());
        assertNotNull(result);
    }

    @Test
    void testThatGetOneTaskById(){

        when(taskRepository.findById(1L)).thenReturn( Optional.of(mockTasks.get(1)) );

        Optional<Task> result = taskService.getTaskById(1L);

        assertTrue(result.isPresent());
        assertEquals(result, Optional.of(mockTasks.get(1)));

    }

    @Test
    void testThatCreateTask(){
        Task newTask = TestDataUtil.createTask4();

        when(taskRepository.save(newTask)).thenReturn(newTask);

        Task result = taskService.createTask(newTask);

        assertEquals(newTask, result);

    }

    @Test
    void testThatUpdateTask(){

        Task updatedTask = TestDataUtil.createTask4();

        when(taskRepository.findById(1L)).thenReturn( Optional.of(mockTasks.get(1)) );
        when(taskRepository.save( any(Task.class )) ).thenReturn( updatedTask );

        Task result = taskService.updateTask(1L, updatedTask);

        assertTrue(result != mockTasks.get(1));
        assertEquals( updatedTask, result );

    }

    @Test
    void testThatDeleteTask(){

        doNothing().when(taskRepository).deleteById(1L);

        taskService.deleteTask(1L);

        verify(taskRepository, times(1)).deleteById(1L);

    }

}
