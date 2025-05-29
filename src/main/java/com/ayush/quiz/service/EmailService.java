package com.ayush.quiz.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;


    private final Random random = new Random();

    // Generate a 6-digit random OTP
    public String generateOtp() {
        return String.valueOf(100000 + random.nextInt(900000));
    }


    //create method send otp to entered email
    public void sendOtp(String email, String otp) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(sender);
            message.setTo(email);
            message.setSubject("Your One-Time Password (OTP) for Change password - CodeChamp");

            // Email Body
            String emailBody = "Dear Candidate,\n\n" +
                    "Your One-Time Password (OTP) for login: *" + otp + "*\n\n" +
                    "⚠ OTP is valid only for *05:00 minutes*. Do not share this OTP with anyone.\n\n" +
                    "Please note that the OTP is valid for only one session. If you refresh the page or leave the CodeChamp portal, you will be required to regenerate a new OTP.\n\n" +
                    "If you did not request this OTP, please contact us immediately at *support@codechamp.com*.\n\n" +
                    "Regards,\n" +
                    "Talent Acquisition Team\n" +
                    "CodeChamp\n" +
                    "support@codechamp.com";

            message.setText(emailBody);

            // Log for Debugging
            System.out.println("Email Message: " + message);

            // Send Email
            javaMailSender.send(message);
            System.out.println("OTP sent successfully to: " + email);

        } catch (Exception e) {
            System.out.println("Failed to send OTP: " + e.getMessage());
            throw new RuntimeException("Email sending failed");
        }
    }

    //send email after registeration
    public void sendEmail(String email, String name, String password) {
        // Create an object of SimpleMailMessage
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // Set message details
        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("Welcome to TheCodeChamp!");
        simpleMailMessage.setText("Dear " + name + ",\n\n"
                + "Congratulations! You have successfully registered on the TheCodeChamp Platform.\n\n"
                + "Your Username is "+email+"\n" +"Your Password is "+password+"\n"
                + "We are excited to have you on board and appreciate your interest in TheCodeChamp for virtual internships. Our platform is designed to help you gain hands-on experience and enhance your skills in a professional environment.\n\n"
                + "Next Steps:\n"
                + "1. Connect to the internet and click on link http://www.thecodechamp.in/ \n "
                + "✅ Explore the latest projects and learning resources.\n"
                + "✅ Stay tuned for upcoming internship opportunities.\n"
                + "✅ If you have any questions, feel free to reach out to our support team.\n\n"
                + "We wish you the best of luck on your learning journey with us!\n\n"
                + "Warm Regards,\n"
                + "Talent Acquisition Team\n"
                + "CodeChamp\n"
                + "support@codechamp.com");

        // Send the email
        javaMailSender.send(simpleMailMessage);
    }

}
