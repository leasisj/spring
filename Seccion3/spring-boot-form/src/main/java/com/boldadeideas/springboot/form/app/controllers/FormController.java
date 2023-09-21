package com.boldadeideas.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @GetMapping("/form")//Este metodo es para mostrar el formulario en la pagina
    public String form(Model model) {
        model.addAttribute("titulo", "Formulario de Cliente");
        return "form";
    }

    @PostMapping("/form")//Prosesa la informacion del formulario
    public String procesar(Model model,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String email

    ) {
        model.addAttribute("titulo", "Datos del formulario");
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("email", email);
        return "resultado"; //Se muestran los resutados que se evian atraves del formulario
        //Mas adelante este metodo va a mapear a la base de datos usando jpa
    }
}
