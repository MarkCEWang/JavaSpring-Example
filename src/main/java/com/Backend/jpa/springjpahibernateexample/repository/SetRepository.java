package com.Backend.jpa.springjpahibernateexample.repository;

import com.Backend.jpa.springjpahibernateexample.model.QuestionSet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SetRepository extends JpaRepository<QuestionSet, Integer > {
    List<QuestionSet> findByContent(String content);
}
