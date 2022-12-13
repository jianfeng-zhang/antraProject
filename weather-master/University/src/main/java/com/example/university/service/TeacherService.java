package com.example.university.service;

import com.example.university.domain.StudentDTO;
import com.example.university.domain.TeacherDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    List<TeacherDTO> findAll();
}
