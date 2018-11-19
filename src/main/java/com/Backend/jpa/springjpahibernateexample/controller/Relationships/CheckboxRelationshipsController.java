package com.Backend.jpa.springjpahibernateexample.controller.Relationships;

import com.Backend.jpa.springjpahibernateexample.model.Relationships.CheckboxRelationship;
import com.Backend.jpa.springjpahibernateexample.repository.RelationshipsRepo.CheckboxRelationshipRepository;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/checkbox_relationship")
public class CheckboxRelationshipsController {

    final Integer max_ans = 10;
    @Autowired
    CheckboxRelationshipRepository checkboxRelationshipRepository;

    @GetMapping("/all")
    public List<CheckboxRelationship> getAll() { return checkboxRelationshipRepository.findAll(); }

    @GetMapping("/{id}")
    public CheckboxRelationship getId(@PathVariable("id") final Integer id) { return checkboxRelationshipRepository.findOne(id); }

    //get all answers that is mapped to this question
    @GetMapping("/question/{id}")
    public List<CheckboxRelationship> getRelationshipsByQuestionId(@PathVariable("id") final Integer id) {
        return checkboxRelationshipRepository.findByQuestionId(id);
    }

    //get all the questions that uses this answer
    @GetMapping("/answer/{id}")
    public List<CheckboxRelationship> getRelationshipsByAnswerId(@PathVariable("id") final Integer id) {
        return checkboxRelationshipRepository.findByAnswerId(id);
    }

    @PostMapping("/")
    public CheckboxRelationship create(@RequestBody CheckboxRelationship checkboxRelationship) {
        Integer question_number = this.getRelationshipsByQuestionId(checkboxRelationship.getQuestionId()).size();
        if (question_number < max_ans) {
            checkboxRelationshipRepository.save(checkboxRelationship);
            return checkboxRelationship;
        }
        return null;
    }

    @PutMapping("/{id}")
    public CheckboxRelationship update(@PathVariable("id") final Integer id, @RequestBody CheckboxRelationship newRelationship) {
        CheckboxRelationship checkboxRelationship = getId(id);

        checkboxRelationship.setQuestionId(newRelationship.getQuestionId());
        checkboxRelationship.setAnswerId(newRelationship.getAnswerId());

        checkboxRelationshipRepository.save(checkboxRelationship);
        return checkboxRelationship;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Integer id) {
        CheckboxRelationship checkboxRelationship = getId(id);
        checkboxRelationshipRepository.delete(checkboxRelationship);
    }
}
