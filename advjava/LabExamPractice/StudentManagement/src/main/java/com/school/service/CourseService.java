package com.school.service;

import java.util.List;

import com.school.dto.ApiResponse;
import com.school.dto.CourseDTO;
import com.school.dto.CourseUpdateDTO;
import com.school.pojo.Category;
import com.school.pojo.Course;
import com.school.pojo.Student;

public interface CourseService {

	ApiResponse addCourse(CourseDTO course);

	ApiResponse updateCourse(CourseUpdateDTO course,Long courseId);

	List<Course> getUserByCategory(Category category);

	List<Student> getStudentsByCourse(String courseName);

}
