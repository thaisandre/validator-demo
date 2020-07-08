package com.example.demo.person;


import com.example.demo.annotation.ValidatedBy;

import javax.validation.constraints.NotBlank;

@ValidatedBy(UniqueEmailValidator.class)
public class NewPersonDto {

    @NotBlank private String name;
    @NotBlank private String email;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person toModel(){
        return new Person(this.name, this.email);
    }

    public String getEmail() {
        return this.email;
    }

}
