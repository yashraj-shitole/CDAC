package com.cdac.dependent;

import com.cdac.dependency.Coach;
import com.cdac.dependency.Teacher;

public class PublicSchool implements School {
	private Teacher subjectTeacher;// =new EnglishTeacher();
	

	// constructor based D.I
	public PublicSchool(Teacher myTeacher) {
		this.subjectTeacher = myTeacher;
		System.out.println("In constructor - " + getClass());
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
