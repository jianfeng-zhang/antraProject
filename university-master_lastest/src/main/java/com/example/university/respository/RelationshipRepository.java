package com.example.university.respository;


import com.example.university.domain.reslationship.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationshipRepository extends JpaRepository<Relationship, String>, RelationshipCustomRepo{
}
