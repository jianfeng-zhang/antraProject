package com.example.employee.service;

import com.example.employee.domain.EmployeeDTO;
import com.example.employee.domain.EmployeeResponseDTO;
import com.example.employee.domain.PageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{



    @Value("${employee-endpoint}")
    private String url;
    private final RestTemplate restTemplate;
    @Autowired
    public EmployeeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<EmployeeDTO> fetchEmpAgeLargerThan(int age) {
        PageDTO pageDTO = restTemplate.getForObject(url, PageDTO.class);
        return null;
    }
    @Override
    public List<EmployeeDTO> findAll() {
        PageDTO pageDTO = restTemplate.getForObject(url, PageDTO.class);
        return pageDTO.getData();
    }
}
