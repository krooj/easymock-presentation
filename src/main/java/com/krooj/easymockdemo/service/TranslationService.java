package com.krooj.easymockdemo.service;

import com.krooj.easymockdemo.domain.Language;

import java.util.List;

/**
 * Created by Michael on 11/12/14.
 */
public interface TranslationService {

    public List<Language> retrieveSupportedLanguages() throws TranslationServiceException;

    public String retrieveTranslation(String target) throws TranslationServiceException;

}
