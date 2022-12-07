package com.example.resttemplate.service.impl;

import com.example.resttemplate.domain.entity.*;
import com.example.resttemplate.respository.EmployeeRepository;
import com.example.resttemplate.service.EmployeeService;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private  final RestTemplate restTemplate;
    final String url  = "https://dummy.restapiexample.com/api/v1/employees";

    @Autowired
    EmployeeServiceImpl(RestTemplate restTemplate){this.restTemplate =restTemplate;}


    @Override
    public List<Data> findAll() {

        log.info("the firhd ");
        ResponseEntity<String> responseEntity =restTemplate.getForEntity(url, String.class);

        Page page = restTemplate.getForObject(url,Page.class);


        return page.getData();

    }
    public List<Data> findById(int age) {

        log.info("the firhd ");
        ResponseEntity<String> responseEntity =restTemplate.getForEntity(url, String.class);

        Page page = restTemplate.getForObject(url,Page.class);


        return page.getData().stream().filter(s->s.getEmployee_age()>age).collect(Collectors.toList());

    }



}
