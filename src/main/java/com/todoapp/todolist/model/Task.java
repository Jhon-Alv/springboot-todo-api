package com.todoapp.todolist.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private State state;

    private LocalDateTime created_date;

    @PrePersist
    public void asignDate(){
        this.created_date = LocalDateTime.now();
    }

    public Task() {
    }

    public Task(String description, String title, State estado) {
        this.description = description;
        this.title = title;
        this.state = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }
}
