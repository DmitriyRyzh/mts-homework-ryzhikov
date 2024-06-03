package com.example.springMVC.controllers;


import com.example.springMVC.entities.User;
import com.example.springMVC.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wrongUser")
public class FifthController {

    @GetMapping()
    public String testExceptionHandler(String name)
            throws UserNotFoundException {
        if (name.length()<5) {
            throw new UserNotFoundException();
        }
        return "OK";
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String handleException(UserNotFoundException e) {
        return e.getMessage();
    }
}
