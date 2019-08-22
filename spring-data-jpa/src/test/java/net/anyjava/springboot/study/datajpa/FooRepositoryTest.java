package net.anyjava.springboot.study.datajpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class FooRepositoryTest {

    @Autowired
    private  FooRepository fooRepository;

    @Test
    public void test() {
        assertThat(fooRepository).isNotNull();
    }
}
