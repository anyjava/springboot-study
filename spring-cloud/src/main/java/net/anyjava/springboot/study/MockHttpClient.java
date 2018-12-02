package net.anyjava.springboot.study;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Mock Api 서비스,
 * <a href="http://httpbin.org">httpbin</a>
 */
@FeignClient(name = "httpbin", url = "http://httpbin.org")//configuration = FeignConfiguration.class)
public interface MockHttpClient {

    @RequestMapping(method = RequestMethod.GET, value = "/delay/{second}")
    String getDelayedResponse(@PathVariable("second") int delaySecond);
}