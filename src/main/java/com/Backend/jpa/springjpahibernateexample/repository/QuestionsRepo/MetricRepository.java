package com.Backend.jpa.springjpahibernateexample.repository.QuestionsRepo;

import com.Backend.jpa.springjpahibernateexample.model.Questions.Metric;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetricRepository extends JpaRepository<Metric, Integer> { }
