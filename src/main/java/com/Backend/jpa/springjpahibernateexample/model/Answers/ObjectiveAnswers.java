package com.Backend.jpa.springjpahibernateexample.model.Answers;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "objective_answers", catalog = "test")
public class ObjectiveAnswers {
    @Id
    @Column(name = "objective_answer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "content")
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
