package com.cdac.dependent;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cdac.dependency.Coach;
import com.cdac.dependency.Teacher;

//singleton n eager , maths teacher m swimming coach
@Component("public_school")
public class PublicSchool implements School {
	@Autowired// (required = false)//byType
	@Qualifier("mathsTeacher") //byName
	private Teacher subjectTeacher;
	@Autowired//(required = false)//(required = true)
	@Qualifier("swimming")
	private Coach sportsCoach;

	
	public PublicSchool() {
	
		System.out.println("In constructor - " + getClass());
	}

	@Override
	// B.L
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		subjectTeacher.teach();
	}

	@Override
	public void organizeSportsEvent() {
		System.out.println("organize sports event ....");
		System.out.println(sportsCoach.getDailyWorkout());

	}

	// custom init method
	@PostConstruct
	public void myInit() {
		System.out.println("in init");
	}

	// custom destroy method
	@PreDestroy
	public void myDestroy() {
		System.out.println("in destroy");
	}
	

}
