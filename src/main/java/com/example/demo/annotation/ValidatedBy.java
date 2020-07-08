package com.example.demo.annotation;

import org.springframework.validation.Validator;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidatedBy {

    Class<? extends Validator>[] value();
}
