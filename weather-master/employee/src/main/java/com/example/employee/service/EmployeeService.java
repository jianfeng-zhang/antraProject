package com.example.employee.service;

import com.example.employee.domain.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<EmployeeDTO> fetchEmpAgeLargerThan(int age);
    List<EmployeeDTO> findAll();
}
