package com.ayush.quiz.repo;

import com.ayush.quiz.dto.AddNotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepo extends JpaRepository<AddNotes,Integer> {
}
