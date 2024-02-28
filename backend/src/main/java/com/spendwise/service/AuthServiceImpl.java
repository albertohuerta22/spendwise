package com.spendwise.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.spendwise.dto.AuthDTO;
import com.spendwise.entity.Auth;
import com.spendwise.repository.AuthRepository;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthServiceImpl(AuthRepository authRepository, BCryptPasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
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
    //client side to db compare
    if (passwordEncoder.matches(password, auth.getPassword())) {
        return ResponseEntity.ok("Login successful");
    } else {
        return ResponseEntity.badRequest().body("Incorrect password");
    }
  }

}
