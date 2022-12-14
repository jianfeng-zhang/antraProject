package com.example.university.respository;

import com.example.university.domain.entity.Student;
import com.example.university.domain.reslationship.Relationship;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCustomRepo {
    Student insert(Student student);

    Student update(Student student);



}
