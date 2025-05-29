package com.ayush.quiz.service;

import com.ayush.quiz.config.CustomeUserDetails;
import com.ayush.quiz.dto.User;
import com.ayush.quiz.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService
{

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String useremail) throws UsernameNotFoundException {
        // Fetch user by email
        Optional<User> user = userRepo.findUserByEmail(useremail);


        // Check if user is not present
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found with email: " + useremail);
        }

        // Get the user object from Optional
        User foundUser = user.get();
        // Create and return a custom UserDetails object (CustomeUserDetails)
        return new CustomeUserDetails(foundUser);
    }


}
