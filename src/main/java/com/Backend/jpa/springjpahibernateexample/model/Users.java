package com.Backend.jpa.springjpahibernateexample.model;

import javax.persistence.*;

@Entity
@Table(name = "users", catalog = "test")
public class Users {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "name")
    private String name;
    @Column(name = "score")
    private Integer score;
    @Column(name = "password")
    private String password;

    public Users() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() { return uuid; }

    public void setUuid(String uuid) {this.uuid = uuid; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() { return score; }

    public void setScore(Integer score) { this.score = score; }

    public void setSalary(Integer score) {
        this.score = score;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String teamName) {
        this.password = teamName;
    }

    public void updateFields(Users user) {
        if (user.getName() != null) {
            this.setName(user.name);
        }
        if (user.score != null) {
            this.score = user.score;
        }
        if (user.password != null) {
            this.password = user.password;
        }
    }

    public void updateAllFields(Users user) {
        this.setName(user.name);
        this.setSalary(user.score);
        this.setPassword(user.password);
    }
}
