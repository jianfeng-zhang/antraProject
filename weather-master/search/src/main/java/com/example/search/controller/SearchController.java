package com.example.search.controller;


import com.example.search.service.EmployeeService;
import com.example.search.service.StudentService;
import com.example.search.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SearchController {
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final EmployeeService employeeService;
    @Autowired
    public SearchController(EmployeeService employeeService, StudentService studentService, TeacherService teacherService) {
        this.employeeService = employeeService;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }



    @GetMapping("/search/employees")
    public Map<Integer, Map[]> getDetails(@RequestParam List<Integer> ages) {
        //TODO
        return employeeService.fetchAllEmployeesByAges(ages);
    }


    @GetMapping("/search/students")
    public Map[]  fetchAllStudents() {
        //TODO
        return studentService.fetchAllStudents();
    }
    @GetMapping("/search/teachers")
    public Map<String ,Map[]>  fetchAllTeachers() {
        //TODO
        return teacherService.fetchAllTeacher();
    }
}
