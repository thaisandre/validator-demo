package com.example.demo.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class UniqueEmailValidator implements Validator {

    @Autowired
    private PersonRepository pessoaRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return NewPersonDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NewPersonDto newPersonDto = (NewPersonDto) target;

        Optional<Person> possiblePerson = this.pessoaRepository.findByEmail(newPersonDto.getEmail());

        if(possiblePerson.isPresent()) {
            errors.rejectValue("email", "newPersonDto.unique.email", newPersonDto.getEmail() + " already exists in the system.");
        }
    }
}
