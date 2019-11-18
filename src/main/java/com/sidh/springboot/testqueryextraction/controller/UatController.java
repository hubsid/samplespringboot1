package com.sidh.springboot.testqueryextraction.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("uat")
public class UatController {

    @GetMapping("/profilespecific")
    public String onlyforuat() {
        return "Hello uat world !";
    }
}
