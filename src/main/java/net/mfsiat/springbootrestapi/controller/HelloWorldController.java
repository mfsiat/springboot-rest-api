package net.mfsiat.springbootrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    //  Create the REST API
    //  HTTP GET Request
    //  http://localhost:8080/hello-world

    @GetMapping("/hello-world")
    public String helloWord(){
        return "Hello World";
    }
}
