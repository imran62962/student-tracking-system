package com.myDepartment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	
    @GetMapping("/")
    public String showHello() {
       
        return "main";
    }
	
    @GetMapping("/test")
    public String showAbout() {
       
        return "/temp2";
    }
    @GetMapping("/examinationCell")
    public String showExaminationCell() {
       
        return "/entities/examinationCell";
    }
    @GetMapping("/studentSection")
    public String showStudentInfo() {
       
        return "/entities/student/studentSection";
    }
    @GetMapping("/facultySection")
    public String showFacultyInfo() {
       
        return "/entities/faculty/facultySection";
    }
    @GetMapping("/events")
    public String showEvents() {
       
        return "/entities/events";
    }
    @GetMapping("/downloads")
    public String showDownloads() {
       
        return "/entities/downloads";
    }
    
}
