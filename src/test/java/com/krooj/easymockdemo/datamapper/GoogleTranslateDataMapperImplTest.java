package com.krooj.easymockdemo.datamapper;

import com.krooj.easymockdemo.domain.Data;
import com.krooj.easymockdemo.domain.Language;
import com.krooj.easymockdemo.domain.LanguageListDataWrapper;
import org.easymock.Capture;
import org.easymock.EasyMock;
import org.easymock.EasyMockSupport;
import org.easymock.IMocksControl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Michael on 11/12/14.
 */
public class GoogleTranslateDataMapperImplTest {

    private TranslationDataMapper googleTranslateDataMapper;

    private static final String TEST_CLIENT_KEY = "abc123";

    private RestTemplate restTemplate;

    private IMocksControl mocksControl;

    @Before
    public void setUp(){
        mocksControl = EasyMock.createControl();
        restTemplate = mocksControl.createMock(RestTemplate.class);
        googleTranslateDataMapper = new GoogleTranslateDataMapperImpl(restTemplate, TEST_CLIENT_KEY);
    }

    @Test
    public void testRetrieveSupportedLanguages_success() throws Exception {
        //Prepare
        Capture<String> urlCapture = new Capture<>();
        Capture<Class<LanguageListDataWrapper>> bindTypeCapture = new Capture<>();
        List<Language> languages = Arrays.asList(new Language().setCode("en"), new Language().setCode("fr"), new Language().setCode("es"));
        Data data = new Data();
        LanguageListDataWrapper lld = new LanguageListDataWrapper();
        data.setLanguages(languages);
        lld.setData(data);


        //Expect
        EasyMock.expect(restTemplate.getForObject(EasyMock.capture(urlCapture), EasyMock.capture(bindTypeCapture), EasyMock.eq(TEST_CLIENT_KEY))).andReturn(lld);

        //Replay
        mocksControl.replay();

        //Execute
        List<Language> supportedLanguages = googleTranslateDataMapper.retrieveSupportedLanguages();

        //Assert
        Assert.assertTrue(supportedLanguages.size() == 3);
        Assert.assertTrue(supportedLanguages.contains(new Language().setCode("en")));
        Assert.assertTrue(supportedLanguages.contains(new Language().setCode("fr")));
        Assert.assertTrue(supportedLanguages.contains(new Language().setCode("es")));

        /** Illustrate captures here ***/


        //Verify
        mocksControl.verify();
    }

}
