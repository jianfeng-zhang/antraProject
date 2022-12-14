package com.example.university.domain.entity;


import com.example.university.domain.reslationship.Relationship;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @OneToMany(mappedBy = "stu", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<Relationship> relationships;


}


