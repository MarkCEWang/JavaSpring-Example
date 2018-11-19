package com.Backend.jpa.springjpahibernateexample.repository.RelationshipsRepo;

import com.Backend.jpa.springjpahibernateexample.model.Relationships.PollRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PollRelationshipRepository extends JpaRepository<PollRelationship, Integer> {
    List<PollRelationship> findByQuestionId(Integer question);
    List<PollRelationship> findByAnswerId(Integer answer);
}
