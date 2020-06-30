package com.example.demo.validation;

import org.springframework.validation.Validator;

import java.util.List;

public interface HasValidators {

    List<Class<? extends Validator>> validators();
}
