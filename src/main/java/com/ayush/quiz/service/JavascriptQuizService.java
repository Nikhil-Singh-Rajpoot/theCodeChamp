package com.ayush.quiz.service;

import com.ayush.quiz.dto.JavascriptQuizQuestion;
import com.ayush.quiz.repo.JavascriptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JavascriptQuizService {


    //create javascript variable
    @Autowired
    private JavascriptRepo javascriptRepo;

    //get all javascript question from the database
    public List<JavascriptQuizQuestion> getAllJsQuestion(){
        List<JavascriptQuizQuestion> jsAllQues = javascriptRepo.findAll();
        return jsAllQues;
    }

}
