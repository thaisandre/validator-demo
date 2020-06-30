package com.example.demo.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class UniqueCompanyCodeValidator implements Validator {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return CompanyDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CompanyDto companyDto = (CompanyDto) target;

        if(!errors.hasErrors()) {
            Optional<Company> possibleCompany = companyRepository.findByCode(companyDto.getCode());
            if(possibleCompany.isPresent()) {
                errors.rejectValue("code", null,companyDto.getCode() + " code already exists in the system.");
            }
        }
    }
}
