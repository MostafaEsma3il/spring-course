package com.mostafaesmail.springcoredemo.rest;

import com.mostafaesmail.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    // define private field for dependency
    private Coach myCoach;

    // define a setter for DI
    @Autowired
    public void setMyCoach(Coach myCoach) {
        this.myCoach = myCoach;
    }

    // expose endpoint for "/dailyworkout"
    @GetMapping("/dailyworkout")
    public String getDailyWorkout () {
        return myCoach.getDailyWorkout();
    }

}
