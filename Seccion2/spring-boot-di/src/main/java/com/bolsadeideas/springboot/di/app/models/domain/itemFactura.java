package com.bolsadeideas.springboot.di.app.models.domain;

import org.springframework.stereotype.Component;


public class itemFactura {
    private Producto producto;

    private Integer cantidad;

    public itemFactura() {
    }

    public itemFactura(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer calcularImporte() {
        Integer total = cantidad * producto.getPrecio();
        return total;
    }
}
