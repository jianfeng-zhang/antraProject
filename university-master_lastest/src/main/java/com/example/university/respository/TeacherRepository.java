package com.example.university.respository;


import com.example.university.domain.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository  extends JpaRepository<Teacher, String>, TeacherCustomRepo{
}
