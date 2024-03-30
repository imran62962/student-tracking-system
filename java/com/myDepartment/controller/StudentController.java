package com.myDepartment.controller;

import com.myDepartment.entity.Student;
import com.myDepartment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getALLStudentsForAdmin")
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "entities/studentCRUD/studentListForAdmin"; // Assuming you have a view named "studentList"
    }
    @GetMapping("/getAllStudents")
    public String getAllStudent(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "entities/studentCRUD/studentList"; // Assuming you have a view named "studentList"
    }
    
  

    @GetMapping("/{id}")
    public String getStudentById(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "entities/studentCRUD/studentDetails"; // Assuming you have a view named "studentDetails"
    }

    @GetMapping("/newStudent")
    public String showFormForAdd(Model model) {
        model.addAttribute("student", new Student());
        return "entities/studentCRUD/addStudentForm"; // Assuming you have a view named "addStudentForm" for adding a new student
    }

//    @PostMapping("/saveStudent")
//    public String saveStudent(@ModelAttribute("student") Student student) {
//        studentService.saveStudent(student);
//        return "redirect:/getAllStudents";
//    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student, Model model) {
        // Save the student
        studentService.saveStudent(student);

        // Redirect to a page to display the details of the uploaded student
        return "redirect:/" + student.getId();
    }
    @GetMapping("/editStudent/{id}")
    public String showFormForUpdate(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "entities/studentCRUD/updateStudentForm"; // Assuming you have a view named "updateStudentForm" for updating a student
    }

    @PostMapping("/updateStudent/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student updatedStudent) {
        // Retrieve the existing student from the database
        Student existingStudent = studentService.getStudentById(id);

        if (existingStudent != null) {
            // Update the fields with values from the form
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setStudentId(updatedStudent.getStudentId());
            existingStudent.setBranch(updatedStudent.getBranch());
            existingStudent.setAdmissionType(updatedStudent.getAdmissionType());

            // Save the updated student
            studentService.saveStudent(existingStudent);

            return "temp";
        }

        // Handle the case where the student with the given ID is not found
        return "error"; // You can create an error view or redirect as needed
    }


    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/getALLStudentsForAdmin";
    }
}

