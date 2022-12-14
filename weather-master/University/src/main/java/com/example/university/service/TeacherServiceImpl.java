package com.example.university.service;

import com.example.university.domain.StudentDTO;
import com.example.university.domain.TeacherDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService{

    private final RestTemplate restTemplate;
    @Value("${teacher-endpoint}")
    private String url;
    @Autowired
    public TeacherServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<TeacherDTO> findAll() {
        log.info("find all teachers");
        return  restTemplate.getForObject(url,List.class);

    }
}
