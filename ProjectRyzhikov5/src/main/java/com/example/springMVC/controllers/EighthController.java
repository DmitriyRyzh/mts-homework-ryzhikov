package com.example.springMVC.controllers;

import com.example.springMVC.exceptions.CustomException;
import com.example.springMVC.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class EighthController {

    @GetMapping()
    public void testCustomException(String name) throws CustomException {
            throw new CustomException();
    }

    @ExceptionHandler(CustomException.class)
    public String handleException(CustomException e) {
        return e.getMessage();
    }
}
