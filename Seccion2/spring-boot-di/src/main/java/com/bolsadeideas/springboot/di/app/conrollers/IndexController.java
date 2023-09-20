package com.bolsadeideas.springboot.di.app.conrollers;

import com.bolsadeideas.springboot.di.app.models.service.MiServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private MiServicio servicio;

    @GetMapping({"/index", "/", ""})
    public String index(Model model) {
        String operacion = servicio.operacion();
        model.addAttribute("titulo", "Haciendo prueba de isael");
        model.addAttribute("texto", "La operacion realizada es: " + operacion);
        return "index";
    }
}
