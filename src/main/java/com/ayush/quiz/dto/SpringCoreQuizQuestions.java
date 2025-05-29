package com.ayush.quiz.dto;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class SpringCoreQuizQuestions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String questionText;

    private String correctAnswer;

    @ElementCollection
    @CollectionTable(name="springCore_quiz_options",joinColumns = @JoinColumn(name="question_id"))
    @Column(name="option_text")
    private List<String> springCore_Quiz_Options;

    public SpringCoreQuizQuestions(int id, String questionText, String correctAnswer, List<String> springCore_Quiz_Options) {
        this.id = id;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.springCore_Quiz_Options = springCore_Quiz_Options;
    }

    public SpringCoreQuizQuestions() {
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

    public List<String> getSpringCore_Quiz_Options() {
        return springCore_Quiz_Options;
    }

    public void setSpringCore_Quiz_Options(List<String> springCore_Quiz_Options) {
        this.springCore_Quiz_Options = springCore_Quiz_Options;
    }

}
