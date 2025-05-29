package com.ayush.quiz.service;

import com.ayush.quiz.dto.User;
import com.ayush.quiz.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    //save user detail
    public User saveUser(User user){
        User saveUserDetails = userRepo.save(user);
        return saveUserDetails;
    }

    //get user by email
    public Optional<User> getUserByEmail(String email){
        Optional<User> userByEmail = userRepo.findUserByEmail(email);
        return  userByEmail;
    }
}
