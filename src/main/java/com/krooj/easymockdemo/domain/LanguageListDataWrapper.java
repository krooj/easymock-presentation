package com.krooj.easymockdemo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Michael on 11/13/14.
 */
public class LanguageListDataWrapper {

    @JsonProperty("data")
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
