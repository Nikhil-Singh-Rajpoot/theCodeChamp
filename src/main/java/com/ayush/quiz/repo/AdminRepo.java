package com.ayush.quiz.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AdminRepo{
    @Autowired
    private JdbcTemplate jdbcTemplate;
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

    public List<String> findAllTables(){
        String sql = "SHOW TABLES";
        return jdbcTemplate.queryForList(sql,String.class);
    }

    // Insert a question dynamically into the selected table
    public int addQuestionToTable(String tableName, String questionText, String correctAnswer) {
        String sql = "INSERT INTO " + tableName + " (question_text, correct_answer) VALUES (?, ?)";
        return jdbcTemplate.update(sql, questionText, correctAnswer);
    }

    //Search id from the table
    public String getIdByQuestion(String tableName, String question) {
        String sql = "SELECT id FROM "+tableName+" WHERE question_text = ?";
        try {
            return jdbcTemplate.queryForObject(sql,String.class,question);
        } catch (EmptyResultDataAccessException e) {
            return null;
            // Return 0 if no record is found (or any default value)
        }
    }
    //For saving data into database
    public int insertData(int id, String table, String option1) {
        String sql = "INSERT INTO "+table+" (question_id, option_text) VALUES (?, ?)";
        return jdbcTemplate.update(sql, id, option1);
    }
}
