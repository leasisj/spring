package com.boldadeideas.springboot.form.app.controllers;

import com.boldadeideas.springboot.form.app.Models.domain.Usuarios;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("usuarios")
//para mantener la session http, se mantienen de manera persistente enttre el formulario y el procesar cuando se envian datos
//pero si cambiamos un dato en el formulario, ese si se va actualizar por lo que se refleja el cambio.
public class FormController {

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
        model.addAttribute("titulo", "Datos del formulario");

        if (result.hasErrors()) {
            return "form"; //regresamos al formulario
        }
        model.addAttribute("usuario", usuario);
        //Cuando finaliza el proceso y se guarda en la base de datos, lo tenemos que limiar atraves de un objeto SessionStatus
        status.setComplete();//lo que hace es completar y eliminar el objeto de la session inicial.
        //El identificador es un atributo que esta en la clase pojo, pero que no esta en el formulario
        //por lo que al ocupar el @SeccionAtribute y SessionStatus la informacion que esta en el objeto pero que no esta en el formulario
        //no se pierde pero podemos modificar lo que esta en el formulrio sin que la informacion que esta en el objeto se pierda.
        return "resultado";
    }
}
