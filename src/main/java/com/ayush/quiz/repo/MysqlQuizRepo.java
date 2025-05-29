package com.ayush.quiz.repo;

import com.ayush.quiz.dto.MysqlQuizQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MysqlQuizRepo extends JpaRepository<MysqlQuizQuestions,Integer> {
}
