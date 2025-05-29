package com.ayush.quiz.service;

import com.ayush.quiz.dto.*;
import com.ayush.quiz.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {


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


    //get All question
    public List<QuizQuestion> getAllQuestion(){
        List<QuizQuestion> all = questionRepo.findAll();
        return all;
    }

    public QuizQuestion saveQuestion(QuizQuestion question){
        QuizQuestion save = questionRepo.save(question);
        return save;
    }

    //C language Quiz
    public List<CQuizQuestions> getCAllQuestion(){
        List<CQuizQuestions> all = cQuizRepo.findAll();
        return all;
    }
    public CQuizQuestions saveCQuestions(CQuizQuestions cQuizQuestions){
        CQuizQuestions save = cQuizRepo.save(cQuizQuestions);
        return save;
    }

    //Cpp Language Quiz
    public List<CppQuizQuestions> getAllCppQuestion(){
        List<CppQuizQuestions> all = cppQuizRepo.findAll();
        return all;
    }

    //JDBC Quiz
    public List<JdbcQuizQuestions> getAllJdbcQuestion(){
        List<JdbcQuizQuestions> all = jdbcQuizRepo.findAll();
        return all;
    }

    //JavaCollection
    public List<JavaCollectionsQuiz> getAllCollection(){
        List<JavaCollectionsQuiz> all = javaCollectionRepo.findAll();
        return all;
    }
    //React Quiz Questions
    public List<ReactQuizQuestions> getAllReactQuiz(){
        List<ReactQuizQuestions> all = reactQuizRepo.findAll();
        return all;
    }
    //Hibernate Quiz Questions
    public List<HibernateQuizQuestions> getAllHibernateQuiz(){
        List<HibernateQuizQuestions> all = hibernateQuizRepo.findAll();
        return all;
    }
    //Spring Core
    public List<SpringCoreQuizQuestions> getAllSpringCoreQuiz(){
        List<SpringCoreQuizQuestions> all = springCoreQuizRepo.findAll();
        return all;
    }
    //Mysql Quiz
    public List<MysqlQuizQuestions> getAllMysqlQuestion(){
        List<MysqlQuizQuestions> all = mysqlQuizRepo.findAll();
        return all;
    }
}
