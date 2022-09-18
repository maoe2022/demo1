package com.example.demo1.services;

import com.example.demo1.entities.Task;
import com.example.demo1.repositories.TaskRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


//import java.time.LocalDate;
//import java.util.Scanner;
//import com.example.demo1.entities.TaskList;
@Service
public class TaskServices {
    private TaskRepositorio repository;
    public TaskServices(TaskRepositorio repository){
        this.repository=repository;
    }
    /*  Task t1;
        Task t2;
        Task t3;
        Task t4;
        Task t5;

        TaskList metas;

        public  TaskServices(){
            this.t1 = new Task("Recordar POO", true, LocalDate.of(2022,8,23));
            this.t2 = new Task("Conocer Intellij IDEA Ultimate", false, LocalDate.of(2022,8,24));
            this.t3 = new Task("Conocer Java Spring Boot", false, LocalDate.of(2022,8,25));
            this.t4 = new Task("Afinar la arquitectura del proyecto", false, LocalDate.of(2022,8,26));
            this.t5 = new Task("Finalizar tareas", false, LocalDate.of(2022,9,15));

            this.metas = new TaskList("Tareas Iniciales");
            metas.addTask(t1);
            metas.addTask(t2);
            metas.addTask(t3);
            metas.addTask(t4);
            metas.addTask(t5);

            }
            public TaskList getTaskList(){
            return this.metas;

            }/*
            public Task createRepository()*/
    public List<Task> getTaskList(){
        return this.repository.findAll();
    }
    public Task createTask(Task newTask){
    return this.repository.save(newTask);
    }

    public Boolean taskFinished(Long id){//Declarar el metodo para marcar la tarea como finalizada
           Optional<Task> task = this.repository.findById(id);//Importar la clase Optional e Identificar la tarea en el sistema devolviendo un dato de  tipo optional
            if(task.isPresent()){//Validar si la tarea exist
                task.get().setDone(true);//Obtener la insatancia o el valor de un Optional y cambiar el estado del done
                this.repository.save(task.get());//Almacena el nuevo estado del done
                return true;//Garantiza que evidentemente se termino la tarea
            }
            return false;//Si la tarea no existe se retorna false para mantener la terea como "Tarea sin Terminar"
        }

    public Boolean deleteTask(Long id){//metodo para elminar una tarea por id
        this.repository.deleteById(id);//repositorio para eliminar la tarea
        return true;//Validar si se ejecuta la eliminación de la tarea
        }
    }


