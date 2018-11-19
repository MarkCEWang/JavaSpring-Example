package com.Backend.jpa.springjpahibernateexample.model.Relationships;

import javax.persistence.*;

@Entity
@Table(name="checkbox_qa_relationship", catalog="test")
public class CheckboxRelationship {
    @Id
    @Column(name = "checkbox_qa_relationship_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "checkbox_qid")
    private Integer questionId;
    @Column(name = "checkbox_aid")
    private Integer answerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }
}
