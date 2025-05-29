package com.ayush.quiz.dto;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class MysqlQuizQuestions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String questionText;

    private String correctAnswer;

    @ElementCollection
    @CollectionTable(name="mysql_quiz_options",joinColumns = @JoinColumn(name="question_id"))
    @Column(name="option_text")
    private List<String> mysqlQuizOptions;

    public MysqlQuizQuestions(int id, String questionText, String correctAnswer, List<String> mysqlQuizOptions) {
        this.id = id;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.mysqlQuizOptions = mysqlQuizOptions;
    }

    public MysqlQuizQuestions() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getMysqlQuizOptions() {
        return mysqlQuizOptions;
    }

    public void setMysqlQuizOptions(List<String> mysqlQuizOptions) {
        this.mysqlQuizOptions = mysqlQuizOptions;
    }
}
