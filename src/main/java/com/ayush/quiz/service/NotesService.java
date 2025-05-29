package com.ayush.quiz.service;

import com.ayush.quiz.dto.AddNotes;
import com.ayush.quiz.repo.NotesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotesService {
    @Autowired
    private NotesRepo notesRepo;

    //For save the file into database
    public AddNotes saveNotes(String title, MultipartFile file,MultipartFile coverPage) throws IOException {
        AddNotes note = new AddNotes();
        //setting the data
        note.setTitle(title);
        note.setCreatedAt(LocalDateTime.now());

        if(file!=null && !file.isEmpty()){
        note.setFileName(file.getOriginalFilename());
        note.setNotesFile(file.getBytes());
        }
        //If cover page is not null
        if(coverPage!=null){
        note.setCoverPage(coverPage.getBytes());
        }
        //save file into database
        AddNotes save = notesRepo.save(note);
        return save;
    }

    //Serving the data from database
    public Optional<AddNotes> getNotes(int id){
        Optional<AddNotes> note = notesRepo.findById(id);
        return note;
    }

    // Fetch all notes
    public List<AddNotes> getAllNotes() {
        return notesRepo.findAll();
    }

    // Fetch a note by ID
    public AddNotes getNoteById(int id) {
        Optional<AddNotes> note = notesRepo.findById(id);
        return note.orElseThrow(() -> new RuntimeException("Note not found with ID: " + id));
    }
}
