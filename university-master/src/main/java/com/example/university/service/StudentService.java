package com.example.university.service;

import com.example.university.domain.CommonResponse;
import com.example.university.domain.entity.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    CommonResponse findById(String id);
    CommonResponse findAll();
    CommonResponse insert(Student stu);

    CommonResponse delete(String id);

    CommonResponse update(String id);//只带id没输入name
    CommonResponse update(String id,String name);//都输入了

}
