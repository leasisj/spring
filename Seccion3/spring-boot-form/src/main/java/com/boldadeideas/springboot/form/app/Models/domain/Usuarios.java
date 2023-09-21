package com.boldadeideas.springboot.form.app.Models.domain;

import javax.validation.constraints.NotEmpty;

public class Usuarios {

    private String identificador;//como no esta en el formulario no se valida
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotEmpty//no puede ser vacio y es requerido
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String email;

    public Usuarios() {
    }

    public Usuarios(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
