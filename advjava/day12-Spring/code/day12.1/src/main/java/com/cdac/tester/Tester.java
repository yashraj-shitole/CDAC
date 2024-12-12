package com.cdac.tester;

import com.cdac.dependency.MathsTeacher;
import com.cdac.dependent.PublicSchool;
import com.cdac.dependent.School;

public class Tester {

	public static void main(String[] args) {
		School mySchool=new PublicSchool(new MathsTeacher());
		mySchool.manageAcademics();

	}

}
