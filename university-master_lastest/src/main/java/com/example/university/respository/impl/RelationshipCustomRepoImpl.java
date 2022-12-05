package com.example.university.respository.impl;


import com.example.university.domain.reslationship.Relationship;
import com.example.university.respository.RelationshipCustomRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class RelationshipCustomRepoImpl implements RelationshipCustomRepo {
    private final EntityManager entityManager;

    @Autowired
    public RelationshipCustomRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Relationship insert(Relationship relationship) {
        entityManager.persist(relationship);
        return relationship;
    }
    @Override
    public Relationship update(Relationship relationship) {
        entityManager.merge(relationship);
        return relationship;
    }

}
