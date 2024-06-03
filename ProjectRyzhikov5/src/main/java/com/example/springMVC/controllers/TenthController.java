package com.example.springMVC.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/name")
public class TenthController {

    @GetMapping//("/ids")
    public String getName(@RequestParam(defaultValue = "default") String name){
        return "Имя: " + name;
    }
}
