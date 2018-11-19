package com.Backend.jpa.springjpahibernateexample.repository.QuestionsRepo;

import com.Backend.jpa.springjpahibernateexample.model.Questions.Trivia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TriviaRepository extends JpaRepository<Trivia, Integer>{
}
