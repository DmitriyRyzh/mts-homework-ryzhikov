package com.example.springMVC.controllers;

import com.example.springMVC.entities.SecondTaskEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greet")
public class SecondController {

    @PostMapping
    public String greet(@RequestBody SecondTaskEntity name) {
        System.out.println("NAME       "+ name.getName());
        return "Hello, " + name.getName();
    }

   /* @PostMapping
    public String greet(@RequestParam("name") SecondTaskEntity name) {
        System.out.println("NAME       "+ name.getName());
        return "Hello, " + name.getName();
    }*/
}
