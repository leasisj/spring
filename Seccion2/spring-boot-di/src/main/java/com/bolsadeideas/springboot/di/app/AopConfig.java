package com.bolsadeideas.springboot.di.app;

import com.bolsadeideas.springboot.di.app.models.domain.Producto;
import com.bolsadeideas.springboot.di.app.models.domain.itemFactura;
import com.bolsadeideas.springboot.di.app.models.service.IServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicioComplejo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AopConfig {
    @Bean("miServicioSimple")
    @Primary
    public IServicio registrarMiServicio() {
        return new MiServicio();
    }

    @Bean("miServicioComplejo")
    public IServicio registrarMiServicioComplejo() {
        return new MiServicioComplejo();
    }


    @Bean("itemsFactura")
    public List<itemFactura> registroItems() {
        Producto producto1 = new Producto("Camara Sony", 100);
        Producto producto2 = new Producto("Bicicleta Bianchi aro 26", 200);
        itemFactura linea1 = new itemFactura(producto1, 2);
        itemFactura linea2 = new itemFactura(producto1, 4);
        return Arrays.asList(linea1, linea2);
    }

    @Bean("itemsFacturaOficina")
    //@Primary
    public List<itemFactura> registroItemsOficina() {
        Producto producto1 = new Producto("Monitor LG", 2500);
        Producto producto2 = new Producto("Laptop", 500);
        Producto producto3 = new Producto("Impresora", 900);
        Producto producto4 = new Producto("Escritorio", 500);

        itemFactura linea1 = new itemFactura(producto1, 2);
        itemFactura linea2 = new itemFactura(producto2, 4);
        itemFactura linea3 = new itemFactura(producto3, 8);
        itemFactura linea4 = new itemFactura(producto4, 3);
        return Arrays.asList(linea1, linea2, linea3, linea4);
    }

}
