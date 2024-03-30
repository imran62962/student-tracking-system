package com.myDepartment.service;

import java.util.List;

import com.myDepartment.entity.Student;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    void saveStudent(Student student);

    void updateStudent(Long id, Student student);

    void deleteStudent(Long id);
    List<Student> getStudentsByFacultyName(String facultyName);
}