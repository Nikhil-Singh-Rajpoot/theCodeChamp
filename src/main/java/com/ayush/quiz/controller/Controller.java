package com.ayush.quiz.controller;

import com.ayush.quiz.dto.*;
import com.ayush.quiz.repo.CppQuizRepo;
import com.ayush.quiz.repo.JavaCollectionRepo;
import com.ayush.quiz.service.JavascriptQuizService;
import com.ayush.quiz.service.PythonQuizService;
import com.ayush.quiz.service.QuestionService;
import com.ayush.quiz.service.DotNetQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private PythonQuizService pythonQuizService;

    @Autowired
    private JavascriptQuizService javascriptQuizService;

    @Autowired
    private DotNetQuizService dotNetQuizService;

    //handler for getting all question
    @GetMapping("/allQuestions")
    public List<QuizQuestion> getAllQuestions(){
        List<QuizQuestion> allQuestion = questionService.getAllQuestion();
        return allQuestion;
    }

    //get all question of python quiz
    @GetMapping("/pythonQuestions")
    public List<PythonQuizQuestion> getAllPythonQues(){
        List<PythonQuizQuestion> allPythonQuestion = pythonQuizService.getAllPythonQuestion();
        return allPythonQuestion;
    }

    //get All Javascript Question
    @GetMapping("/javascriptQuestions")
    public List<JavascriptQuizQuestion> getAllJsQuizQuestion(){
        List<JavascriptQuizQuestion> allJsQuestion = javascriptQuizService.getAllJsQuestion();
        return allJsQuestion;
    }

    @GetMapping("/dotNetQuestions")
    public List<DotNetQuestions> getAllDotNetQuestion(){
        List<DotNetQuestions> alldotNetQues = dotNetQuizService.getAllQues();
        return alldotNetQues;
    }

    @GetMapping("/cQuizQuestions")
    public List<CQuizQuestions> getAllCQuestion(){
        List<CQuizQuestions> allCQuestion = questionService.getCAllQuestion();
        return allCQuestion;
    }

    @GetMapping("/cppQuizQuestions")
    public List<CppQuizQuestions> getAllCppQuestion(){
        List<CppQuizQuestions> allCppQuestion = questionService.getAllCppQuestion();
        return allCppQuestion;
    }

    @GetMapping("/jdbcQuizQuestions")
    public List<JdbcQuizQuestions> getAllJdbcQuestion(){
        List<JdbcQuizQuestions> allJdbcQuestion = questionService.getAllJdbcQuestion();
        return allJdbcQuestion;
    }

    @GetMapping("/collectionQuizQuestions")
    public List<JavaCollectionsQuiz> getAllCollectionQuiz(){
        List<JavaCollectionsQuiz> allCollection = questionService.getAllCollection();
        return allCollection;
    }

    @GetMapping("/reactQuiz")
    public List<ReactQuizQuestions> getAllReactQuiz(){
        List<ReactQuizQuestions> allReact = questionService.getAllReactQuiz();
        return allReact;
    }
    @GetMapping("/hibernateQuiz")
    public List<HibernateQuizQuestions> getAllHibernateQuiz(){
        List<HibernateQuizQuestions> allHibernate = questionService.getAllHibernateQuiz();
        return allHibernate;
    }
    @GetMapping("/springQuiz")
    public List<SpringCoreQuizQuestions> getAllSpringQuiz() {
        List<SpringCoreQuizQuestions> allSpring = questionService.getAllSpringCoreQuiz();
        return allSpring;
    }
    @GetMapping("/mysqlQuiz")
    public List<MysqlQuizQuestions> getAllMysqlQuiz(){
        List<MysqlQuizQuestions> allMysql = questionService.getAllMysqlQuestion();
        return allMysql;
    }
}
