package com.spendwise.repository;

import com.spendwise.entity.Expense;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
   // Method to find all expenses regardless of user ID
    List<Expense> findAll();
  // Method to find all expenses by user ID
    List<Expense> findAllByUserId(Long user_id);
    
   
}
