package com.ayush.quiz.repo;

import com.ayush.quiz.dto.HibernateQuizQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HibernateQuizRepo extends JpaRepository<HibernateQuizQuestions,Integer> {
}
