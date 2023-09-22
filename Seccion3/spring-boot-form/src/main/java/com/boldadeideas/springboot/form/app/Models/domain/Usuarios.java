package com.boldadeideas.springboot.form.app.Models.domain;

import com.boldadeideas.springboot.form.app.validation.ApellidoRegex;
import com.boldadeideas.springboot.form.app.validation.IdentificadorRegex;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class Usuarios {

    //@Pattern(regexp = "^\\d{2}\\.\\d{3}\\.\\d{3}-[A-Z]$")
    @IdentificadorRegex
    private String identificador;//como no esta en el formulario no se valida
    //@NotEmpty
    private String nombre;
    @ApellidoRegex
    private String apellido;
    @NotBlank
    //va lida que no contenga espacions en blanco, se recomienda solo tener una de las dos @NotBlank o NotEmpty
    @Size(min = 3, max = 10)
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    @Email
    private String email;

    @NotNull  //@Not null es para tipo objetos
    @Min(5)
    @Max(5000)
    private Integer cuenta;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechanacimiento;

    public Usuarios() {
    }

    public Usuarios(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Integer getCuenta() {
        return cuenta;
    }

    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
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
