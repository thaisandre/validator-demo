package com.example.demo.person;

import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface PersonRepository extends Repository<Person, Long> {

    Optional<Person> findByEmail(String email);

    Person save(Person person);
}
