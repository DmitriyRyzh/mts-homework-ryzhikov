package com.example.springMVC.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("Некорректное имя пользователя");
    }
}