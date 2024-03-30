package com.myDepartment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myDepartment.entity.Marks;

public interface MarksRepository extends JpaRepository<Marks, Long> {
    // Add custom query methods if needed
}
