package com.hippo.exercise.service;

import com.hippo.exercise.model.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrimeByPostCodeServiceTest {

    @Autowired
    private CrimeByPostCodeService crimeByPostCodeService;

    @Test
    public void getCrimeRateWithValidPostCodeMustNotBeNull() {

        Response[] responses = crimeByPostCodeService.getCrimeRate(53.410523, -1.45021);
        assertTrue(responses.length > 0);

    }

    @Test
    public void getCrimeRateWithValidPostCodeMustBeNull() {

        Response[] responses = crimeByPostCodeService.getCrimeRate(9953.410523, -1.45021);
        assertTrue(responses.length == 0);

    }

}

