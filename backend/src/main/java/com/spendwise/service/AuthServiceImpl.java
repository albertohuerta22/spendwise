package com.spendwise.service;

import com.spendwise.dto.AuthDTO;
import com.spendwise.dto.AuthResponseDTO;
import com.spendwise.entity.Auth;
import com.spendwise.repository.AuthRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Date;
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
        Auth auth = authRepository.findByEmail(authDto.getEmail());
        if (auth == null) {
            return ResponseEntity.badRequest().body(new AuthResponseDTO("Error: Email does not exist.", null));
        }
        if (!passwordEncoder.matches(authDto.getPassword(), auth.getPassword())) {
            return ResponseEntity.badRequest().body(new AuthResponseDTO("Error: Incorrect password.", null));
        }

        long expirationTime = 1000 * 60 * 60; // 1 hour
        String token = Jwts.builder()
                .setSubject(authDto.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(secretKey, SignatureAlgorithm.HS512)
                .compact();

        return ResponseEntity.ok(new AuthResponseDTO("Login successful.", token));
    }

    @Override
    public ResponseEntity<?> logout(HttpServletRequest request) {
        // Since JWT is stateless, logout is handled client-side by deleting the token.
        return ResponseEntity.ok("Logout successful.");
    }
}
