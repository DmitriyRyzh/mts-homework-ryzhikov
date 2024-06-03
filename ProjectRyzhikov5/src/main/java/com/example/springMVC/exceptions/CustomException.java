package com.example.springMVC.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CustomException extends Exception{
    public CustomException() {
        super("Сервис не найден");
    }
}
