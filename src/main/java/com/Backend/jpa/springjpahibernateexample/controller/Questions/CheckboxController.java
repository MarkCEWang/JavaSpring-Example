package com.Backend.jpa.springjpahibernateexample.controller.Questions;

import com.Backend.jpa.springjpahibernateexample.controller.SetController;
import com.Backend.jpa.springjpahibernateexample.model.Questions.Checkbox;
import com.Backend.jpa.springjpahibernateexample.repository.QuestionsRepo.CheckboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/checkbox")
public class CheckboxController {
    @Autowired
    CheckboxRepository checkboxRepository;

    @Autowired
    SetController setController;

    @GetMapping("/all")
    public List<Checkbox> getAll(){ return checkboxRepository.findAll(); }

    @GetMapping("/{id}")
    public Checkbox getId(@PathVariable("id") final Integer id) { return checkboxRepository.findOne(id); }

    @PostMapping("/")
    public Checkbox create(@RequestBody Checkbox checkbox) {
        setController.incrementCount(checkbox.getSetId());
        checkboxRepository.save(checkbox);
        return checkbox;
    }

    @PutMapping("/content/{id}")
    public Checkbox update(@PathVariable("id") final Integer id, @RequestBody Checkbox newCheckbox) {
        Checkbox checkbox = getId(id);

        checkbox.setContent(newCheckbox.getContent());
        checkbox.setAnswer_num(newCheckbox.getAnswer_num());

        if (newCheckbox.getSetId() != null) {
            updateSet(id, newCheckbox.getSetId());
        }

        checkboxRepository.save(checkbox);
        return checkbox;
    }

    @PutMapping("/set/{id}/{setId}")
    public Integer updateSet(@PathVariable("id") final Integer id, @PathVariable("setId") final Integer setId) {
        Checkbox checkbox = getId(id);

        boolean res = setController.decrementCount(checkbox.getSetId());
        if (res) {
            setController.incrementCount(setId);
            checkbox.setSetId(setId);
        }

        checkboxRepository.save(checkbox);
        return checkbox.getSetId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Integer id) {
        Checkbox checkbox = getId(id);

        checkboxRepository.delete(checkbox);
    }
}
