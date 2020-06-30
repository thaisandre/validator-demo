package com.example.demo.person;


import com.example.demo.validation.HasValidators;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class NewPersonDto implements HasValidators {

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

    public List<Class<? extends Validator>> validators() {
        return (List.of(UniqueEmailValidator.class));
    }

}
