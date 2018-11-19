package com.Backend.jpa.springjpahibernateexample.repository.AnswersRepo;

import com.Backend.jpa.springjpahibernateexample.model.Answers.ObjectiveAnswers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjectiveAnswersRepository extends JpaRepository<ObjectiveAnswers, Integer> {
}
