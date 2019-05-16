package com.test.mapper;

import com.test.bean.Student;

public interface StudentMapper {
	Student findStudentById(Integer id); 
	void insertStudent(Student student);
}
