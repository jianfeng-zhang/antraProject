package com.example.university.controller;


import com.example.university.domain.CommonResponse;

import com.example.university.domain.entity.Student;
import com.example.university.domain.entity.Teacher;
import com.example.university.exception.ResourceNotFoundException;

import com.example.university.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> findStuById(@PathVariable String id) {
        return new ResponseEntity<>(teacherService.findById(id), HttpStatus.OK);
    }

    @GetMapping()
    public List<Teacher> findAll() {
        return teacherService.findAll();
    }

    //path: /student, method: post ,  create student
    @PostMapping
    public ResponseEntity<CommonResponse> insert(@RequestBody Teacher teacher) {
        return new ResponseEntity<>(teacherService.insert(teacher), HttpStatus.CREATED);
    }

    //TODO: /{id} , method : put,  update student
    //update 先找id
    //PathVariable RequestBody requestPara
    @DeleteMapping(path = "{id}")
    public ResponseEntity<CommonResponse>  delete(@PathVariable String id) {
        return new ResponseEntity<>(teacherService.delete(id), HttpStatus.OK);
    }

    @PutMapping(path="/{id}/{name}")
    public ResponseEntity<CommonResponse>   update(
            @PathVariable String id,
            @PathVariable(required = false)  String name) {

        if(name ==null){
            return new ResponseEntity<>(teacherService.update(id), HttpStatus.OK);
        }else{ return new ResponseEntity<>(teacherService.update(id,name), HttpStatus.OK);}

    }
    @GetMapping("/{id}/students")
    public List<Student> findTeachers(@PathVariable String id) {

        return teacherService.findStudents(id);
    }

}
