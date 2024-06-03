package com.example.springMVC.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/header")
public class SixthController {

    @GetMapping()
    public String handle(
            @RequestHeader("User-Agent") String host) {
        System.out.println(host);
        return host ;
    }
}
