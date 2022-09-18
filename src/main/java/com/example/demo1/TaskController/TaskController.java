package com.example.demo1.TaskController;

import com.example.demo1.entities.Task;
import com.example.demo1.entities.TaskList;
import com.example.demo1.services.TaskServices;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


import java.time.LocalDate;
import java.util.List;

@RestController
public class TaskController {
    TaskServices services;


  /* public TaskController(){
        this.services=new TaskServices();

    }*/

    public TaskController(TaskServices services){
        this.services=services;
    }

/*
    @GetMapping("/tasks")
    public Task TaskList(){
        Task t1 = new Task("Recordar POO", true, LocalDate.of(2022,8,26));
        return t1;

    }*/
/*
    @GetMapping("/tasks")
    public TaskList TaskList(){
        return this.services.getTaskList();

    }*/
   /* @GetMapping("/tasks")
    public List<Task> TaskList(){
        return this.services.getTaskList();

    }*/

 /*   @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task){
        return this.services.createTask(task);
    }*/

    @PostMapping("/tasks")
    public RedirectView createTask(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") Task task, Model model){
        model.addAttribute(task);
        task.setDone(false);
        this.services.createTask(task);
        return new RedirectView("/tasks");
    }

    @PatchMapping("/tasks/{id}")
    public RedirectView updateTask(@PathVariable("id") Long id){//pemite identificar el id especifico de una tarea
      this.services.taskFinished(id);//Invocar el metodo taskFinished con la instancia services para modificar la tarea correspondiente al id capturado por la anotacion @PathVariable
      return new RedirectView("/tasks");//Redirige el resultado a la misma URL
    }

    @DeleteMapping("/tasks/{id}")
    public RedirectView deleteTask(@PathVariable("id") Long id){
        this.services.deleteTask(id);
        return new RedirectView("/tasks");
    }
 }

