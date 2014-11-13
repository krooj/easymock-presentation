package com.krooj.easymockdemo.service;

/**
 * Created by Michael on 11/12/14.
 */
public class TranslationServiceException extends Exception{

    public TranslationServiceException(String message) {
        super(message);
    }

    public TranslationServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
