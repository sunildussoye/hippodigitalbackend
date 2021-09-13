package com.hippo.exercise;

import com.hippo.exercise.model.PostCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestClientTest {

    @Autowired
    private RestTemplate template;

    @Test
    public void postCodeTemplateTest() throws Exception {
        PostCode postCode = template.getForObject(
                "https://api.postcodes.io/postcodes/LE11AD",
                PostCode.class);

        assertThat(postCode.getResult().getRegion().equalsIgnoreCase("Leicester"));
    }

}
