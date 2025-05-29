package com.ayush.quiz.dto;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class HibernateQuizQuestions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String questionText;

    private String correctAnswer;

    @ElementCollection
    @CollectionTable(name="hibernate_quiz_options",joinColumns = @JoinColumn(name="question_id"))
    @Column(name="option_text")
    private List<String> hibernateQuizOptions;

    public HibernateQuizQuestions(int id, String questionText, String correctAnswer, List<String> hibernateQuizOptions) {
        this.id = id;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.hibernateQuizOptions = hibernateQuizOptions;
    }

    public HibernateQuizQuestions() {
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

    public List<String> getHibernateQuizOptions() {
        return hibernateQuizOptions;
    }

    public void setHibernateQuizOptions(List<String> hibernateQuizOptions) {
        this.hibernateQuizOptions = hibernateQuizOptions;
    }
}
