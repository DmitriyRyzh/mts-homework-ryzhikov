package com.example.springMVC.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/params")
public class ForthController {

    @GetMapping({"/param/{name}","/param"})
    @ResponseBody
    public String param(@PathVariable String name) {

        return name;
    }

    // Или их надо было вытащить в одном Get?
    @GetMapping({"/param/{name}","/params"})
    @ResponseBody
    public String params(@RequestParam String name) {
        //
        return name;
    }
}
