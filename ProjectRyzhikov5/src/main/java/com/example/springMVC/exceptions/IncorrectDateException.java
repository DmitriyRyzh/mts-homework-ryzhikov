package com.example.springMVC.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class IncorrectDateException extends Exception{
    public IncorrectDateException() {
        super("Невалидная дата");
    }
}
