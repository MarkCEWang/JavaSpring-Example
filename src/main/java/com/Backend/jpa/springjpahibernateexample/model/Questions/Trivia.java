package com.Backend.jpa.springjpahibernateexample.model.Questions;

import javax.persistence.*;

@Entity
@Table(name = "trivia", catalog = "test")
public class Trivia {
    @Id
    @Column(name = "trivia_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "content")
    private String content;
    @Column(name = "set_id")
    private Integer setId;
    @Column(name = "correct_answer")
    private String correctAnswer;
    @Column(name = "wrong_answer")
    private String wrongAnswer;

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

    public Integer getSetId() {
        return setId;
    }

    public void setSetId(Integer setId) {
        this.setId = setId;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAns) {
        this.correctAnswer = correctAns;
    }

    public String getWrongAnswer() {
        return wrongAnswer;
    }

    public void setWrongAnswer(String wrongAnswer) {
        this.wrongAnswer = wrongAnswer;
    }
}
