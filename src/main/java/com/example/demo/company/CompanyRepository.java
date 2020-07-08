package com.example.demo.company;

import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface CompanyRepository extends Repository<Company, Long> {

    Optional<Company> findByCode(String code);

    Optional<Company> findByFantasyName(String fantasyName);

    Company save(Company company);

}
