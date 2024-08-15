package com.mostafaesmail.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose "/" that returns "Hello World"
    @GetMapping("/")
    public String sayHello () {
        return "<h1>Hello World</h1>";
    }

    // expose a new end point for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout () {
        return "Run a hard 5k!";
    }

    // expose a new end point for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune () {
        return "Today is your lucky day.";
    }
}
