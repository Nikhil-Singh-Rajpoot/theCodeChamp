package com.ayush.quiz.dto;


public class JwtRequest {


    private String email;
    private String password;

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setUsername(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
