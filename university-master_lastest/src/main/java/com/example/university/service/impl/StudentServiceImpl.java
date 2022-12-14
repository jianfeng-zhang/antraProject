package com.example.university.service.impl;


import com.example.university.domain.CommonResponse;
import com.example.university.domain.entity.Student;
import com.example.university.domain.entity.Teacher;
import com.example.university.domain.reslationship.Relationship;
import com.example.university.exception.ResourceNotFoundException;
import com.example.university.respository.StudentRepository;
import com.example.university.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findById(String id) {
        Optional<Student> stu =  studentRepository.findById(id);

        if(stu.isEmpty()) {
            //log
            throw new ResourceNotFoundException("...");
        }


        return stu.get();
    }

    @Override
    public List<Student> findAll() {
        List<Student> stuList =  studentRepository.findAll();

        return stuList;
    }

    @Override
    @Transactional
    public CommonResponse insert(Student stu) {
        Student student = studentRepository.insert(stu);
        return new CommonResponse(0, new Date(), student.getId());
    }
    @Override
    @Transactional
    public List<Teacher> findTeachers(String id) {
        Optional<Student> stu =  studentRepository.findById(id);
        if(stu.isEmpty()) {
            //log
            throw new ResourceNotFoundException("...");
        }
        Student student = stu.get();
        List<Relationship> relationships = student.getRelationships();
        List<Teacher> teachers = new ArrayList<>();
        for(Relationship relationship : relationships){
            log.info(relationship.getId());
            teachers.add(relationship.getTea());
        }

        return teachers;
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
