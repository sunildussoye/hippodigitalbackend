package com.hippo.exercise.service;

import com.hippo.exercise.exception.ResultException;
import com.hippo.exercise.model.PostCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.Assert.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostCodeServiceTest {

    @Autowired
    private PostCodeService postCodeService;

    @Test
    public void invalidPostCodeMustReturnAnException() {

        Exception exception = assertThrows(ResultException.class, () -> {
            postCodeService.getPostCode("anything");
        });

        String expectedMessage = "Invalid post Code or Not found";
        String actualMessage   = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void validPostCodeMustReturnValue() {

        PostCode postCode = postCodeService.getPostCode("YO424LT");
        assertThat(postCode.getResult().getNuts()).isEqualTo("East Riding of Yorkshire");
    }

}
