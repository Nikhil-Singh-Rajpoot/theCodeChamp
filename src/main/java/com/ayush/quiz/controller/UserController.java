package com.ayush.quiz.controller;

import com.ayush.quiz.dto.User;
import com.ayush.quiz.service.EmailService;
import com.ayush.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;



@RestController
@RequestMapping("/user")
public class UserController {

     @Autowired
     private UserService userService;

     @Autowired
     private BCryptPasswordEncoder passwordEncoder;

     @Autowired
     private EmailService emailService;

     //This is register Api for user registaration
    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> registerUser(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();

        try {
            user.setRole("ROLE_USER");
            String tempPass= user.getPassword();
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User savedUser = null;
                // Save the user
                savedUser = userService.saveUser(user);
            // Prepare response data with success flag
            response.put("success", true);
            response.put("user", savedUser);
            response.put("message", "User registered successfully");
            emailService.sendEmail(user.getEmail(),user.getName(),tempPass);
            // Return response with status OK (200)
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Prepare response data for failure case
            response.put("success", false);
            response.put("message", "User registration failed. " + e.getMessage());
            System.out.println(e);
            // Return response with status BAD_REQUEST (400)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

}
