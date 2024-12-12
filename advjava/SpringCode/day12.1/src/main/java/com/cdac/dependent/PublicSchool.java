package com.cdac.dependent;

import com.cdac.dependency.Coach;
import com.cdac.dependency.Teacher;

public class PublicSchool implements School {
	private Teacher subjectTeacher;// dependency - optional
	private Coach sportsCoach;// mandatory
	// mandatory depcy - funds
	private long funds;

	// constructor based D.I - use it for mandatory dependencies !
	public PublicSchool(Coach myCoach, long money) {
		this.sportsCoach = myCoach;
		this.funds = money;
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
		System.out.println("preparing for sports event ....");
		System.out.println(sportsCoach.getDailyWorkout());

	}

	// custom init method - will get called for singleton as well as prototypes -
	// after D.I
	public void myInit() {
		System.out.println("in init");
	}

	// custom destroy method - will be called ONLY for singleton beans
	// @ SC shut down (ctx.close)
	public void myDestroy() {
		System.out.println("in destroy");
	}

	// optional dependency - subject teacher
	public void setSubjectTeacher(Teacher subjectTeacher) {
		this.subjectTeacher = subjectTeacher;
		System.out.println("in setter - teacher");
	}
	//add a getter for funds

	public long getFunds() {
		return funds;
	}
	

}
