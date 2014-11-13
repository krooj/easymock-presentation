package com.krooj.easymockdemo.service;

import com.krooj.easymockdemo.datamapper.DataMapperException;
import com.krooj.easymockdemo.datamapper.TranslationDataMapper;
import com.krooj.easymockdemo.domain.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Michael on 11/12/14.
 */
@Service
public class TranslationServiceImpl implements TranslationService {

    private TranslationDataMapper translationDataMapper;

    @Autowired
    public TranslationServiceImpl(TranslationDataMapper translationDataMapper){
        this.translationDataMapper = translationDataMapper;
    }

    @Override
    public List<Language> retrieveSupportedLanguages() throws TranslationServiceException {
        try{
            return this.translationDataMapper.retrieveSupportedLanguages();
        }catch(DataMapperException e){
            throw new TranslationServiceException("DataMapperException occurred while attempting to retrieve supported languages", e);
        }
    }

    @Override
    public String retrieveTranslation(String target) throws TranslationServiceException {
        return null;
    }
}
