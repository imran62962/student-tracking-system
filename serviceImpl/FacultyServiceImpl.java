package com.myDepartment.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myDepartment.entity.Faculty;
import com.myDepartment.repository.FacultyRepository;
import com.myDepartment.service.FacultyService;
@Service
public class FacultyServiceImpl implements FacultyService {
	
	private final FacultyRepository facultyRepository;
	public FacultyServiceImpl(FacultyRepository facultyRepository) {
		this.facultyRepository=facultyRepository;
	}
	@Override
	public List<Faculty> getAllFaculty() {
		
		return facultyRepository.findAll();
	}

	@Override
	public Faculty getFacultyById(Long id) {
		// TODO Auto-generated method stub
		return facultyRepository.findById(id).orElse(null);
	}

	@Override
	public void saveFaculty(Faculty faculty) {
		facultyRepository.save(faculty);
		
	}

	@Override
	public void updateFaculty(Long id, Faculty faculty) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFaculty(Long id) {
		facultyRepository.deleteById(id);
		
	}
	 @Override
	    public boolean validateFacultyCredentials(String facultyName, String facultyId) {
	        // Implement your logic to validate faculty credentials
	        // For example, you can check if the faculty exists with the provided name and ID
	        // and return true if valid, otherwise false
	        return facultyRepository.existsByNameAndFacultyId(facultyName, facultyId);
	    }
	 @Override
	    public String getFacultyIdByName(String facultyName) {
	        return facultyRepository.findFacultyIdByName(facultyName);
	    }
	
	 

}
