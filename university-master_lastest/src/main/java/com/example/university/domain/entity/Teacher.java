package com.example.university.domain.entity;

import com.example.university.domain.reslationship.Relationship;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "tId", fetch = FetchType.LAZY , cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Relationship> relationships= new ArrayList<>();
}