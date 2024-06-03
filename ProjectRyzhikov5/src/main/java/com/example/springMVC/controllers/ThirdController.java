package com.example.springMVC.controllers;

import com.example.springMVC.entities.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Validated
@RestController
@RequestMapping("/validate")
public class ThirdController {

    @GetMapping
    public String validate(@RequestParam("name")  @NotNull @NotBlank
                               String name,
                           @RequestParam("email") @NotNull @NotBlank
                           @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                                   + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
                                   String email) {
        // Аннотации не работают для пустых значений
        try {
            User user = new User(name, email);
            System.out.println(user.getEmail());
            System.out.println(user.getName());
            return "Регистрация успешна";
        } catch(Exception e) {
            return "Регистрация не прошла";
        }

    }
}
