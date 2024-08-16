package com.mostafaesmail.springcoredemo.rest;

import com.mostafaesmail.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    // define private field for dependency
    private Coach myCoach;

    // define a constructor for DI
    @Autowired
    public DemoRestController(Coach theCoach) {
        this.myCoach = theCoach;
    }


    // expose endpoint for "/dailyworkout"
    @GetMapping("/dailyworkout")
    public String getDailyWorkout () {
        return myCoach.getDailyWorkout();
    }

}
