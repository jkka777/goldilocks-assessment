package com.app.controller;

import com.app.model.User;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/signIn")
    public ResponseEntity<User> getLoggedInCustomerDetailsHandler(Authentication auth) {
//        System.out.println(auth);
        if (auth != null && auth.isAuthenticated()) {
            User user = userRepo.findByUserEmail(auth.getName()).orElseThrow(() -> new BadCredentialsException("Invalid Credentials"));
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout() {
        return new ResponseEntity<>("Logout success!", HttpStatus.OK);
    }
}
