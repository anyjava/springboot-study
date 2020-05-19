package net.anyjava.springboot.study.datajpa.fetch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BarRepositoryTest {

    @Autowired
    BarRepository barRepository;

    @Test
//    @Transactional
    public void sampleTest() {
        barRepository.findAll();

        List<BarDomain> list = IntStream.range(0, 1000)
                .boxed()
                .map(v -> new BarDomain(Long.valueOf(v), "name"))
                .collect(Collectors.toList());

        barRepository.saveAll(list);
    }
}