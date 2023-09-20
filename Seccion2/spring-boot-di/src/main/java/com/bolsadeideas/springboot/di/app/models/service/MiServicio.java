package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("miServicioSimple")
//@Primary
public class MiServicio implements IServicio {
    @Override
    public String operacion() {
        return "ejecutando algun proceso importante simple";
    }
}
