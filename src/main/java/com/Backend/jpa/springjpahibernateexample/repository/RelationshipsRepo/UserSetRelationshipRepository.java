package com.Backend.jpa.springjpahibernateexample.repository.RelationshipsRepo;

import com.Backend.jpa.springjpahibernateexample.model.Relationships.UserSetRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserSetRelationshipRepository extends JpaRepository<UserSetRelationship, Integer> {
    List<UserSetRelationship> findBySetId(Integer id);
    List<UserSetRelationship> findByUuid(String uuid);
}
