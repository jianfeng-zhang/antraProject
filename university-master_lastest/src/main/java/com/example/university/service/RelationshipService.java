package com.example.university.service;

import com.example.university.domain.CommonResponse;

import com.example.university.domain.reslationship.Relationship;
import org.springframework.stereotype.Service;



@Service
public interface RelationshipService {
    CommonResponse findById(String id);
    CommonResponse findAll();
    CommonResponse insert(Relationship relationship);



}