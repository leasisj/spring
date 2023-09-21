package com.boldadeideas.springboot.form.app.controllers;

import com.boldadeideas.springboot.form.app.Models.domain.Usuarios;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model) {
        Usuarios usuario = new Usuarios();
        model.addAttribute("titulo", "Formulario de Cliente");
        model.addAttribute("usuarios", usuario);
        return "form";
    }

    @PostMapping("/form")
    public String procesar(@Valid Usuarios usuario, BindingResult result, Model model) {
        model.addAttribute("titulo", "Datos del formulario");

        if (result.hasErrors()) {
            return "form"; //regresamos al formulario
        }
        model.addAttribute("usuario", usuario);
        return "resultado";
    }
}
