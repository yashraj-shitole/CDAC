package com.cdac.dependency;

import org.springframework.stereotype.Component;

//singleton n eager , id=cricket
@Component("cricket")
public class CricketCoach implements Coach {

    public CricketCoach() {
    	System.out.println("In constructor - " + getClass());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
