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

    //El validador se implementa en el init binder, cuando se inicializa el proceso de validacion y el proseso de pasar los datos al objeto usuario
    @InitBinder
    public void  initBinder(WebDataBinder binder){//el inid vinder es un elemento del siclo de vida del controlador
        //binder.setValidator(validador);//esto solo aplica a la clase validador por eso tenemos un error
        binder.addValidators(validador);//Esto agrega un nuevo validador al stack y no actualizar con set
        //esto ayuda a validar pero de forma tranparente se regista el @Valid en el WebDataBinder
        //Una ves que se envian los datos desde el formulario, se pueblan los datos y se valida
        //esto por debajo se maneja con interseptores.
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
