package com.example.demo.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping("/company")
    public ResponseEntity<CompanyOutputDto> save(@Valid @RequestBody CompanyDto companyDto){
        Company company = this.companyRepository.save(companyDto.toModel());
        return ResponseEntity.ok(new CompanyOutputDto(company));
    }
}
