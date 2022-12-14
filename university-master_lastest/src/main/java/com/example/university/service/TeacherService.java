package com.example.university.service;

import com.example.university.domain.CommonResponse;

import com.example.university.domain.entity.Student;
import com.example.university.domain.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {

    CommonResponse findById(String id);
    List<Teacher> findAll();
    CommonResponse insert(Teacher stu);

    CommonResponse delete(String id);

    CommonResponse update(String id);
    CommonResponse update(String id,String name);
    public List<Student> findStudents(String id);
}
