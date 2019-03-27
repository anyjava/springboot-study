package net.anyjava.springboot.reactive.async;

import lombok.extern.slf4j.Slf4j;
import net.anyjava.springboot.reactive.ReactiveApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Executor;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {ReactiveApplication.class})
public class AsyncSampleTest {

    @Test
    public void parallelStreamTest() {

        long sum = IntStream.range(1, 100).parallel()
                .peek(v -> log.info("idx = {}", v))
                .sum();

        log.info("sum = {}", sum);
    }

    @Autowired
    private Executor executor;

    @Test
    public void taskExecutor() {
        assertThat(executor).isNotNull();
        log.info("taskExecutor = {}", executor);
    }
}