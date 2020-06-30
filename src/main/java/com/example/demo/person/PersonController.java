package com.example.demo.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/person")
    public ResponseEntity<?> form(@Valid @RequestBody NewPersonDto personDto) {
        Person person = personRepository.save(personDto.toModel());
        return ResponseEntity.ok(new PersonOutputDto(person));
    }
}
