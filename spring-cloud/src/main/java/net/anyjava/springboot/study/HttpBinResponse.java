package net.anyjava.springboot.study;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class HttpBinResponse {
    private Object args;
    private String data;
    private Object files;
    private Object form;
    private BinHeader headers;
    private String origin;
    private String url;
}

@Getter
@ToString
class BinHeader {
    @JsonProperty("Accept")
    private String accept;
    @JsonProperty("Connection")
    private String connection;
    @JsonProperty("Host")
    private String host;
    @JsonProperty("User-Agent")
    private String userAgnet;
}
