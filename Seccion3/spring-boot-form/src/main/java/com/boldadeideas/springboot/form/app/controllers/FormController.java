package com.boldadeideas.springboot.form.app.controllers;

import com.boldadeideas.springboot.form.app.Models.domain.Usuarios;
import com.boldadeideas.springboot.form.app.validation.UsuarioValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("usuarios")
public class FormController {

    @Autowired
    private UsuarioValidador validador;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(validador);
    }

    @GetMapping("/form")
    public String form(Model model) {
        Usuarios usuario = new Usuarios();
        usuario.setNombre("isael");
        usuario.setApellido("jimenez");
        usuario.setIdentificador("12.456.789-K");
        model.addAttribute("titulo", "Formulario de Cliente");
        model.addAttribute("usuarios", usuario);
        return "form";
    }

    @PostMapping("/form")
    public String procesar(@Valid Usuarios usuario, BindingResult result, Model model, SessionStatus status) {

        //validador.validate(usuario, result); //lo comentamos apra que se valide con la anotacion @Valid de forma automatica

        model.addAttribute("titulo", "Datos del formulario");

        if (result.hasErrors()) {
            return "form";
        }
        model.addAttribute("usuario", usuario);
        status.setComplete();
        return "resultado";
    }
}
