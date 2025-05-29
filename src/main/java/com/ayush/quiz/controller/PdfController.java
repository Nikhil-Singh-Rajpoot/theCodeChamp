package com.ayush.quiz.controller;


import com.ayush.quiz.dto.AddNotes;
import com.ayush.quiz.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/notes")
public class PdfController {

    @Autowired
    private NotesService notesService;

    @GetMapping("/java-pdf")
    public ResponseEntity<byte[]> javaPdf() throws IOException {
        // Load the PDF file from the resources directory
        ClassPathResource pdfFile = new ClassPathResource("files/java.pdf");

        // Read the PDF file into a byte array
        byte[] pdfData = pdfFile.getInputStream().readAllBytes();

        // Create HTTP headers for the response
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        // Explicitly set Content-Disposition to inline
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"java.pdf\"");

        // Return the PDF data in the response with correct headers
        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfData);
    }
//here we write a controller for Compiler Notes and we need to write each and every notes Controller
    @GetMapping("/compiler-pdf")
    public ResponseEntity<byte[]> compilerDesignPdf() throws IOException {
        // Load the PDF file from the resources directory
        ClassPathResource pdfFile = new ClassPathResource("files/compiler.pdf");

        // Read the PDF file into a byte array
        byte[] pdfData = pdfFile.getInputStream().readAllBytes();

        // Create HTTP headers for the response
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        // Explicitly set Content-Disposition to inline
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"compiler.pdf\"");

        // Return the PDF data in the response with correct headers
        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfData);
    }

    //here we write a controller for Hibernate Notes and we need to write each and every notes Controller
    @GetMapping("/hibernate-pdf")
    public ResponseEntity<byte[]> hibernateNotes() throws IOException {
        // Load the PDF file from the resources directory
        ClassPathResource pdfFile = new ClassPathResource("files/hibernat.pdf");

        // Read the PDF file into a byte array
        byte[] pdfData = pdfFile.getInputStream().readAllBytes();

        // Create HTTP headers for the response
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        // Explicitly set Content-Disposition to inline
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"hibernat.pdf\"");

        // Return the PDF data in the response with correct headers
        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfData);
    }

    //here we write a controller for dsa Notes and we need to write each and every notes Controller
    @GetMapping("/dsa-pdf")
    public ResponseEntity<byte[]> dsaNotes() throws IOException {
        // Load the PDF file from the resources directory
        ClassPathResource pdfFile = new ClassPathResource("files/dsa.pdf");

        // Read the PDF file into a byte array
        byte[] pdfData = pdfFile.getInputStream().readAllBytes();

        // Create HTTP headers for the response
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        // Explicitly set Content-Disposition to inline
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"dsa.pdf\"");

        // Return the PDF data in the response with correct headers
        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfData);
    }

    //here we write a controller for dsa Notes and we need to write each and every notes Controller
    @GetMapping("/spring-pdf")
    public ResponseEntity<byte[]> springNotes() throws IOException {
        // Load the PDF file from the resources directory
        ClassPathResource pdfFile = new ClassPathResource("files/spring.pdf");

        // Read the PDF file into a byte array
        byte[] pdfData = pdfFile.getInputStream().readAllBytes();

        // Create HTTP headers for the response
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        // Explicitly set Content-Disposition to inline
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"spring.pdf\"");

        // Return the PDF data in the response with correct headers
        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfData);
    }
    //here we write a controller for JPA Notes and we need to write each and every notes Controller
    @GetMapping("/jsp-pdf")
    public ResponseEntity<byte[]> jpaNotes() throws IOException {
        // Load the PDF file from the resources directory
        ClassPathResource pdfFile = new ClassPathResource("files/jsp.pdf");

        // Read the PDF file into a byte array
        byte[] pdfData = pdfFile.getInputStream().readAllBytes();

        // Create HTTP headers for the response
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        // Explicitly set Content-Disposition to inline
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"jsp.pdf\"");

        // Return the PDF data in the response with correct headers
        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfData);
    }

    @GetMapping("/sql-pdf")
    public ResponseEntity<byte[]> sqlPdf() throws IOException {
        // Load the PDF file from the resources directory
        ClassPathResource pdfFile = new ClassPathResource("files/sql.pdf");

        // Read the PDF file into a byte array
        byte[] pdfData = pdfFile.getInputStream().readAllBytes();

        // Create HTTP headers for the response
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        // Explicitly set Content-Disposition to inline
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"sql.pdf\"");

        // Return the PDF data in the response with correct headers
        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfData);
    }

    @GetMapping("/dbms-pdf")
    public ResponseEntity<byte[]> dbmsPdf() throws IOException {
        // Load the PDF file from the resources directory
        ClassPathResource pdfFile = new ClassPathResource("files/dbms.pdf");

        // Read the PDF file into a byte array
        byte[] pdfData = pdfFile.getInputStream().readAllBytes();

        // Create HTTP headers for the response
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        // Explicitly set Content-Disposition to inline
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"dbms.pdf\"");

        // Return the PDF data in the response with correct headers
        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfData);
    }

    @GetMapping("/descrite-pdf")
    public ResponseEntity<byte[]> desecritePdf() throws IOException {
        // Load the PDF file from the resources directory
        ClassPathResource pdfFile = new ClassPathResource("files/desecrite.pdf");

        // Read the PDF file into a byte array
        byte[] pdfData = pdfFile.getInputStream().readAllBytes();

        // Create HTTP headers for the response
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        // Explicitly set Content-Disposition to inline
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"desecrite.pdf\"");

        // Return the PDF data in the response with correct headers
        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfData);
    }

    @GetMapping("/coa-pdf")
    public ResponseEntity<byte[]> coaPdf() throws IOException {
        // Load the PDF file from the resources directory
        ClassPathResource pdfFile = new ClassPathResource("files/coa.pdf");

        // Read the PDF file into a byte array
        byte[] pdfData = pdfFile.getInputStream().readAllBytes();

        // Create HTTP headers for the response
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        // Explicitly set Content-Disposition to inline
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"coa.pdf\"");

        // Return the PDF data in the response with correct headers
        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfData);
    }

    //Dynamic add Notes on databse
    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Map<String, Object> saveNotes(
            @RequestParam String title,
            @RequestParam(required = false) MultipartFile coverPage,
            @RequestParam(required = false) MultipartFile file
    ) throws IOException {
        //Save file into database
        AddNotes notes = notesService.saveNotes(title,file,coverPage);
        //Prepare response
        Map<String, Object> response = new HashMap<>();
        response.put("status" , "success");
        response.put("message","Note added Successfully");
        response.put("note",notes);
        return response;
    }

    @GetMapping("/getNote/{id}")
    public Map<String, Object> getNotes(@PathVariable int id) {
        AddNotes note = notesService.getNotes(id).orElseThrow(() -> new RuntimeException("File not found"));

        // Prepare the response
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("title", note.getTitle());

        // Convert files to base64 encoding (optional, useful for embedding images)
        String coverPageBase64 = Base64.getEncoder().encodeToString(note.getCoverPage());
        String notesFileBase64 = Base64.getEncoder().encodeToString(note.getNotesFile());

        response.put("coverPage", coverPageBase64);
        response.put("file", notesFileBase64);

        return response;
    }

}
