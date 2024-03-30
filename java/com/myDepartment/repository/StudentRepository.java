package com.myDepartment.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myDepartment.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // You can add custom query methods here if needed
	@Query("SELECT s FROM Student s WHERE s.mentor = :facultyName")
	    List<Student> findByMentor(@Param("facultyName") String facultyName);
}
