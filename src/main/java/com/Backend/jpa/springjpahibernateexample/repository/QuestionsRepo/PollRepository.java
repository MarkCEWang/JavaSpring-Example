package com.Backend.jpa.springjpahibernateexample.repository.QuestionsRepo;

import com.Backend.jpa.springjpahibernateexample.model.Questions.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll, Integer>{ }
