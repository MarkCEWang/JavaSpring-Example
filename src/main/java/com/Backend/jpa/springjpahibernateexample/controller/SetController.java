package com.Backend.jpa.springjpahibernateexample.controller;

import com.Backend.jpa.springjpahibernateexample.model.QuestionSet;
import com.Backend.jpa.springjpahibernateexample.repository.SetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/sets")
public class SetController {
    @Autowired
    SetRepository setRepository;

    @GetMapping("/all")
    public List<QuestionSet> getAll(){ return setRepository.findAll(); }

    @GetMapping("/{id}")
    public QuestionSet getId(@PathVariable("id") final Integer id) { return setRepository.findOne(id); }

    @PostMapping("/")
    public QuestionSet createSet(@RequestBody QuestionSet set) {
        setRepository.save(set);
        return set;
    }

    @PutMapping("/content/{id}/{content}")
    public QuestionSet updateContent(@PathVariable("id") final Integer id, @PathVariable("content") final String content) {
        QuestionSet set = getId(id);
        set.setContent(content);
        setRepository.save(set);
        return set;
    }

    //increase the number of questions this question set has by 1
    @PutMapping("/increment/{id}")
    public void incrementCount(@PathVariable("id") final Integer id) {
        QuestionSet set = getId(id);
        set.setCount(set.getCount() + 1);
        setRepository.save(set);
    }

    //decrease the number of questions this question set has by 1
    @PutMapping("/decrement/{id}")
    public boolean decrementCount(@PathVariable("id") final Integer id) {
        QuestionSet set = getId(id);
        if (set.getCount() > 0) {
            set.setCount(set.getCount() - 1);
            System.out.println(set.getCount());
            setRepository.save(set);
            return true;
        }
        return false;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Integer id) {
        QuestionSet set = getId(id);
        setRepository.delete(set);
    }
}
