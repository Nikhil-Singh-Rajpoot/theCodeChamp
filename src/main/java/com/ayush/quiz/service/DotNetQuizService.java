package com.ayush.quiz.service;

import com.ayush.quiz.dto.DotNetQuestions;
import com.ayush.quiz.repo.dotNetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DotNetQuizService {

    @Autowired
    private dotNetRepo dotNetrepo;

    //get All Dot Net Question
    public List<DotNetQuestions> getAllQues(){
        //getting all the dot net question an return
        List<DotNetQuestions> all = dotNetrepo.findAll();
        return all;

    }
}
