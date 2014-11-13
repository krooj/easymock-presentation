package com.krooj.easymockdemo.controller;

import com.krooj.easymockdemo.domain.Language;
import com.krooj.easymockdemo.service.TranslationService;
import com.krooj.easymockdemo.service.TranslationServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Michael on 11/12/14.
 */
@RestController("/translate")
public class TranslationController {

    private TranslationService translationService;

    @Autowired
    public TranslationController(TranslationService translationService){
        this.translationService = translationService;
    }

    @RequestMapping(value = "/languages", method = RequestMethod.GET)
    public List<Language> retrieveSupportedLanguages() throws TranslationServiceException{
        return this.translationService.retrieveSupportedLanguages();
    }

    @ExceptionHandler(TranslationServiceException.class)
    public ResponseEntity<String> handleException(TranslationServiceException t){
        return new ResponseEntity<>(t.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }

}
