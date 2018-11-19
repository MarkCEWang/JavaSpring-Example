package com.Backend.jpa.springjpahibernateexample.controller.Questions;

import com.Backend.jpa.springjpahibernateexample.controller.SetController;
import com.Backend.jpa.springjpahibernateexample.model.Questions.Poll;
import com.Backend.jpa.springjpahibernateexample.repository.QuestionsRepo.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/poll")
public class PollController {

    @Autowired
    PollRepository pollRepository;

    @Autowired
    SetController setController;

    @GetMapping("/all")
    public List<Poll> getAll() { return pollRepository.findAll(); }

    @GetMapping("/{id}")
    public Poll getId(@PathVariable("id") final Integer id) { return pollRepository.findOne(id); }

    @PostMapping("/")
    public Poll create(@RequestBody Poll poll) {
        setController.incrementCount(poll.getSetId());
        pollRepository.save(poll);
        return poll;
    }

    @PutMapping("/{id}")
    public Poll update(@PathVariable("id") final Integer id, @RequestBody Poll newPoll) {
        Poll poll = getId(id);
        poll.setContent(newPoll.getContent());
        poll.setOption(newPoll.getOption());
        poll.setAnswerNum(newPoll.getAnswerNum());

        if (newPoll.getSetId() != null) {
            updateSet(id, newPoll.getSetId());
        }

        pollRepository.save(poll);
        return poll;
    }

    @PutMapping("/set/{id}/{setId}")
    public Integer updateSet(@PathVariable("id") final Integer id, @PathVariable("id") final Integer setId) {
        Poll poll = getId(id);
        boolean res = setController.decrementCount(poll.getSetId());
        if (res) {
            setController.incrementCount(setId);
            poll.setSetId(setId);
        }

        pollRepository.save(poll);
        return poll.getSetId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Integer id) {
        Poll poll = getId(id);
        pollRepository.delete(poll);
    }
}
