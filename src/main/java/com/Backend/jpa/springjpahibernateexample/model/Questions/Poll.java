package com.Backend.jpa.springjpahibernateexample.model.Questions;

import javax.persistence.*;

@Entity
@Table(name = "poll", catalog = "test")
public class Poll {
    @Id
    @Column(name = "poll_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "content")
    private String content;
    @Column(name = "poll_set_id")
    private Integer setId;
    //poll value uses boolean to represent how many choices this poll has: return true value -> 4 choices, false value -> 2 choices
    @Column(name = "options")
    private boolean option;
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

    public boolean getOption() {
        return option;
    }

    public void setOption(boolean option) {
        this.option = option;
    }

    public Integer getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(Integer answerNum) {
        this.answerNum = answerNum;
    }
}

