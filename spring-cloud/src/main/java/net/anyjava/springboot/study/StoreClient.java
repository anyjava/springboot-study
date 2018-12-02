package net.anyjava.springboot.study;

import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "articles", url = "http://scrap.api.anyjava.net:8080")//configuration = FeignConfiguration.class)
public interface StoreClient {

    @RequestMapping(method = RequestMethod.GET, value = "/articles")
//    @RequestLine("GET /articles")
    String getArticles();
}