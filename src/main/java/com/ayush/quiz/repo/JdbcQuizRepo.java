package com.ayush.quiz.repo;

import com.ayush.quiz.dto.JdbcQuizQuestions;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface JdbcQuizRepo extends JpaRepository<JdbcQuizQuestions,Integer> {
}
