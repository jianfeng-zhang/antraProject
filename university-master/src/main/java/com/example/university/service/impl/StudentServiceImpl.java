package com.example.university.service.impl;


import com.example.university.domain.CommonResponse;
import com.example.university.domain.entity.Student;
import com.example.university.exception.ResourceNotFoundException;
import com.example.university.respository.StudentRepository;
import com.example.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public CommonResponse findById(String id) {
        Optional<Student> stu =  studentRepository.findById(id);

        if(stu.isEmpty()) {
            //log
            throw new ResourceNotFoundException("...");
        }
        return new CommonResponse(0, new Date(), stu.get());
    }

    @Override
    public CommonResponse findAll() {
        List<Student> stuList =  studentRepository.findAll();

        return new CommonResponse(0, new Date(), stuList);
    }

    @Override
    @Transactional
    public CommonResponse insert(Student stu) {
        Student student = studentRepository.insert(stu);
        return new CommonResponse(0, new Date(), student.getId());
    }
    @Override
    @Transactional
    public CommonResponse delete(String id) {
        Student student = studentRepository.getReferenceById(id);
        if(student !=null) studentRepository.delete(student);
        return new CommonResponse(0, new Date(), student.getId());
    }

    @Override
    @Transactional
    public CommonResponse update(String id) {
        Student student = new Student();
        student.setId(id);
        studentRepository.update(student);

        return new CommonResponse(0, new Date(), student.getId());
    }
    @Override
    @Transactional
    public CommonResponse update(String id,String name) {
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        studentRepository.update(student);
        return new CommonResponse(0, new Date(), student.getId());
    }
}
