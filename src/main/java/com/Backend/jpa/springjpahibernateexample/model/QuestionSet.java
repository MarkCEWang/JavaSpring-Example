package com.Backend.jpa.springjpahibernateexample.model;

import javax.persistence.*;

@Entity
@Table(name="set", catalog="test")
public class QuestionSet {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "set_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "content")
    private String content;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Column(name = "count")
    private Integer count;

}
