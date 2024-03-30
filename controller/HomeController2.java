package com.myDepartment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import com.myDepartment.entity.Student;
import com.myDepartment.service.FacultyService;
import com.myDepartment.service.StudentService;

@Controller
public class HomeController2 {

    @Autowired
    private StudentService studentService;
    @Autowired
    private FacultyService facultyService;

    @GetMapping("/searchStudents")
    public String searchStudentsByFacultyName(@RequestParam("facultyName") String facultyName, Model model) {
        // Call your service method to fetch students by faculty name
        List<Student> students = studentService.getStudentsByFacultyName(facultyName);
        
        // Add the list of students to the model
        model.addAttribute("students", students);
        
        // Return the name of the Thymeleaf template file to render
        return "temp3"; // Assuming you have a template named searchResults.html
    }
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    @PostMapping("/login")
    public ModelAndView login(@RequestParam("facultyName") String facultyName, String facultyId) {
        // Custom validation
        
        // Fetch the list of students
        List<Student> students = studentService.getStudentsByFacultyName(facultyName);
        ModelAndView modelAndView = new ModelAndView("studentList");
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    

//    // Custom validation method
//    private boolean isValidFaculty(String facultyName, String facultyId) {
//        // Implement your custom validation logic here, e.g., check against database
//        return facultyService.validateFacultyCredentials(facultyName, facultyId);
//    }
}
