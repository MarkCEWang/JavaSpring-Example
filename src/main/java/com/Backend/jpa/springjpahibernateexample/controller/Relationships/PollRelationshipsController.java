package com.Backend.jpa.springjpahibernateexample.controller.Relationships;

import com.Backend.jpa.springjpahibernateexample.controller.Questions.PollController;
import com.Backend.jpa.springjpahibernateexample.model.Questions.Poll;
import com.Backend.jpa.springjpahibernateexample.model.Relationships.CheckboxRelationship;
import com.Backend.jpa.springjpahibernateexample.model.Relationships.PollRelationship;
import com.Backend.jpa.springjpahibernateexample.repository.RelationshipsRepo.PollRelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/poll_relationship")
public class PollRelationshipsController {
    @Autowired
    PollRelationshipRepository pollRelationshipRepository;

    @Autowired
    PollController pollController;

    @GetMapping("/all")
    public List<PollRelationship> getAll() { return pollRelationshipRepository.findAll(); }

    @GetMapping("/{id}")
    public PollRelationship getId(@PathVariable("id") final Integer id) { return pollRelationshipRepository.findOne(id); }

    @GetMapping("/question/{id}")
    public List<PollRelationship> getRelationshipsByQuestionId(@PathVariable("id") final Integer id) {
        return pollRelationshipRepository.findByQuestionId(id);
    }

    @GetMapping("/answer/{id}")
    public List<PollRelationship> getRelationshipsByAnswerId(@PathVariable("id") final Integer id) {
        return pollRelationshipRepository.findByAnswerId(id);
    }

    @PostMapping("/")
    public PollRelationship create(@RequestBody PollRelationship pollRelationship) {
        boolean option = pollController.getId(pollRelationship.getQuestionId()).getOption();
        Integer question_number = this.getRelationshipsByQuestionId(pollRelationship.getQuestionId()).size();
        if ((option && question_number < 4) || (!option && question_number < 2)) {
            pollRelationshipRepository.save(pollRelationship);
            return pollRelationship;
        }
        return null;
    }

    @PutMapping("/{id}")
    public PollRelationship update(@PathVariable("id") final Integer id, @RequestBody PollRelationship new_Relationship) {
        boolean option = pollController.getId(new_Relationship.getQuestionId()).getOption();
        Integer question_number = this.getRelationshipsByQuestionId(new_Relationship.getQuestionId()).size();

        PollRelationship pollRelationship = getId(id);
        //A poll questions should either have a max of 4 or 2 answers
        if ((option && question_number < 4) || (!option && question_number < 2)) {
            pollRelationship.setQuestionId(new_Relationship.getQuestionId());
            pollRelationship.setAnswerId(new_Relationship.getAnswerId());
            pollRelationshipRepository.save(pollRelationship);
            return pollRelationship;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Integer id) {
        PollRelationship pollRelationship = getId(id);
        pollRelationshipRepository.delete(pollRelationship);
    }
}
