package com.Backend.jpa.springjpahibernateexample.controller.Questions;

import com.Backend.jpa.springjpahibernateexample.controller.SetController;
import com.Backend.jpa.springjpahibernateexample.model.Questions.Trivia;
import com.Backend.jpa.springjpahibernateexample.repository.QuestionsRepo.TriviaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/trivia")
public class TriviaController {

    @Autowired
    TriviaRepository triviaRepository;

    @GetMapping("/all")
    public List<Trivia> getAll(){ return triviaRepository.findAll(); }

    @GetMapping("/{id}")
    public Trivia getId(@PathVariable("id") final Integer id) { return triviaRepository.findOne(id); }

    @PostMapping("/")
    public Trivia createTrivia(@RequestBody Trivia trivia) {
        triviaRepository.save(trivia);
        return trivia;
    }

    @PutMapping("/{id}")
    public Trivia update(@PathVariable("id") final Integer id, @RequestBody Trivia updatedTrivia) {
        Trivia trivia = getId(id);

        trivia.setContent(updatedTrivia.getContent());
        trivia.setCorrectAnswer(updatedTrivia.getCorrectAnswer());
        trivia.setWrongAnswer(updatedTrivia.getWrongAnswer());

        triviaRepository.save(trivia);
        return trivia;
    }

    //update the set this question belongs to
    @PutMapping("/set/{id}/{setId}")
    public Integer updateSet(@PathVariable("id") final Integer id, @PathVariable("setId") final Integer setId) {
        Trivia trivia = getId(id);

        SetController sc = new SetController();
        boolean res = sc.decrementCount(trivia.getSetId());
        if (res) {
            sc.incrementCount(setId);
            trivia.setSetId(setId);
        }

        triviaRepository.save(trivia);
        return trivia.getSetId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Integer id) {
        Trivia trivia = getId(id);

        triviaRepository.delete(trivia);
    }
}
