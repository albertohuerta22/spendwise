package com.spendwise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spendwise.entity.Auth;

public interface AuthRepository extends JpaRepository<Auth, Long> {

    Auth findByEmail(String email);
}
