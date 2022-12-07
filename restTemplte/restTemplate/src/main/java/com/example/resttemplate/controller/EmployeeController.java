package com.example.resttemplate.controller;

import com.example.resttemplate.domain.entity.*;
import com.example.resttemplate.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {
    private  final  EmployeeService employeeService;
    @Autowired
    EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;

    }

    @GetMapping
    public List<Data> findAll(){
        log.info("试试");
        return employeeService.findAll();
    }
    @GetMapping(params = "age")
    public List<Data> findById(@RequestParam int age) {
        return employeeService.findById( age);
    }

}
