package com.example.university.respository;

import com.example.university.domain.entity.Student;
import com.example.university.domain.entity.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherCustomRepo {
    Teacher insert(Teacher teacher);

    Teacher update(Teacher teacher);

}