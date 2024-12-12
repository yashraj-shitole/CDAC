package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.dependent.PublicSchool;

public class TestSpringContainer {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx=
				new ClassPathXmlApplicationContext("bean_config.xml")) {
			System.out.println("SC up n running !");
			//get public school bean , to invoke B.L
			PublicSchool school=ctx.getBean("public_school", PublicSchool.class);
	//B.L
			school.manageAcademics();
			school.organizeSportsEvent();
		
			PublicSchool school2=ctx.getBean("public_school", PublicSchool.class);
			System.out.println(school == school2);//true

			
		} //JVM - ctx.close() => SC shutting down -> checks for singleton beans -> calls 
		//destroy method -> marks for GC

	}

}
