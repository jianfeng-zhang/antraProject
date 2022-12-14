package com.example.university;

import com.example.university.domain.CommonResponse;
import com.example.university.domain.entity.Student;
import com.example.university.domain.reslationship.Relationship;
import com.example.university.service.StudentService;
import com.example.university.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class UniversityApplicationTests {
    @Autowired
    StudentService studentService;
    @Test
    @Transactional(readOnly = true)
    void contextLoads() {

        Student student = studentService.findById("1");
        List<Relationship> relationships = student.getRelationships();


    }

}
