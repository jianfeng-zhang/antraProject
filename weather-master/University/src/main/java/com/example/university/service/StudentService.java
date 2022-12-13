package com.example.university.service;

import com.example.university.domain.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<StudentDTO> findAll();
}
