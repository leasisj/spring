package com.bolsadeideas.springboot.di.app.conrollers;

import com.bolsadeideas.springboot.di.app.models.domain.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

@Controller
@RequestMapping("/factura")
public class facturaControl {

    @Autowired
    private Factura factura;

    @GetMapping("/ver")
    public String ver(Model model) {
        model.addAttribute("titulo", "Ejemplo Factura con inyeccion de dependencia");
        model.addAttribute("factura", factura);

        return "factura/ver";
    }
}
