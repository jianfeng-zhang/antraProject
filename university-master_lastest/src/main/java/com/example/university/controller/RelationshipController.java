package com.example.university.controller;

import com.example.university.domain.CommonResponse;

import com.example.university.domain.reslationship.Relationship;

import com.example.university.service.RelationshipService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/relationship")
public class RelationshipController {

    private final RelationshipService relationshipService;

    @Autowired
    public RelationshipController(RelationshipService relationshipService) {
        this.relationshipService = relationshipService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> findStuById(@PathVariable String id) {
        return new ResponseEntity<>(relationshipService.findById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<CommonResponse> findAll() {
        return new ResponseEntity<>(relationshipService.findAll(), HttpStatus.OK);
    }

    //path: /student, method: post ,  create student
    @PostMapping
    public ResponseEntity<CommonResponse> insert(@RequestBody Relationship relationship) {
        return new ResponseEntity<>(relationshipService.insert(relationship), HttpStatus.CREATED);
    }

    //TODO: /{id} , method : put,  update student
    //update 先找id
    //PathVariable RequestBody requestPara


}