package com.ayush.quiz.repo;

import com.ayush.quiz.dto.CppQuizQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface CppQuizRepo extends JpaRepository<CppQuizQuestions,Integer> {
}
