package com.ayush.quiz.repo;

import com.ayush.quiz.dto.SpringCoreQuizQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringCoreQuizRepo extends JpaRepository<SpringCoreQuizQuestions,Integer> {
}
