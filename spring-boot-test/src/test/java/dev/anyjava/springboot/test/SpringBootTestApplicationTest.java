package dev.anyjava.springboot.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class SpringBootTestApplicationTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testContext() {
        log.info("dataSource={}", dataSource);
        assertThat(dataSource).isNotNull();
    }
}