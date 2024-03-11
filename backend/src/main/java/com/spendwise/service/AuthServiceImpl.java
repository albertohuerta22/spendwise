package com.spendwise.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.spendwise.dto.AuthDTO;
import com.spendwise.entity.Auth;
import com.spendwise.repository.AuthRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;

import java.security.Key;
import io.jsonwebtoken.security.Keys;


@Service
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final Key secretKey;

    public AuthServiceImpl(AuthRepository authRepository, PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
        this.secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }

    @Override
    public ResponseEntity<?> login(AuthDTO authDto) {
        String email = authDto.getEmail();
        String password = authDto.getPassword();

        Auth auth = authRepository.findByEmail(email);

        // Check if the email exists in the database
        if (auth == null) {
            return ResponseEntity.badRequest().body("email does not exist");
        }
        
        // Check if the password matches
        if (passwordEncoder.matches(password, auth.getPassword())) {
            // Generate JWT token
            String token = Jwts.builder()
                    .setSubject(email)
                    .signWith(secretKey, SignatureAlgorithm.HS512)
                    .compact();
            // Return token in response
            return ResponseEntity.ok().body(token);
        } else {
            return ResponseEntity.badRequest().body("Incorrect password");
        }
    }

    @Override
    public ResponseEntity<?> logout(HttpServletRequest request) {
        // Logging out usually involves deleting the token from the client-side.
        // For example, you can clear the token from local storage in the client's browser.
        return ResponseEntity.ok("Logout successful");
    }
}
