package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {
    @GetMapping("/")
    public String home() {
        //return "redirect:/app/index";  //TODO-> Redirige hacia la pagina index reiniciando el Request
        //return "redirect:https://www.google.com"; //
        return "forward:/app/index"; //Todo-> Esto funciona solo para rutas de controladores, conserva la informacion del request
    }
}
