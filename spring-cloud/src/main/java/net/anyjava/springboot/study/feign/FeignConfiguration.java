package net.anyjava.springboot.study.feign;

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

    /**
     * 아래 Bean 설정은 꼭 필수로 해야하는건 아닙니다.
     * org.springframework.cloud:spring-cloud-starter-openfeign 을 사용하면 org.springframework.cloud.openfeign.support.SpringMvcContract 을 자동으로 Bean 생성을 해줍니다.
     *
     * @GetMapping @PostMapping 등을 사용할 수 있음.
     */
    @Bean
    public Contract feignContract() {
        return new SpringMvcContract();
    }
}
