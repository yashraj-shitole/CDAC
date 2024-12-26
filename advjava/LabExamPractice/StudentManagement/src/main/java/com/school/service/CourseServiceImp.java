package com.school.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dao.CourseDao;
import com.school.dao.StudentDao;
import com.school.dto.ApiResponse;
import com.school.dto.CourseDTO;
import com.school.dto.CourseUpdateDTO;
import com.school.pojo.Category;
import com.school.pojo.Course;
import com.school.pojo.Student;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CourseServiceImp implements CourseService {

	
	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addCourse(CourseDTO course) {
		
		if (course.getEndDate().isBefore(course.getStartDate())) {
			
			return new ApiResponse(LocalDateTime.now(), "Course start date cant be greater than end date");
		}
		
		Course c=mapper.map(course, Course.class);
		
		
		
		c.setGrade("C");
		courseDao.save(c);
		
		return new ApiResponse(LocalDateTime.now(), "Course added with id "+c.getId());
	}

	
	//update course
	@Override
	public ApiResponse updateCourse(CourseUpdateDTO course, Long courseId) {
		
			
		if (course.getEndDate().isBefore(course.getStartDate())) {
			return new ApiResponse(LocalDateTime.now(), "Course start date cant be greater than end date");
		}

		
		Optional<Course> c=courseDao.findById(courseId);
		
		
		
		c.get().setStartDate(course.getStartDate());
		c.get().setEndDate(course.getEndDate());
		c.get().setFee(course.getFee());
		
		if (c.isEmpty()) {
			
			return new ApiResponse(LocalDateTime.now(), "Course dosent exist");
		}
		
				
		courseDao.save(c.get());
		
		return new ApiResponse(LocalDateTime.now(), "Course updated");
	}


	@Override
	public List<Course> getUserByCategory(Category category) {
		
		List<Course> courses=new ArrayList<>();
		
		for(Course c: courseDao.findAll()) {
			if (c.getCategory().name().equals(category.name())) {
				courses.add(c);
			}
		}
		
		return courses;
	}


	@Override
	public List<Student> getStudentsByCourse(String courseName) {
		
		
		List<Student> students=new ArrayList<>();
		
		for(Student s: studentDao.findAll()) {
			
			if (s.getCourse().getName().equals(courseName)) {
				students.add(s);
			}
			
		}
		
		
		return students;
	}
	
}
