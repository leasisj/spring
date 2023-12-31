package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("titulo", "Enviar parametro de la ruta (@PatVariable)");
        return "variables/index";
    }

    @GetMapping("/string/{texto}")
    public String variable(@PathVariable String texto, Model model) {
        model.addAttribute("titulo", "Recibir parametro de la ruta (@PatVariable)");
        model.addAttribute("resultado", "El texto eviado es: " + texto);
        return "variables/ver";
    }

    @GetMapping("/string/{texto}/{numero}")
    public String variable(@PathVariable String texto, @PathVariable Integer numero, Model model) {
        model.addAttribute("titulo", "Recibir parametro de la ruta (@PatVariable)");
        model.addAttribute("resultado", "El texto eviado es: " + texto + " y el numero enviado en el path es: " + numero);
        return "variables/ver";
    }
}
