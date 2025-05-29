package com.ayush.quiz.repo;

import com.ayush.quiz.dto.PythonQuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PythonRepo extends JpaRepository<PythonQuizQuestion,Integer> {
}
