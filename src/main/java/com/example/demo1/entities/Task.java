package com.example.demo1.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;//crear el atributo id
    @Column(name="description")
    private String description;
    @Column(name="done")
    private Boolean done;
    @Column(name="dueDate")
    private LocalDate dueDate;
    public Task(String description, Boolean done, LocalDate date) {
        this.description = description;
        this.done = done;
        this.dueDate = date;
    }
    public Task() {//Constructor obligatorio

    }
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return this.done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
