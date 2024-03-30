package com.myDepartment.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.myDepartment.entity.Marks;
import com.myDepartment.repository.MarksRepository;
import com.myDepartment.service.MarksService;

@Service
public class MarksServiceImpl implements MarksService {

    private final MarksRepository marksRepository;

    public MarksServiceImpl(MarksRepository marksRepository) {
        this.marksRepository = marksRepository;
    }

    @Override
    public List<Marks> getAllMarks() {
        return marksRepository.findAll();
    }

    @Override
    public Marks getMarksById(Long id) {
        return marksRepository.findById(id).orElse(null);
    }

    @Override
    public void saveMarks(Marks marks) {
        marksRepository.save(marks);
    }

    @Override
    public void updateMarks(Long id, Marks marks) {
        // Implement update logic if needed
    }

    @Override
    public void deleteMarks(Long id) {
        marksRepository.deleteById(id);
    }
}
