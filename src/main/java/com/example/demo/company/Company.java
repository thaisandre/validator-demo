package com.example.demo.company;

import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Company {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String code;
    private String fantasyName;

    @Deprecated
    public Company() {}

    public Company(@NotBlank String name, @NotBlank String code, @NotBlank String fantasyName) {
        Assert.notNull(name, "name cannot be null or empty");
        Assert.notNull(code, "code cannot be null or empty");
        Assert.notNull(fantasyName, "fantasyName cannot be null or empty");
        this.name = name;
        this.code = code;
        this.fantasyName = fantasyName;
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

    public String getFantasyName() {
        return fantasyName;
    }
}
