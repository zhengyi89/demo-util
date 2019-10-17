package com.demo.mapper;

import com.demo.model.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    Student findStudentById(Integer id);

    void insertStudent(Student student);
}
