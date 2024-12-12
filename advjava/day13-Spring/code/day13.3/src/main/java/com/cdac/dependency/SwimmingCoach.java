package com.cdac.dependency;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//prototype , id="swimming"
@Component("swimming")
@Scope("prototype")
public class SwimmingCoach implements Coach {

    public SwimmingCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up";
    }
}
