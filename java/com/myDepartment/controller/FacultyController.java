package com.myDepartment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.myDepartment.entity.Faculty;
import com.myDepartment.service.FacultyService;

@Controller
public class FacultyController {

    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/getAllFacultyForAdmin")
    public String getAllFacultyForAdmin(Model model) {
        List<Faculty> faculties = facultyService.getAllFaculty();
        model.addAttribute("faculties", faculties);
        return "entities/facultyCRUD/facultyListForAdmin";
    }

    @GetMapping("/getAllFaculty")
    public String getAllFaculty(Model model) {
        List<Faculty> faculties = facultyService.getAllFaculty();
        model.addAttribute("faculties", faculties);
        return "entities/facultyCRUD/facultyList";
    }

    @GetMapping("/viewFaculty/{id}")
    public String getFacultyById(@PathVariable Long id, Model model) {
        Faculty faculty = facultyService.getFacultyById(id);
        model.addAttribute("faculty", faculty);
        return "entities/facultyCRUD/facultyDetails";
    }

    @GetMapping("/newFaculty")
    public String showFormForAdd(Model model) {
        model.addAttribute("faculty", new Faculty());
        return "entities/facultyCRUD/addFacultyForm";
    }

    @PostMapping("/saveFaculty")
    public String saveFaculty(@ModelAttribute("faculty") Faculty faculty, Model model) {
        facultyService.saveFaculty(faculty);
        return "redirect:/viewFaculty/" + faculty.getId();
    }

    @GetMapping("/editFaculty/{id}")
    public String showFormForUpdate(@PathVariable Long id, Model model) {
        Faculty faculty = facultyService.getFacultyById(id);
        model.addAttribute("faculty", faculty);
        return "entities/facultyCRUD/updateFacultyForm";
    }

    @PostMapping("/updateFaculty/{id}")
    public String updateFaculty(@PathVariable Long id, @ModelAttribute("faculty") Faculty updatedFaculty) {
        Faculty existingFaculty = facultyService.getFacultyById(id);

        if (existingFaculty != null) {
            existingFaculty.setName(updatedFaculty.getName());
            existingFaculty.setFacultyId(updatedFaculty.getFacultyId());
            existingFaculty.setBranch(updatedFaculty.getBranch());
            existingFaculty.setDesignation(updatedFaculty.getDesignation());
            facultyService.saveFaculty(existingFaculty);
            return "redirect:/getAllFacultyForAdmin"; // Redirect or return appropriate view
        }

        return "redirect:/getAllFacultyForAdmin"; // Handle the case where faculty with the given ID is not found
    }

    @GetMapping("/deleteFaculty/{id}")
    public String deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return "redirect:/getAllFacultyForAdmin";
    }
}