package com.sidh.springboot.testqueryextraction.customization;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

@Configuration
public class CustomHttpMessageConvertors {

    public HttpMessageConverters httpMessageConverters() {
        return null;
    }
}
