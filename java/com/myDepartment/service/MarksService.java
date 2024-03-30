package com.myDepartment.service;

import java.util.List;
import com.myDepartment.entity.Marks;

public interface MarksService {
    List<Marks> getAllMarks();
    Marks getMarksById(Long id);
    void saveMarks(Marks marks);
    void updateMarks(Long id, Marks marks);
    void deleteMarks(Long id);
}
