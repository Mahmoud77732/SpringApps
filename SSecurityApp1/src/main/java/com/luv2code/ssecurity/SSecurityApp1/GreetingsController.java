package com.luv2code.ssecurity.SSecurityApp1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }
}
