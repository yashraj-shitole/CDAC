package com.school.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student extends Base {
	
	
@Column(name = "student_name",nullable = false)
private String studentName;

@Column(nullable = false,unique = true)
private String email;

@Column(nullable = false)
private String password;
 
@ManyToOne
@JoinColumn(name = "courseId")
private Course course;
	
	
}


//1. Sid (unique identifier for each Student)
//2. Sname (Cannot be Blank)
//3. Email (Cannot be Blank)
//4. Password (Cannot be Blank)
//5. Cid (Course ID, FK)