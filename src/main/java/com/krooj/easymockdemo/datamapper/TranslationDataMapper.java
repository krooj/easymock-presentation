package com.krooj.easymockdemo.datamapper;

import com.krooj.easymockdemo.domain.Language;

import java.util.List;

/**
 * Created by Michael on 11/12/14.
 */
public interface TranslationDataMapper {

    public List<Language> retrieveSupportedLanguages() throws DataMapperException;


}
