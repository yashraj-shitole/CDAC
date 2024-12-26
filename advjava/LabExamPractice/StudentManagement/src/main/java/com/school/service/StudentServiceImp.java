package com.school.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dao.CourseDao;
import com.school.dao.StudentDao;
import com.school.dto.ApiResponse;
import com.school.dto.StudentDTO;
import com.school.pojo.Course;
import com.school.pojo.Student;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentServiceImp implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CourseDao courseDao;
	
	@Override
	public ApiResponse addStudent(StudentDTO student) {

		Student s=mapper.map(student, Student.class);
		
		Optional<Course> course=courseDao.findById(student.getCourseId());
		
		if (course.isEmpty()) {			
			return new ApiResponse(LocalDateTime.now(), "Course doesnot exist ");
		}
		
		s.setCourse(course.get());
		
	
		studentDao.save(s);
		
		return new ApiResponse(LocalDateTime.now(), "Student created with id "+s.getId());
	}
	
}
