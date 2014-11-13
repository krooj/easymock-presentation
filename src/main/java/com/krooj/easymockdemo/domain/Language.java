package com.krooj.easymockdemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Michael on 11/12/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Language {

    @JsonProperty(value = "language")
    private String code;

    public String getCode() {
        return code;
    }

    public Language setCode(String code) {
        this.code = code;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Language language = (Language) o;

        if (!code.equals(language.code)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
}
