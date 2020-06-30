package com.example.demo.company;

import com.example.demo.validation.HasValidators;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class CompanyDto implements HasValidators {

    @NotBlank private String name;
    @NotBlank private String code;

    public void setName(String nome) {
        this.name = nome;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public Company toModel() {
        return new Company(this.name, this.code);
    }

    public List<Class<? extends Validator>> validators() {
        return List.of(UniqueCompanyCodeValidator.class);
    }
}
