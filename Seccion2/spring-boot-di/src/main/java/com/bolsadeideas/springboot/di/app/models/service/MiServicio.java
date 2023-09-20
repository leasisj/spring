package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MiServicio {
    public String operacion(){
        return "ejecutando algu proseso importante";
    }
}
