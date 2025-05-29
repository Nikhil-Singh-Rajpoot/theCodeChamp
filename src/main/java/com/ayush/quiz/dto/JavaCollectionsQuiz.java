package com.ayush.quiz.dto;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class JavaCollectionsQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String questionText;

    private String correctAnswer;

    @ElementCollection
    @CollectionTable(name="java_collection_quiz_options",joinColumns = @JoinColumn(name="question_id"))
    @Column(name="option_text")
    private List<String> collectionOptions;

    public JavaCollectionsQuiz() {
    }

    public JavaCollectionsQuiz(int id, String questionText, String correctAnswer, List<String> collectionOptions) {
        this.id = id;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.collectionOptions = collectionOptions;
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

    public List<String> getCollectionOptions() {
        return collectionOptions;
    }

    public void setCollectionOptions(List<String> collectionOptions) {
        this.collectionOptions = collectionOptions;
    }
}
