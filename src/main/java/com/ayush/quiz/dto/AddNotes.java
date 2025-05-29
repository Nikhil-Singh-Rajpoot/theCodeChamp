package com.ayush.quiz.dto;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class AddNotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Lob
    private byte[] coverPage;
    @Lob
    private byte[] notesFile;
    private String title;
    private LocalDateTime createdAt;
    private String fileName;

    public AddNotes() {
    }

    public AddNotes(int id, byte[] coverPage, String title, LocalDateTime createdAt, String fileName) {
        this.id = id;
        this.coverPage = coverPage;
        this.title = title;
        this.createdAt = createdAt;
        this.fileName = fileName;
    }

    public AddNotes(int id, byte[] coverPage, byte[] notesFile, String title, String fileName) {
        this.id = id;
        this.coverPage = coverPage;
        this.title = title;
        this.fileName = fileName;
        this.notesFile=notesFile;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getCoverPage() {
        return coverPage;
    }

    public void setCoverPage(byte[] coverPage) {
        this.coverPage = coverPage;
    }

    public byte[] getNotesFile() {
        return notesFile;
    }

    public void setNotesFile(byte[] notesFile) {
        this.notesFile = notesFile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
