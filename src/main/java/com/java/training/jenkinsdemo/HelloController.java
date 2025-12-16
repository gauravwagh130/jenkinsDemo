package com.java.training.jenkinsdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(value = "/gretting")
    public String Hello() {
        return "Welcome to JenkinsDemo";
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello...";
    }
}
