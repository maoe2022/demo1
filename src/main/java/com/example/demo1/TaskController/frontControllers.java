package com.example.demo1.TaskController;


import com.example.demo1.entities.Task;
import com.example.demo1.entities.User;
import com.example.demo1.services.TaskServices;
import com.example.demo1.services.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class frontControllers {
  TaskServices services;
  UserService userService;

  public frontControllers(TaskServices services, UserService userService ){
        this.services = services;
        this.userService = userService;
    }

/*  public frontControllers(TaskServices services){//Crear el servicio de tipo frontController
            this.services = services;
        }*/
/*
   @GetMapping("/tasks")
   public String consularTasks(Model model) {//Servicio para consultar la BD desde cualquier recurso
           List<Task> tasks = this.services.getTaskList();//obtener la lista de tareas desde el controlador
            model.addAttribute("tasks", tasks);//se pasa la lista de tareas obtenida al template por medio dal modelo*/
           // return "tasks"; }*/

/*    @GetMapping("/pruebatasks")
    public String indexPru(){
        return "index";
    }*/
/*    @GetMapping("/pruebatasks2")
    public String Bienvenidos(@RequestParam(name="name", required=false, defaultValue=" Como estas?") String nombre, Model model) {
        model.addAttribute("nombre", "Pepito");
        return "index";
    }*/

/*    @GetMapping("/readtasks")
    public String showTaskList(){//Servicio para consultar la BD desde front(Thymeleaf)
        return "index";  }*/

/*    @GetMapping("/consultartareas")
    public String showTaskList(Model model) {
        List<Task>  taskAll = this.services.getTaskList();
        model.addAttribute("taskList", taskAll);
        return "index";
    }*/

    /*@GetMapping("/")
    public String showindex(){//Servicio para consultar la BD desde front(Thymeleaf)
        return "indexlp";
    }*/

/*    @GetMapping("/")
    public String index (Model model, @AuthenticationPrincipal OidcUser principal)  {*//*OidcUser entrega la información del Usuario principal*//*
        if(principal != null) {//permite que este codigo se ejecute despues de inciar sesión
           // System.out.println(principal.getclaims());//getclaims() obtine la información que princpal puede capturar de la base de datos o crear el usuario en caso de que no exista
            User user =  this.userService.getOrCreateUser(principal.getClaims()); //se requiere enviar al Servicio el getclaims() para que encuentre a este usuario en la base de datos  y si no existe que lo crea
            model.addAttribute("user", user);//se pasan estos datos al Modelo para presentarlos en el Front
        }
        return "indexlp";
    }*/

    @GetMapping("/")
    public String index (Model model, @AuthenticationPrincipal OidcUser principal)  {//*OidcUser entrega la información del Usuario principal*//*
        if(principal != null) {//permite que este codigo se ejecute despues de inciar sesión
            // System.out.println(principal.getclaims());//getclaims() obtine la información que princpal puede capturar de la base de datos o crear el usuario en caso de que no exista
            User user =  this.userService.getOrCreateUser(principal.getClaims()); //se requiere enviar al Servicio el getclaims() para que encuentre a este usuario en la base de datos  y si no existe que lo crea
            model.addAttribute("user", user);//se pasan estos datos al Modelo para presentarlos en el Front
        }
        return "indexlp";
    }


    @GetMapping("/tasks")//Renderizar a indexgt.html
    public String showTaskList(Model model) {
        List<Task>  taskAll = this.services.getTaskList();
        model.addAttribute("taskList",taskAll);
        return "indexgt";
    }

    @GetMapping("/tasks/nuevotask")//Renderizar el formulario desde creatask.html
    public String creartareas(Model model) {
        model.addAttribute("taskList", new Task());//Crea tarea vacia para luego diligenciarla en el formualrio
        return "creartask";
    }
}




