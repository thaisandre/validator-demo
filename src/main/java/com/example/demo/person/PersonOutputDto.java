package com.example.demo.person;

public class PersonOutputDto {

    private Long id;
    private String name;
    private String email;

    public PersonOutputDto(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.email = person.getEmail();
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
