package com.ayush.quiz.repo;

import com.ayush.quiz.dto.DotNetQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface dotNetRepo extends JpaRepository<DotNetQuestions,Integer> {
}
