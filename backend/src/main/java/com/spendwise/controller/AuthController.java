package com.spendwise.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spendwise.dto.AuthDTO;
import com.spendwise.exception.UserNotFoundException;
import com.spendwise.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

   @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDTO authDto) {
    try {
        // Delegate authentication logic to the service layer
        return authService.login(authDto);
    } catch (UserNotFoundException ex) {
        // Handle the exception and return an appropriate error response
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
}



    // Other authentication endpoints (e.g., registration, logout) can be defined here
}
