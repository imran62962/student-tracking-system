package com.myDepartment.service;
import java.util.List;
import com.myDepartment.entity.Faculty;
public interface FacultyService {
	List<Faculty> getAllFaculty();
	Faculty getFacultyById(Long id);
	void saveFaculty(Faculty faculty);
	void updateFaculty(Long id,Faculty faculty);
	void deleteFaculty(Long id);
    boolean validateFacultyCredentials(String facultyName, String facultyId);
    String getFacultyIdByName(String facultyName);
   


}
