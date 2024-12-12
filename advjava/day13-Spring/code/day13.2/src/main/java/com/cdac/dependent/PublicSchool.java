package com.cdac.dependent;

import com.cdac.dependency.Coach;
import com.cdac.dependency.Teacher;

public class PublicSchool implements School {
	private Teacher subjectTeacher;
	private Coach sportsCoach;

	//constr based D.I
	public PublicSchool(Teacher teacher,Coach coach) {
		this.subjectTeacher=teacher;
				this.sportsCoach=coach;
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
	public void myInit() {
		System.out.println("in init");
	}

	// custom destroy method
	public void myDestroy() {
		System.out.println("in destroy");
	}
	

}
