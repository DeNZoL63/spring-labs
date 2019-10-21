package com.luxoft.springioc.lab3.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("language")
public class Language {
    @Value("${language.id}")
    private Long id;
    @Value("${language.code}")
    private String code;
    @Value("${language.name}")
    private String name;

    public Language() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String  toString() {
        return "Language{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Language language = (Language) obj;

        if (!Objects.equals(code, language.code)) return false;
        if (!Objects.equals(name, language.name)) return false;

        return true;
    }
}
