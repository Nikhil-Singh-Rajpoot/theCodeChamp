package com.ayush.quiz.service;


import com.ayush.quiz.dto.PythonQuizQuestion;
import com.ayush.quiz.repo.PythonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PythonQuizService {

    @Autowired
    private PythonRepo pythonRepo;

    //get all python quiz question
    public List<PythonQuizQuestion> getAllPythonQuestion(){
        List<PythonQuizQuestion> allPythonQues = pythonRepo.findAll();
        return allPythonQues;
    }

}
