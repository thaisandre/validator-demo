package com.example.demo.validation;

import com.example.demo.annotation.ValidatedBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.*;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestControllerAdvice
public class ValidationControllerAdvice {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private MessageSource messageSource;

    @InitBinder
    public void initBinderDto(WebDataBinder webDataBinder){
        Object target = webDataBinder.getTarget();

        if (target != null && target.getClass().isAnnotationPresent(ValidatedBy.class)) {
            List<Class<? extends Validator>> classes = Arrays.asList(target.getClass().getAnnotation(ValidatedBy.class).value());
            classes.forEach(clazz -> webDataBinder.addValidators(applicationContext.getBean(clazz)));
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationErrorsDto handler(MethodArgumentNotValidException exception) {
        List<ObjectError> globalErrors = exception.getBindingResult().getGlobalErrors();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        ValidationErrorsDto validationErrorsDto = new ValidationErrorsDto();

        globalErrors.forEach(error -> validationErrorsDto.addGlobalError(getErrorMessage(error)));
        fieldErrors.forEach(error -> validationErrorsDto.addFieldError(error.getField(), getErrorMessage(error)));

        return validationErrorsDto;
    }

    private String getErrorMessage(ObjectError error) {
        return messageSource.getMessage(error, LocaleContextHolder.getLocale());
    }
}
