package com.example.demo.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestControllerAdvice
public class ValidationControllerAdvice {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private MessageSource messageSource;

    @InitBinder
    public void initBinderDto(WebDataBinder webDataBinder){
        HasValidators dto = (HasValidators) webDataBinder.getTarget();
        dto.validators().forEach(
            (Class<? extends Validator> validatorClass) -> {
                webDataBinder.addValidators(applicationContext.getBean(validatorClass));
            });
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
