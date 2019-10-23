package net.anyjava.springboot.study.datajpa;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@Slf4j
public class FooDomainTest {

    @Test
    public void lambda_객체는_여러개만들어질까_NO_sigleton() {
        String name = "cuddy";
        log.info("FooDomainTest = {}", this);
        long count = Stream.of("1", "2", "3")
                .peek(new DummyConsumer())
                .peek(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        log.info("{}, i={}, nam={}", s, this, name);
                    }
                })
                .count();
    }
}

@Slf4j
class DummyConsumer implements Consumer<String> {
    @Override
    public void accept(String v) {
        log.info("value = {}, instance={}", v, this);
    }
}