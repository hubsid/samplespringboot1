package com.sidh.springboot.testqueryextraction.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("dev")
public class DevController {

    @GetMapping("/profilespecific")
    public String onlyfordev() {
        return "hello the world of developers";
    }
}
