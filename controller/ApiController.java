//package com.myDepartment.controller;
//
//import java.util.List;
//import com.myDepartment.service.FacultyService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.myDepartment.entity.Faculty;
//import com.myDepartment.entity.Student;
//import com.myDepartment.service.StudentService;
//
////@RestController
////@RequestMapping("/api")
////@CrossOrigin(origins = "http://localhost:3000") // Replace with your React app's URL
////
////public class ApiController {
////
////    @GetMapping("/example")
////    public ResponseEntity<String> getExample() {
////        return ResponseEntity.ok("Hello from Spring Boot!");
////    }
////
////    // Add other methods for handling different requests
////}
//
//@RestController
//@RequestMapping("/api/students")
//@CrossOrigin(origins = "http://localhost:3000") // Replace with your React app's URL
//
//public class ApiController {
//	private final FacultyService facultyService;
//
//
//    private final StudentService studentService;
//
//    @Autowired
//    public ApiController(StudentService studentService, FacultyService facultyService) {
//        this.studentService = studentService;
//        this.facultyService=facultyService;
//    }
//
//    @GetMapping("/getAllStudentsForAdmin")
//    public List<Student> getAllStudentsForAdmin() {
//        return studentService.getAllStudents();
//    }
//
//    @GetMapping("/getAllStudents")
//    public List<Student> getAllStudents() {
//        return studentService.getAllStudents();
//    }
//    @GetMapping("/getAllFaculty")
//	 public List<Faculty> getacultyList() {
//     
//      
//      return facultyService.getAllFaculty(); // Assuming your template file is named "studentList.html"
//  }
//
//    @GetMapping("/{id}")
//    public Student getStudentById(@PathVariable Long id) {
//        return studentService.getStudentById(id);
//    }
//
//    @PostMapping("/saveStudent")
//    public void saveStudent(@RequestBody Student student) {
//        studentService.saveStudent(student);
//    }
//
//    @PutMapping("/updateStudent/{id}")
//    public void updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
//        // Retrieve the existing student from the database
//        Student existingStudent = studentService.getStudentById(id);
//
//        if (existingStudent != null) {
//            // Update the fields with values from the request body
//            existingStudent.setName(updatedStudent.getName());
//            existingStudent.setStudentId(updatedStudent.getStudentId());
//            existingStudent.setBranch(updatedStudent.getBranch());
//            existingStudent.setAdmissionType(updatedStudent.getAdmissionType());
//
//            // Save the updated student
//            studentService.saveStudent(existingStudent);
//        }
//        // You might want to handle the case where the student with the given ID is not found
//    }
//
//    @DeleteMapping("/deleteStudent/{id}")
//    public void deleteStudent(@PathVariable Long id) {
//        studentService.deleteStudent(id);
//    }
//    
//    
//}