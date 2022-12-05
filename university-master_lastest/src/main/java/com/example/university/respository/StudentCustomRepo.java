package com.example.university.respository;

import com.example.university.domain.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCustomRepo {
    Student insert(Student student);

    Student update(Student student);

}
