package net.anyjava.springboot.study.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Mock Api 서비스,
 * <a href="http://httpbin.org">httpbin</a>
 */
@FeignClient(name = "httpbin", url = "http://httpbin.org")//configuration = FeignConfiguration.class)
public interface MockHttpClient {

    @GetMapping("/delay/{second}")
    HttpBinResponse getDelayedResponse(@PathVariable("second") int delaySecond);

    @GetMapping("/status/{code}")
    String getStatusCode(@PathVariable("code") int statusCode);
}