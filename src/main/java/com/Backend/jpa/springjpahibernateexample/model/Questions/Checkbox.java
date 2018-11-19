package com.Backend.jpa.springjpahibernateexample.model.Questions;

import javax.persistence.*;

@Entity
@Table(name = "checkbox", catalog = "test")
public class Checkbox {

    @Id
    @Column(name = "checkbox_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "content")
    private String content;
    @Column(name = "checkbox_set_id")
    private Integer setId;
    @Column(name = "answer_num")
    private Integer answerNum;

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

    public Integer getAnswer_num() {
        return answerNum;
    }

    public void setAnswer_num(Integer answerNum) {
        this.answerNum = answerNum;
    }
}
