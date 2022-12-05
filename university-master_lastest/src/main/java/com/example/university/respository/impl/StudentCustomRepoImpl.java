package com.example.university.respository.impl;

import com.example.university.domain.entity.Student;
import com.example.university.respository.StudentCustomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;



@Repository
public class StudentCustomRepoImpl  implements StudentCustomRepo {

    private final EntityManager entityManager;

    @Autowired
    public StudentCustomRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Student insert(Student student) {
        entityManager.persist(student);
        return student;
    }
    @Override
    public Student update(Student student) {
        entityManager.merge(student);
        return student;
    }


//DELETE FROM Sites WHERE XXX;


}
