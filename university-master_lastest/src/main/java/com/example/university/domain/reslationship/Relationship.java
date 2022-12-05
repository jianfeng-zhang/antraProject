package com.example.university.domain.reslationship;


import com.example.university.domain.entity.Student;
import com.example.university.domain.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "teacher_student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Relationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "t_id")
    private Teacher tId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "s_id")
    private Student sId;




}
