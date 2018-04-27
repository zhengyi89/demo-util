package com.test.mybatis.dao;

import com.test.mybatis.model.Student;

public interface StudentMapper {
	Student findStudentById(Integer id); 
	void insertStudent(Student student);
}
