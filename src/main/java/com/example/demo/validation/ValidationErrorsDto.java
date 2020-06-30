package com.example.demo.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorsDto {

    List<String> globalErros = new ArrayList<>();
    List<FieldErrorDto> fieldErrors = new ArrayList<>();

    public List<String> getGlobalErros() {
        return globalErros;
    }

    public List<FieldErrorDto> getFieldErrors() {
        return fieldErrors;
    }

    public void addFieldError(String field, String message) {
        fieldErrors.add(new FieldErrorDto(field, message));
    }

    public void addGlobalError(String message) {
        globalErros.add(message);
    }
}
