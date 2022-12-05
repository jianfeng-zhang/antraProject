package com.example.university.domain.entity;


import com.example.university.domain.reslationship.Relationship;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
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

    @OneToMany(mappedBy = "sId", fetch = FetchType.LAZY , cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Relationship> relationships= new ArrayList<>();
}


