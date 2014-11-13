package com.krooj.easymockdemo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Michael on 11/13/14.
 */
public class Data {

    @JsonProperty("languages")
    private List<Language> languages;

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }
}