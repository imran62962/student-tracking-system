package com.myDepartment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myDepartment.entity.Faculty;

public interface FacultyRepository extends JpaRepository <Faculty,Long>{
	
    boolean existsByNameAndFacultyId(String name, String facultyId);
    @Query("SELECT f.facultyId FROM Faculty f WHERE f.name = :facultyName")
	String findFacultyIdByName(@Param("facultyName") String facultyName);

}
