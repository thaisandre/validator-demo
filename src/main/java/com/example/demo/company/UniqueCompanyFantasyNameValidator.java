package com.example.demo.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;

import java.util.Optional;

@Component
public class UniqueCompanyFantasyNameValidator implements Validator {

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
            Optional<Company> possibleCompany = companyRepository.findByFantasyName(companyDto.getFantasyName());
            if(possibleCompany.isPresent()) {
                errors.rejectValue("fantasyName", null,companyDto.getFantasyName() + " fantasy name already exists in the system.");
            }
        }
    }
}
