package com.ayush.quiz.service;

import com.ayush.quiz.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;
    //getting question repo object
    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    private CQuizRepo cQuizRepo;
    @Autowired
    private CppQuizRepo cppQuizRepo;
    @Autowired
    private JdbcQuizRepo jdbcQuizRepo;
    @Autowired
    private JavaCollectionRepo javaCollectionRepo;
    @Autowired
    private ReactQuizRepo reactQuizRepo;
    @Autowired
    private HibernateQuizRepo hibernateQuizRepo;
    @Autowired
    private SpringCoreQuizRepo springCoreQuizRepo;
    @Autowired
    private MysqlQuizRepo mysqlQuizRepo;

    public List<String> getAllTables(){
        return adminRepo.findAllTables();
    }

    public String addQuestion(String tableName, String text, String correctAnswer) {
        int rows = adminRepo.addQuestionToTable(tableName, text, correctAnswer);
        return rows > 0 ? "Question added successfully to " + tableName : "Failed to add question!";
    }

    public String findQuestionId(String tableName,String question) {
        return adminRepo.getIdByQuestion(tableName,question);
    }

    public void saveData(int id, String table, String option1) {
        adminRepo.insertData(id, table, option1);
    }

}
