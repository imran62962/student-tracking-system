package com.myDepartment.controller;

import com.myDepartment.entity.Marks;
import com.myDepartment.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MarksController {

    private final MarksService marksService;

    @Autowired
    public MarksController(MarksService marksService) {
        this.marksService = marksService;
    }
    
    @GetMapping("/getMarksForAdmin")
    public String getAllMarksForAdmin(Model model) {
        List<Marks> marks = marksService.getAllMarks();
        model.addAttribute("marks", marks);
        return "entities/marksCRUD/marksListForAdmin"; // Assuming you have a view named "marksList" to display all marks
    }
    @GetMapping("/getMarks")
    public String getAllMarks(Model model) {
        List<Marks> marks = marksService.getAllMarks();
        model.addAttribute("marks", marks);
        return "entities/marksCRUD/marksList"; // Assuming you have a view named "marksList" to display all marks
    }

    @GetMapping("/addMarks")
    public String showAddForm(Model model) {
        model.addAttribute("marks", new Marks());
        return "entities/marksCRUD/addMarksForm"; // Assuming you have a view named "add-mark-form" for adding marks
    }

    @PostMapping("/saveMarks")
    public String saveMark(@ModelAttribute("marks") Marks marks) {
        marksService.saveMarks(marks);
        return "redirect:/getMarksForAdmin"; // Redirect to the marks list page after saving
    }
    @GetMapping("/editMarks/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Marks marks = marksService.getMarksById(id);
        model.addAttribute("marks", marks);
        return "entities/marksCRUD/updateMarksForm"; // Assuming you have a view named "editMarks.html"
    }

    @PostMapping("/updateMarks/{id}")
    public String updateMarks(@PathVariable Long id, @ModelAttribute("marks") Marks updatedMarks) {
        // Retrieve the existing marks from the database
        Marks existingMarks = marksService.getMarksById(id);

        if (existingMarks != null) {
            // Update the fields with values from the form
        	
            existingMarks.setY20it101(updatedMarks.getY20it101());
            existingMarks.setY20it102(updatedMarks.getY20it102());
            existingMarks.setY20it103(updatedMarks.getY20it103());
            existingMarks.setY20itl101(updatedMarks.getY20itl101());
            existingMarks.setY20itl102(updatedMarks.getY20itl102());
            existingMarks.setY20itl103(updatedMarks.getY20itl103());
            existingMarks.setY20itl104(updatedMarks.getY20itl104());

            // Save the updated marks
            marksService.saveMarks(existingMarks);

            return "redirect:/getMarksForAdmin"; // Redirect to the appropriate page after updating marks
        }

        // Handle the case where the marks with the given ID is not found
        return "error"; // You can create an error view or redirect as needed
    }

    @GetMapping("/deleteMarks/{id}")
    public String deleteMarks(@PathVariable Long id) {
        marksService.deleteMarks(id);
        return "redirect:/getMarks";
    }

    // Add methods for editing, deleting marks if needed

}
