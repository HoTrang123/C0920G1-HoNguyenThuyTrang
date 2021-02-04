package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;

    @OneToMany(mappedBy = "questionType")
    private List<Question> userCreate;

    @OneToMany(mappedBy = "questionType")
    private List<Question> userFeedback;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Question> getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(List<Question> userCreate) {
        this.userCreate = userCreate;
    }

    public List<Question> getUserFeedback() {
        return userFeedback;
    }

    public void setUserFeedback(List<Question> userFeedback) {
        this.userFeedback = userFeedback;
    }
}
