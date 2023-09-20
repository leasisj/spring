package com.bolsadeideas.springboot.web.app.controllers;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("titulo", "Enviar parametro del request HTTP GET -URL");
        return "params/index";
    }

    //para poder verlo en el navegador -> http://localhost:8080/params/string?texto=hola%20que%20tal
    @GetMapping("/string")
    public String param(@RequestParam(value = "texto", defaultValue = "No hay texto") String texto, Model model) {
        model.addAttribute("resultado", "El texto enviado es: " + texto);
        model.addAttribute("titulo", "Recibir parametro del request HTTP GET -URL");
        return "params/ver";
    }

    @GetMapping("/mix-params")
    public String param(@RequestParam(defaultValue = "No hay texto") String saludo, @RequestParam(defaultValue = "No hay numero") Integer numero, Model model) {
        model.addAttribute("resultado", "El texto enviado es: '" + saludo + "' y el numero es: '" + numero + "'");
        model.addAttribute("titulo", "Recibir parametro del request HTTP GET -URL");
        return "params/ver";
    }

    @GetMapping("/mix-param-request")
    public String param(HttpServletRequest request, Model model) {
        String saludo = request.getParameter("saludo");
        Integer integer = null;
        try {
            integer = Integer.parseInt(request.getParameter("numero"));
        } catch (NumberFormatException e) {
            integer = 0;
        }
        model.addAttribute("resultado","El saludo es: '" + saludo + "' y el numero es '" + integer + "'");
        model.addAttribute("titulo", "Recibir parametro del request HTTP GET -URL");
        return "params/ver";
    }

}
