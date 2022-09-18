package com.example.demo1.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskList {
    private String name;
    private List<Task> taskList;

    public TaskList(String name) {
        this.name = name;
        this.taskList = new ArrayList<Task>();
    }

    public void addTask(Task task) {
        this.taskList.add(task);
    }


    public void removeTask(String description) {
        this.taskList = taskList.stream().filter(t ->
                !t.getDescription().equals(description)
        ).collect(Collectors.toList());
    }

    public void removeTask2(String description) {
        this.taskList.removeIf(t -> t.getDescription().equals(description));
    }

    public List<Task> getTaskList() {
        return this.taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printTask() {
        this.taskList.forEach(task -> {
                    System.out.println("Descripcion: " + task.getDescription());
                    System.out.println("Fecha: " + task.getDueDate());
                    System.out.println("Estado: " + task.getDone());
                    System.out.println("***************************");
                }
        );
    }

    public void printTask2() {
        for (Task task : this.taskList) {
            System.out.println("Descripcion: " + task.getDescription());
            System.out.println("Fecha: " + task.getDueDate());
            System.out.println("Estado: " + task.getDone());
            System.out.println("***************************");
        }
    }
}
