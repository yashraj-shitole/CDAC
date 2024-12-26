package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.pojo.Course;

public interface CourseDao extends JpaRepository<Course, Long> {

}
