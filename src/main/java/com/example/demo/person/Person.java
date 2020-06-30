package com.example.demo.person;

import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;

    @Deprecated
    public Person() {}

    public Person(@NotBlank String name, @NotBlank @Email String email) {
        Assert.hasText(name, "name cannot be null or empty");
        Assert.hasText(email, "email cannot be null or empty");
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
