package dependent;

import dependency.Coach;
import dependency.Teacher;

public class PublicSchool implements School {	
	private Teacher subjectTeacher;
	
	public PublicSchool() {
		System.out.println("In constructor - " + getClass());
	}

	@Override
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		subjectTeacher.teach();
	}

	

}
