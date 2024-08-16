package com.mostafaesmail.springcoredemo.rest;

import com.mostafaesmail.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    // define private field for dependency
    private Coach myCoach;

    private Coach anotherCoach;

    // define a constructor for DI
    @Autowired
    public DemoRestController(@Qualifier("cricketCoach") Coach myCoach,
                              @Qualifier("cricketCoach") Coach anotherCoach) {
        System.out.println("In Constructor: " + getClass().getSimpleName());
        this.myCoach = myCoach;
        this.anotherCoach = anotherCoach;
    }

    // expose endpoint for "/dailyworkout"
    @GetMapping("/dailyworkout")
    public String getDailyWorkout () {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check () {
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }

}
