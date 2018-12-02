package net.anyjava.springboot.study;

import feign.Response;
import feign.codec.ErrorDecoder;

class FeignSampleErrorDecode implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey,
                            Response response) {
        if (response.status() != 200)
            throw new IllegalArgumentException("bad zone name");
        return new ErrorDecoder.Default().decode(methodKey, response);
    }
}