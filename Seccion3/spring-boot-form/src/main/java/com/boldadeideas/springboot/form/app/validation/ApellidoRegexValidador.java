package com.boldadeideas.springboot.form.app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ApellidoRegexValidador implements ConstraintValidator<ApellidoRegex, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if (s == null || s.isEmpty() || s.isBlank()) {
            return false;
        }
        return true;
    }
}
