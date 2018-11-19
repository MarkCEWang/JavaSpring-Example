package com.Backend.jpa.springjpahibernateexample.repository.QuestionsRepo;

import com.Backend.jpa.springjpahibernateexample.model.Questions.Checkbox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckboxRepository extends JpaRepository<Checkbox, Integer> {
}
