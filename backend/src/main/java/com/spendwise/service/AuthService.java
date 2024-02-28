package com.spendwise.service;

import org.springframework.http.ResponseEntity;
import com.spendwise.dto.AuthDTO;

import jakarta.servlet.http.HttpServletRequest;

public interface AuthService {
    ResponseEntity<?> login(AuthDTO authDto);
    ResponseEntity<?> logout(HttpServletRequest request);
    
}
