package com.ayush.quiz.repo;

import com.ayush.quiz.dto.JavaCollectionsQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JavaCollectionRepo extends JpaRepository<JavaCollectionsQuiz,Integer> {
}
