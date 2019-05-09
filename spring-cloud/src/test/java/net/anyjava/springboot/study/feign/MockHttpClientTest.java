package net.anyjava.springboot.study.feign;

import feign.RetryableException;
import lombok.extern.slf4j.Slf4j;
import net.anyjava.springboot.study.StudyApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = StudyApplication.class)
public class MockHttpClientTest {

    @Autowired
    MockHttpClient mockHttpClient;

    @Test
    public void testFeignClient() {
        final int delaySecond = 1;
        assertThat(mockHttpClient).isNotNull();

        log.info(">> {}", mockHttpClient.getDelayedResponse(delaySecond));
    }

    @Test(expected = RetryableException.class)
    public void testFeignClient_TimeOutFail() {
        final int delaySecond = 2;
        assertThat(mockHttpClient).isNotNull();

        log.info(">> {}", mockHttpClient.getDelayedResponse(delaySecond));
    }

//    @Test(expected = FeignException.class) # ErrorDecoder 가 없다면 FeignException 발생
    @Test(expected = IllegalArgumentException.class)
    public void testInternalServerErrors() {
        mockHttpClient.getStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @Test
    public void test() {
        log.info("start");

        int count = Arrays.asList("a", "b", "c", "d").parallelStream()
                .peek(v -> log.error(">> {}", v))
                .collect(Collectors.toList()).size();

        log.info("end = {}", count);

        new ForkJoinPool(2).execute(() -> Arrays.asList("a", "b", "c", "d").parallelStream()
                .peek(v -> log.error(">> {}", v))
                .collect(Collectors.toList()));

        aBean.test();

        assertThat(count).isGreaterThan(0);
    }

    @Autowired
    private ABean aBean;
}

@Slf4j
@Component
class ABean {
    @Async
    public void test() {
        log.info("async job");
    }
}