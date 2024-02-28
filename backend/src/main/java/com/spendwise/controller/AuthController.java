package com.spendwise.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spendwise.dto.AuthDTO;
import com.spendwise.service.AuthService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

   @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDTO authDto) {
        // Delegate authentication logic to the service layer
        return authService.login(authDto);
    }

     @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        // Delegate logout logic to the service layer
        return authService.logout(request);
    }

    // Other authentication endpoints (e.g., registration, logout) can be defined here
}
