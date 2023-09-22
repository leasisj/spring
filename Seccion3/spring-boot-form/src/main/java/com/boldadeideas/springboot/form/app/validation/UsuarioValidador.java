package com.boldadeideas.springboot.form.app.validation;


import com.boldadeideas.springboot.form.app.Models.domain.Usuarios;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UsuarioValidador implements Validator {//este deve importalo de springframework no de otro

    //Se crean dos metodos
    //1 es para validar y 2 es de soporte
    @Override
    public boolean supports(Class<?> aClass) {
        //Indica que clase entity vamos a validar en este caso usuario
        return Usuarios.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Usuarios usuarios = (Usuarios) o;
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "NotEmpty.usuarios.nombre");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "requerido.usuarios.nombre");

        //Esto es lo mismo a lo de arriba
        /*if (usuarios.getNombre().isEmpty()){
            errors.rejectValue("nombre", "NotEmpty.usuarios.nombre");
        }*/

        if (!usuarios.getIdentificador().matches("^\\d{2}\\.\\d{3}\\.\\d{3}-[A-Z]$")) {
            errors.rejectValue("identificador", "Pattern.usuarios.identificador");
        }
    }
}
