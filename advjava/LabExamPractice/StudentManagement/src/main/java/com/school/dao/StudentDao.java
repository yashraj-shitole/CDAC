package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.pojo.Student;

public interface StudentDao extends JpaRepository<Student, Long> {

}
