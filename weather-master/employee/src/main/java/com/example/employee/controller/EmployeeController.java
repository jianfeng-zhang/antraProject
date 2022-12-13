package com.example.employee.controller;

import com.example.employee.domain.EmployeeDTO;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/employee")
    public List<EmployeeDTO> getAllEmp(){
       return  employeeService.findAll();
    }

    @GetMapping("/employees")
    public ResponseEntity<?> getAllEmp(@RequestParam int age) {
        return new ResponseEntity<>(employeeService.fetchEmpAgeLargerThan(age), HttpStatus.OK);
    }
}
