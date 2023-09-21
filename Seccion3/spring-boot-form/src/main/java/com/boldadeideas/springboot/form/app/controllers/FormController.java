package com.boldadeideas.springboot.form.app.controllers;

import com.boldadeideas.springboot.form.app.Models.domain.Usuarios;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("titulo", "Formulario de Cliente");
        return "form";
    }

    @PostMapping("/form")
    //Esta version es mas automatica, ya que pasamos los a la clase usuario en el argumento, siempre y cuando la clase pojo tenga los mismo
    //nombre que en el formulario
    public String procesar(Usuarios usuario, Model model) {

        model.addAttribute("titulo", "Datos del formulario");
        model.addAttribute("usuario", usuario);
        return "resultado";
    }
}
