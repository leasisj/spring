package com.boldadeideas.springboot.form.app.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = ApellidoRegexValidador.class)
@Retention(RUNTIME)
@Target({FIELD, METHOD})
public @interface ApellidoRegex {
    String message() default "El apellido es requerido Regex";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
