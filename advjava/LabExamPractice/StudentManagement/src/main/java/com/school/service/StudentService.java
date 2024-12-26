package com.school.service;

import com.school.dto.ApiResponse;
import com.school.dto.StudentDTO;

public interface StudentService {

	ApiResponse addStudent(StudentDTO student);

}
