package com.ayush.quiz.repo;

import com.ayush.quiz.dto.JavascriptQuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JavascriptRepo  extends JpaRepository<JavascriptQuizQuestion,Integer>{
}
