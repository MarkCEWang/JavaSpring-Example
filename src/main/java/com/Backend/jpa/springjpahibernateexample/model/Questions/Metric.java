package com.Backend.jpa.springjpahibernateexample.model.Questions;

import javax.persistence.*;

@Entity
@Table(name = "metric", catalog = "test")
public class Metric {
    @Id
    @Column(name = "metric_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "content")
    private String content;
    @Column(name = "metric_set_id")
    private Integer setId;
    @Column(name = "horizontal_category")
    private String horizontalCategory;
    @Column(name = "vertical_category")
    private String verticalCategory;

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

    public String getHorizontalCategory() {
        return horizontalCategory;
    }

    public void setHorizontalCategory(String horizontalCategory) {
        this.horizontalCategory = horizontalCategory;
    }

    public String getVerticalCategory() {
        return verticalCategory;
    }

    public void setVerticalCategory(String verticalCategory) {
        this.verticalCategory = verticalCategory;
    }
}
