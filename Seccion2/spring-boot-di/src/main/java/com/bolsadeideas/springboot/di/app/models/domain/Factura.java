package com.bolsadeideas.springboot.di.app.models.domain;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Factura {

    @Value("${factura.descripcion}")
    private String descripcion;

    @Autowired
    private Cliente cliente;

    @Autowired
    @Qualifier("itemsFacturaOficina")
    private List<itemFactura> items;

    @PostConstruct
    //Este metodo es para agrgar informacion justo despues de que el objeto se a contruido, se ocupa pra concatenar
    public void inicializar() {
        cliente.setNombre(cliente.getNombre().concat(" ").concat("Susán"));
        descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
    }


    @PreDestroy
    //Esto se hace paplica cuando se detiene el programa con el boton rojo
    public void destruir() {
        System.out.println("Factura destruida: ".concat(descripcion));
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<itemFactura> getItems() {
        return items;
    }

    public void setItems(List<itemFactura> items) {
        this.items = items;
    }
}
