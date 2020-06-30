package com.example.demo.company;

public class CompanyOutputDto {

    private Long id;
    private String name;
    private String code;

    public CompanyOutputDto(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.code = company.getCode();
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
