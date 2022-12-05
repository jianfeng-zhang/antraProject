package com.example.university.service.impl;

import com.example.university.domain.CommonResponse;
import com.example.university.domain.entity.Student;
import com.example.university.domain.reslationship.Relationship;
import com.example.university.exception.ResourceNotFoundException;


import com.example.university.respository.RelationshipRepository;
import com.example.university.service.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class RelationshipServiceImpl implements RelationshipService {

    private final RelationshipRepository relationshipRepository;

    @Autowired
    public RelationshipServiceImpl(RelationshipRepository relationshipRepository) {
        this.relationshipRepository = relationshipRepository;
    }


    @Override
    public CommonResponse findById(String id) {
        Optional<Relationship> rel = relationshipRepository.findById(id);

        if(rel.isEmpty()) {
            //log
            throw new ResourceNotFoundException("...");
        }
        return new CommonResponse(0, new Date(), rel.get());
    }

    @Override
    public CommonResponse findAll() {
        List<Relationship> stuList =  relationshipRepository.findAll();

        return new CommonResponse(0, new Date(), stuList);
    }

    @Override
    @Transactional
    public CommonResponse insert(Relationship rel) {
        Relationship relationship = relationshipRepository.insert(rel);
        return new CommonResponse(0, new Date(), relationship.getId());
    }
}
