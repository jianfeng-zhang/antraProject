package com.example.university.respository.impl;


import com.example.university.domain.entity.Teacher;

import com.example.university.respository.TeacherCustomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class TeacherCustomRepoImpl  implements TeacherCustomRepo {

    private final EntityManager entityManager;

    @Autowired
    public TeacherCustomRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Teacher insert(Teacher teacher) {
        entityManager.persist(teacher);
        return teacher;
    }
    @Override
    public Teacher update(Teacher teacher) {
        entityManager.merge(teacher);
        return teacher;
    }


//DELETE FROM Sites WHERE XXX;


}
