package com.codegym.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import javax.validation.constraints.*;
import java.util.Date;

@Entity(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Do Not Blank")
    @Size(max = 100, min = 5, message = "tu 5 den 100 ki tu")
    private String title;

    @NotBlank(message = "Do Not Blank")
    private String questionss;

    @Size(max = 100, min = 5, message = "tu 5 den 500 ki tu")
    private String answer;

    @NotBlank(message = "Do Not Blank")
    private String status;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dateCreate;

//    noi

    @ManyToOne
    @JoinColumn(name = "type_question", referencedColumnName = "id")
    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "user_create", referencedColumnName = "id")
    private User userCreate;

    @ManyToOne
    @JoinColumn(name = "user_feedback", referencedColumnName = "id")
    private User userFeedback;
    //

    public Question() {
    }

    public String getQuestionss() {
        return questionss;
    }

    public void setQuestionss(String questionss) {
        this.questionss = questionss;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return questionss;
    }

    public void setQuestion(String question) {
        this.questionss = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public User getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(User userCreate) {
        this.userCreate = userCreate;
    }

    public User getUserFeedback() {
        return userFeedback;
    }

    public void setUserFeedback(User userFeedback) {
        this.userFeedback = userFeedback;
    }
}

