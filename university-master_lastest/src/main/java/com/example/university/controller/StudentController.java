package com.example.university.controller;

import com.example.university.domain.CommonResponse;
import com.example.university.domain.entity.Student;
import com.example.university.domain.entity.Teacher;
import com.example.university.exception.ResourceNotFoundException;
import com.example.university.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public Student findStuById(@PathVariable String id) {
        return studentService.findById(id);
    }
    @GetMapping("/{id}/teachers")
    public List<Teacher> findTeachers(@PathVariable String id) {

        return studentService.findTeachers(id);
    }

    @GetMapping()
    public List<Student> findAll() {
        return studentService.findAll();
    }

    //path: /student, method: post ,  create student
    @PostMapping
    public ResponseEntity<CommonResponse> insert(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.insert(student), HttpStatus.CREATED);
    }

    //TODO: /{id} , method : put,  update student
    //update 先找id
    //PathVariable RequestBody requestPara
    @DeleteMapping(path = "{id}")
    public ResponseEntity<CommonResponse>  delete(@PathVariable String id) {
        return new ResponseEntity<>(studentService.delete(id), HttpStatus.OK);
    }

    @PutMapping(path="/{id}/{name}")
    public ResponseEntity<CommonResponse>   update(
            @PathVariable String id,
            @PathVariable(required = false)  String name) {

        if(name ==null){
            return new ResponseEntity<>(studentService.update(id), HttpStatus.OK);
        }else{ return new ResponseEntity<>(studentService.update(id,name), HttpStatus.OK);}

    }


}
