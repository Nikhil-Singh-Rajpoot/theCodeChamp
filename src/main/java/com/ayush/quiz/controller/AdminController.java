package com.ayush.quiz.controller;

import com.ayush.quiz.dto.AddNotes;
import com.ayush.quiz.service.AdminService;
import com.ayush.quiz.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private NotesService notesService;

    //Write controller for fetching the all tables for database
    @GetMapping("/showTable")
    public List<String> getAllTables(){
        return adminService.getAllTables();
    }

    //Add Questions in db
    // Add a new question to a specific table
    @PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Map<String, String> requestData) {
        String tableName = requestData.get("tableName");
        String text = requestData.get("questionText");
        String correctAnswer = requestData.get("correctAnswer");
        if (tableName == null || text == null || correctAnswer == null) {
            return ResponseEntity.badRequest().body("Invalid input data");
        }
        return ResponseEntity.ok(adminService.addQuestion(tableName, text, correctAnswer));
    }
    //Finding id by question
    @PostMapping("/findId")
    public ResponseEntity<Map<String,String>> findById(@RequestBody Map<String,String> requestData){
        Map<String, String> response =new  HashMap<>();
        String table = requestData.get("table");
        String question = requestData.get("question");
        if (table == null || question == null){
            response.put("False","Data is Not valid");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        String questionId = adminService.findQuestionId(table, question);
        if (questionId==null){
            response.put("False","Data is Not valid");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }else{
            response.put("id",questionId);
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Map<String,String>> insertData(@RequestBody Map<String, String> requestData) {
        String id = requestData.get("id");
        String table = requestData.get("table");
        String option1 = requestData.get("option1");
        String option2 = requestData.get("option2");
        String option3 = requestData.get("option3");
        String option4 = requestData.get("option4");
        //For response prepration
        Map<String,String> response = new HashMap<>();
        if (id!=null ||table!=null){
            adminService.saveData(Integer.parseInt(id),table, option1);
            adminService.saveData(Integer.parseInt(id),table, option2);
            adminService.saveData(Integer.parseInt(id),table, option3);
            adminService.saveData(Integer.parseInt(id),table, option4);
            response.put("true","Data Successfully saved into "+table);
            return ResponseEntity.ok(response);
        }
        response.put("false","Your data invalid! Bad Request!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @PostMapping("/saveNote")
    public ResponseEntity<String> uploadNotes(@RequestParam("title") String title,
                              @RequestParam("coverFile") MultipartFile coverpage,
                              @RequestParam("noteFile") MultipartFile uploadNotes) throws IOException {
        // Implement file saving logic (store in database or file system)
        AddNotes note = notesService.saveNotes(title,uploadNotes,coverpage);
        if (note!=null){
            return ResponseEntity.ok("Note are not uploaded !");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Notes uploaded successfully!");
    }

    // Fetch all notes
    @GetMapping("/getNotes")
    public List<AddNotes> getAllNotes() {
        List<AddNotes> notes = notesService.getAllNotes();
        return notes.stream().map(note -> new AddNotes(
                note.getId(),
                note.getCoverPage(), // Convert byte[] to Base64 String
                note.getNotesFile(),
                note.getTitle(),
                note.getFileName()
        )).collect(Collectors.toList());
    }

    // Download a note file
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadNoteFile(@PathVariable int id) {
        AddNotes note = notesService.getNoteById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + note.getFileName())
                .body(note.getNotesFile());
    }
}
