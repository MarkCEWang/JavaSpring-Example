package com.Backend.jpa.springjpahibernateexample.repository.AnswersRepo;

import com.Backend.jpa.springjpahibernateexample.model.Answers.ObjectiveAnswers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObjectiveAnswersRepository extends JpaRepository<ObjectiveAnswers, Integer> {
    List<ObjectiveAnswers> findByCategory(String category);
}
