package com.example.springMVC.controllers;

import com.example.springMVC.exceptions.IncorrectDateException;
import com.example.springMVC.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@RestController
@RequestMapping("/dates")
public class NinthController {

    // Проверка формата в GetMapping - если дата невалидна - сервис будет не найден
    /*@GetMapping("/checkDate/{date:^\\d{4}-\\d{2}-\\d{2}$}")
    @ResponseBody
    public String CheckDate(@PathVariable String date) throws IncorrectDateException {
        System.out.println(date);
            return date;
    }*/

    // Проверка формата внутри метода - в качестве результата будет отправлен текст ошибки
    //@GetMapping("/checkDate/{date:^\\d{4}-\\d{2}-\\d{2}$}")
    @GetMapping("/checkDate2/{date}")
    @ResponseBody
    public String CheckDate2(@PathVariable String date) throws IncorrectDateException {
        System.out.println(date);
        if (DateMatcher(date)) {
        return date;
        } else throw new IncorrectDateException();
    }

    @ExceptionHandler(IncorrectDateException.class)
    public String handleException(IncorrectDateException e) {
        return e.getMessage();
    }

    public boolean DateMatcher(String date) {

        Pattern DATE_PATTERN = Pattern.compile(
                //"^\\d{4}-\\d{2}-\\d{2}$");
                "^((2000|2400|2800|(19|2[0-9])(0[48]|[2468][048]|[13579][26]))-02-29)$"
                + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
                + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"
                + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$");
        return DATE_PATTERN.matcher(date).matches();
    }
}
