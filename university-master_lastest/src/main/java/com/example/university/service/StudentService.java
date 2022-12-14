package com.example.university.service;

import com.example.university.domain.CommonResponse;
import com.example.university.domain.entity.Student;
import com.example.university.domain.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student findById(String id);
    List<Student> findAll();
    CommonResponse insert(Student stu);

    CommonResponse delete(String id);

    CommonResponse update(String id);
    CommonResponse update(String id,String name);
     List<Teacher> findTeachers(String id);
}
