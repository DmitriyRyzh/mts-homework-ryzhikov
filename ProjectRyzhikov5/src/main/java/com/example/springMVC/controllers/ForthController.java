package com.example.springMVC.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/params")
public class ForthController {

    @GetMapping({"/param/{id}"})
    @ResponseBody
    public String params(@RequestParam String name , @PathVariable String id) {
        return "Id: " + id + ", Name: " + name;
        // Пример запроса: http://localhost:8080/params/param/1?name=MyName
    }
}
