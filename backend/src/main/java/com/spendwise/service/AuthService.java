package com.spendwise.service;

import org.springframework.http.ResponseEntity;
import com.spendwise.dto.AuthDTO;

public interface AuthService {
    // auth methods
    ResponseEntity<?> login(AuthDTO authDto);
}
