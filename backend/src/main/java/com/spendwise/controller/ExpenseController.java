package com.spendwise.controller;

import com.spendwise.dto.ExpenseDTO;
import com.spendwise.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public List<ExpenseDTO> getAllExpenses() {
        return expenseService.findAllExpenses();
    }

    // Endpoint to get all expenses for a specific user
    @GetMapping("/user/{user_id}")
    public List<ExpenseDTO> getAllExpensesForUser(@PathVariable Long user_id) {
        return expenseService.findAllExpensesForUser(user_id);
    }
    
    
}
