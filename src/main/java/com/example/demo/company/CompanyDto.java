package com.example.demo.company;

import com.example.demo.annotation.ValidatedBy;

import javax.validation.constraints.NotBlank;

@ValidatedBy({UniqueCompanyCodeValidator.class, UniqueCompanyFantasyNameValidator.class})
public class CompanyDto {

    @NotBlank private String name;
    @NotBlank private String code;
    @NotBlank private String fantasyName;

    public void setName(String nome) {
        this.name = nome;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public String getCode() {
        return this.code;
    }

    public String getFantasyName() {
        return this.fantasyName;
    }

    public Company toModel() {
        return new Company(this.name, this.code, this.fantasyName);
    }

}
