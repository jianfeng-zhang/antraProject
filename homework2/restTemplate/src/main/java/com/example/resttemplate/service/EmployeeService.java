package com.example.resttemplate.service;

import com.example.resttemplate.domain.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    List<Data> findAll();
    List<Data> findById(int age);
}
