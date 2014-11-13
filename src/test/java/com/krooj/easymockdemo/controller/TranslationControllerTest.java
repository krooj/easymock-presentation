package com.krooj.easymockdemo.controller;

import com.krooj.easymockdemo.domain.Language;
import com.krooj.easymockdemo.service.TranslationService;
import com.krooj.easymockdemo.service.TranslationServiceException;
import org.easymock.EasyMock;
import org.easymock.EasyMockSupport;
import org.easymock.IMocksControl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Michael on 11/12/14.
 */
public class TranslationControllerTest extends EasyMockSupport {

    private TranslationController translationController;

    private TranslationService translationService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        translationService = createMock(TranslationService.class);
        translationController = new TranslationController(translationService);
    }

    /**
     * Asserts the ability to successfully retrieve a list of the supported languages
     * from the translation service.
     *
     * @throws Exception
     */
    @Test
    public void testRetrieveLanguages_success() throws Exception {
        //Prepare
        List<Language> supportedLanguages = Arrays.asList(new Language[]{new Language().setCode("en"), new Language().setCode("fr"), new Language().setCode("es")});

        //Expect
        EasyMock.expect(translationService.retrieveSupportedLanguages()).andReturn(supportedLanguages).times(1);

        //Replay
        replayAll();

        //Execute
        List<Language> returnedSupportedLanguages = translationController.retrieveSupportedLanguages();

        //Assert
        Assert.assertNotNull(returnedSupportedLanguages);
        Assert.assertTrue(returnedSupportedLanguages.size() == 3);

        //Verify
        verifyAll();
    }

    /**
     * Asserts the behaviour of the translation controller when a {@link com.krooj.easymockdemo.service.TranslationServiceException}
     * is thrown.
     *
     * @throws Exception
     */
    @Test
    public void testRetrieveLanguages_fail_TranslationServiceException() throws Exception {
        //Prepare
        TranslationServiceException tsex = new TranslationServiceException("TEST");
        expectedException.expect(TranslationServiceException.class);
        expectedException.expectMessage("TEST");

        //Expect
        EasyMock.expect(translationService.retrieveSupportedLanguages()).andThrow(tsex);

        //Replay
        replayAll();

        //Execute
        translationController.retrieveSupportedLanguages();

        //Verify
        verifyAll();
    }

}
