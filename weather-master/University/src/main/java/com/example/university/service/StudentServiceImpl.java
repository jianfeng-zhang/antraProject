package com.example.university.service;

import com.example.university.domain.StudentDTO;
import com.example.university.domain.StudentResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;



@Service
@Slf4j
public class StudentServiceImpl implements StudentService{

    private final RestTemplate restTemplate;
    @Value("${student-endpoint}")
    private String url;
    @Autowired
    public StudentServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<StudentDTO> findAll() {
        log.info("find all students");
        return  restTemplate.getForObject(url,List.class);

    }
}
