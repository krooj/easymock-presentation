package com.krooj.easymockdemo.datamapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.krooj.easymockdemo.domain.Language;
import com.krooj.easymockdemo.domain.LanguageListDataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Michael on 11/12/14.
 */
@Repository
public class GoogleTranslateDataMapperImpl implements TranslationDataMapper{

    private String clientKey;

    private RestTemplate restTemplate;

    @Autowired
    public GoogleTranslateDataMapperImpl(RestTemplate restTemplate,
                                         @Value("${com.krooj.easymock.datamapper.Google.api.key}")String clientKey){
        this.restTemplate = restTemplate;
        this.clientKey = clientKey;
    }

    @Override
    public List<com.krooj.easymockdemo.domain.Language> retrieveSupportedLanguages() throws DataMapperException {
        try{
            String targetUrl = "https://www.googleapis.com/language/translate/v2/languages?key={clientKey}";
            LanguageListDataWrapper langWrapper = this.restTemplate.getForObject(targetUrl, LanguageListDataWrapper.class, this.clientKey);
            return langWrapper.getData().getLanguages();
        }catch(Exception e){
            throw new DataMapperException(e.getClass().getSimpleName()+" occurred while trying to retrieve a list of supported languages",e);
        }
    }


}
