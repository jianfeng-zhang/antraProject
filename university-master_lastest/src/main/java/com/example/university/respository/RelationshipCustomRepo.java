package com.example.university.respository;

import com.example.university.domain.entity.Student;
import com.example.university.domain.reslationship.Relationship;

public interface RelationshipCustomRepo {
    Relationship insert(Relationship relationship);

    Relationship update(Relationship relationship);
}
