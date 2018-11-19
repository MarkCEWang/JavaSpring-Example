package com.Backend.jpa.springjpahibernateexample.repository.RelationshipsRepo;

import com.Backend.jpa.springjpahibernateexample.model.Relationships.CheckboxRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckboxRelationshipRepository extends JpaRepository<CheckboxRelationship, Integer> {
    List<CheckboxRelationship> findByQuestionId(Integer question);
    List<CheckboxRelationship> findByAnswerId(Integer answer);
}
