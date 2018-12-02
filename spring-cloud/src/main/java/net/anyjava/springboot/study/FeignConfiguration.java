package net.anyjava.springboot.study;

import feign.Contract;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Eureka 를 사용하지 않는다면, 직접 configuration 을 설정해 주어야 한다.
 */
@Slf4j
@Configuration
public class FeignConfiguration {

    @Bean
    public Contract feignContract() {
        log.info("==================================anyjava");
        return new SpringMvcContract();
//        return new Contract.Default();
    }
}
