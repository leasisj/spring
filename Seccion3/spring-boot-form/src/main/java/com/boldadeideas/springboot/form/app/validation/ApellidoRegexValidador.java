package com.boldadeideas.springboot.form.app.validation;



import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ApellidoRegexValidador implements ConstraintValidator<ApellidoRegex, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        /*if (s == null || s.isEmpty() || s.isBlank()) {
            return false;
        }*/

        if (s == null || !StringUtils.hasText(s)){
            return false;
        }
        return true;
    }
}
