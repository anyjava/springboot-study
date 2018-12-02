package net.anyjava.springboot.study;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MockHttpClientTest {

    @Autowired
    MockHttpClient mockHttpClient;

    @Test
    public void test() {
        final int delaySecond = 1;
        assertThat(mockHttpClient).isNotNull();

        log.info(">> {}", mockHttpClient.getDelayedResponse(delaySecond));
    }
}