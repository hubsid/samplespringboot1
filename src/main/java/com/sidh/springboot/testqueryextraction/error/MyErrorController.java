package com.sidh.springboot.testqueryextraction.error;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class MyErrorController extends BasicErrorController {

    public MyErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
        super(errorAttributes, errorProperties);
    }

    static class ErrorType {
        String message;
        Exception exception;
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ErrorType getErrorCode() {
        return null;
    }
}
