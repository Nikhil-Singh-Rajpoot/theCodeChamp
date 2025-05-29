package com.ayush.quiz.dto;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class DotNetQuestions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String questionText;

    private String correctAnswer;

    @ElementCollection
    @CollectionTable(name="dotNet_quiz_options",joinColumns = @JoinColumn(name="question_id"))
    @Column(name="option_text")
    private List<String> dotNetOptions;


    //Generate getter & setter method for all the data member
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

    public List<String> getDotNetOptions() {
        return dotNetOptions;
    }

    public void setDotNetOptions(List<String> dotNetOptions) {
        this.dotNetOptions = dotNetOptions;
    }
}
