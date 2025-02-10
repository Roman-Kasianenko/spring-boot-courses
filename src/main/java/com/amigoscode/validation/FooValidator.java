package com.amigoscode.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public class FooValidator implements ConstraintValidator<Foo, String> {

    @Override
    public boolean isValid(String value,
                           ConstraintValidatorContext context) {

        return value == null || value.equalsIgnoreCase("Foo");
    }
}
