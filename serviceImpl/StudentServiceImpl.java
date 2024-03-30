package com.myDepartment.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myDepartment.entity.Student;
import com.myDepartment.repository.StudentRepository;
import com.myDepartment.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Long id, Student student) {
//        Student existingStudent = studentRepository.findById(id).orElse(null);
//        if (existingStudent != null) {
//            // Update the fields as needed
//            existingStudent.setName(student.getName());
//            existingStudent.setRegid(student.getRegid());
//            existingStudent.setYear(student.getYear());
//            existingStudent.setBranch(student.getBranch());
//            existingStudent.setAdmissionType(student.getAdmissionType());
//
//            studentRepository.save(existingStudent);
//        }
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
    @Override
    public List<Student> getStudentsByFacultyName(String facultyName) {
        List<Student> students = studentRepository.findByMentor(facultyName);
        
//        if (students.isEmpty()) {
//            System.out.println("No students found for faculty: " + facultyName);
//        } else {
//            System.out.println("Students found for faculty " + facultyName + ":");
//            for (Student student : students) {
//                System.out.println(student.getName());
//            }
//        }
        
        return students;
    }


	
}
