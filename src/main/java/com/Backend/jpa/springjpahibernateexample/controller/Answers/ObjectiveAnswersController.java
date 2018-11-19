package com.Backend.jpa.springjpahibernateexample.controller.Answers;

import com.Backend.jpa.springjpahibernateexample.model.Answers.ObjectiveAnswers;
import com.Backend.jpa.springjpahibernateexample.repository.AnswersRepo.ObjectiveAnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/obj_ans")
public class ObjectiveAnswersController {

    @Autowired
    ObjectiveAnswersRepository objectiveAnswersRepository;

    @GetMapping("/all")
    public List<ObjectiveAnswers> getAll() { return objectiveAnswersRepository.findAll(); }

    @GetMapping("/{id}")
    public ObjectiveAnswers getId(@PathVariable("id") final Integer id) { return objectiveAnswersRepository.findOne(id); }

    @GetMapping("/category/{category}")
    public List<ObjectiveAnswers> getByCategory(@PathVariable("category") final String category) {
        return objectiveAnswersRepository.findByCategory(category);
    }

    @PostMapping("/")
    public ObjectiveAnswers create(@RequestBody ObjectiveAnswers obj_ans) {
        objectiveAnswersRepository.save(obj_ans);
        return obj_ans;
    }

    @PutMapping("/{id}")
    public ObjectiveAnswers update(@PathVariable("id") final Integer id, @RequestBody ObjectiveAnswers new_ans) {
        ObjectiveAnswers obj_ans = getId(id);
        obj_ans.setContent(new_ans.getContent());
        obj_ans.setCategory(new_ans.getCategory());
        objectiveAnswersRepository.save(obj_ans);
        return obj_ans;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Integer id) {
        ObjectiveAnswers obj_ans = getId(id);
        objectiveAnswersRepository.delete(obj_ans);
    }

}

