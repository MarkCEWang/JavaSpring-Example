package com.Backend.jpa.springjpahibernateexample.controller.Questions;

import com.Backend.jpa.springjpahibernateexample.controller.Answers.ObjectiveAnswersController;
import com.Backend.jpa.springjpahibernateexample.controller.SetController;
import com.Backend.jpa.springjpahibernateexample.model.Answers.ObjectiveAnswers;
import com.Backend.jpa.springjpahibernateexample.model.Questions.Metric;
import com.Backend.jpa.springjpahibernateexample.repository.QuestionsRepo.MetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/metric")
public class MetricController {
    @Autowired
    MetricRepository metricRepository;

    @Autowired
    SetController setController;

    @Autowired
    ObjectiveAnswersController objectiveAnswersController;

    @GetMapping("/all")
    public List<Metric> getAll() { return metricRepository.findAll(); }

    @GetMapping("/{id}")
    public Metric getId(@PathVariable("id") final Integer id) { return metricRepository.findOne(id); }

    @GetMapping("/horizontal/{id}")
    public List<ObjectiveAnswers> getHorizontalCategoryChoices(@PathVariable("id") final Integer id) {
        String category = this.getId(id).getHorizontalCategory();
        return objectiveAnswersController.getByCategory(category);
    }

    @GetMapping("/vertical/{id}")
    public List<ObjectiveAnswers> getVerticalCategoryChoices(@PathVariable("id") final Integer id) {
        String category = this.getId(id).getVerticalCategory();
        return objectiveAnswersController.getByCategory(category);
    }

    @PostMapping("/")
    public Metric create(@RequestBody Metric metric) {
        setController.incrementCount(metric.getSetId());
        metricRepository.save(metric);
        return metric;
    }

    @PutMapping("/{id}")
    public Metric update(@PathVariable("id") final Integer id, @RequestBody Metric newMetric) {
        Metric metric = getId(id);
        metric.setContent(newMetric.getContent());

        if (newMetric.getSetId() != null) {
            updateSet(id, newMetric.getSetId());
        }

        metricRepository.save(metric);
        return metric;
    }

    @PutMapping("/set/{id}/{setId}")
    public Integer updateSet(@PathVariable("id") final Integer id, @PathVariable("id") final Integer setId) {
        Metric metric = getId(id);
        boolean res = setController.decrementCount(metric.getSetId());
        if (res) {
            setController.incrementCount(setId);
            metric.setSetId(setId);
        }

        metricRepository.save(metric);
        return metric.getSetId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Integer id) {
        Metric metric = getId(id);
        metricRepository.delete(metric);
    }
}
