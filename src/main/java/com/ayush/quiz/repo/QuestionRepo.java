package com.ayush.quiz.repo;

import com.ayush.quiz.dto.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionRepo extends JpaRepository<QuizQuestion,Long> {
}
