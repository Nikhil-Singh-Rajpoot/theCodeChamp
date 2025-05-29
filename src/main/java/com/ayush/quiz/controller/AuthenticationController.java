package com.ayush.quiz.controller;


import com.ayush.quiz.dto.User;
import com.ayush.quiz.utils.JwUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwUtil jwUtil;


    //validate token api
    @GetMapping("/validateToken")
    public ResponseEntity<Map<String, Object>> validateToken(@RequestHeader("Authorization") String token) {
        Map<String, Object> response = new HashMap<>();
      //  try {
            //Extract jwt token from Authorization header
            String jwt = token.substring(7);
            //Here We are checking token that is validate or not
            if (jwUtil.validateToken(jwt)) {
                response.put("valid", true);
                return ResponseEntity.ok(response);
            }/*else{
                response.put("valid",false);
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }*/
       /* } catch (Exception e) {
           *//* response.put("valid",false);
            System.out.println("Not valid------------------------------");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);*//*
            e.printStackTrace();
        }*/
        response.put("valid", false);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    // This is a login api
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Authenticate the user
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

            // Load user details
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());

            // Generate JWT token
            String jwt = jwUtil.generateToken(userDetails.getUsername());
            String role = userDetails.getAuthorities().stream().findFirst().map(GrantedAuthority::getAuthority).orElse("ROLE_USER");
            // Prepare response data for success
            response.put("success", true);
            response.put("jwt", jwt);
            response.put("isValid",jwUtil.validateToken(jwt));
            response.put("role",role);
            response.put("message", "Login successful!");

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            // Prepare response data for failure
            response.put("success", false);
            response.put("message", "Incorrect username or password");

            // Return response with status BAD_REQUEST (400)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
