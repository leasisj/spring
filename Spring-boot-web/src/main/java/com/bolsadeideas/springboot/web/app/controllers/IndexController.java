package com.bolsadeideas.springboot.web.app.controllers;

import com.bolsadeideas.springboot.web.app.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {
    @GetMapping({"/index", "/", " ", "/home"})
    public String index(Model model) {
        model.addAttribute("titulo", "Hola Spring Framework!");
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Isael");
        usuario.setApellido("Jimenez");
        usuario.setEmail("isael@correo.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil de usuario: ".concat(usuario.getNombre()));
        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Lista de usuarios");
        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Isael", "Jimenez", "isael@gmail.com"),
                new Usuario("Susana", "Jimenez", "susana@gmail.com"),
                new Usuario("Alejandra", "sandoval", "alejandra@gmail.com"),
                new Usuario("Ismael", "Lopez", "ismael@gmail.com"),
                new Usuario("Raquel", "Galicia", "raquel@gmail.com")
        );
        return usuarios;
    }
}
