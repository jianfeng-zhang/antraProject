package com.example.search.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService{
    private final RestTemplate restTemplate;

    StudentServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Map[] fetchAllStudents() {
        log.info("find all students by search");
        return  restTemplate.getForObject("http://university-service/university/students", Map[].class);
    }

}
