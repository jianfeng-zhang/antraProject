package com.example.university.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "teacher_student",
            joinColumns = {
                    @JoinColumn(name = "s_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "t_id", referencedColumnName = "id")
            }
    )
    private List<Teacher> teachers;
}


