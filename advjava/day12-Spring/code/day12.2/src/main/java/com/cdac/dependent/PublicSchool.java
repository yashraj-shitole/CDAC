package com.cdac.dependent;

import com.cdac.dependency.Coach;
import com.cdac.dependency.Teacher;

public class PublicSchool implements School {
	private Teacher subjectTeacher;// =new EnglishTeacher();
	private Coach sportsCoach;

	// constructor based D.I
	public PublicSchool(Teacher myTeacher) {
		this.subjectTeacher = myTeacher;
		System.out.println("In constructor - " + getClass());
	}
	//setter based D.I
		public void setSportsCoach(Coach sportsCoach123) {
			System.out.println("in set - coach");
			this.sportsCoach = sportsCoach123;
		}

	@Override
	// B.L
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		subjectTeacher.teach();
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
