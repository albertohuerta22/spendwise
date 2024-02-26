package com.spendwise.service;

import com.spendwise.dto.ExpenseDTO;
import com.spendwise.entity.Category;
import com.spendwise.entity.Expense;
import com.spendwise.entity.PaymentMethod;
import com.spendwise.repository.CategoryRepository;
import com.spendwise.repository.ExpenseRepository;
import com.spendwise.repository.PaymentMethodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    // Method to retrieve all expenses
    public List<ExpenseDTO> findAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Method to retrieve expenses for a specific user
    public List<ExpenseDTO> findAllExpensesForUser(Long user_id) {
        List<Expense> expenses = expenseRepository.findAllByUserId(user_id); // Assuming you have this method in ExpenseRepository
        return expenses.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private ExpenseDTO convertToDTO(Expense expense) {
        ExpenseDTO dto = new ExpenseDTO();
        dto.setExpenseId(expense.getId());
        dto.setAmount(expense.getAmount());
        dto.setDate(expense.getDate());
        dto.setCategoryId(expense.getCategory().getCategoryId());
        dto.setCategoryName(expense.getCategory().getName());
        dto.setPaymentMethodId(expense.getPaymentMethod().getPaymentMethodId());
        dto.setPaymentMethodName(expense.getPaymentMethod().getName());
        dto.setDescription(expense.getDescription());
       
        return dto;
    }

    public ExpenseDTO createOrUpdateExpense(ExpenseDTO expenseDTO) {
    Expense expense = new Expense();
    // Set simple fields
    expense.setAmount(expenseDTO.getAmount());
    expense.setDate(expenseDTO.getDate());
    expense.setDescription(expenseDTO.getDescription());
    
    // Fetch and set the Category and PaymentMethod
    Category category = categoryRepository.findById(expenseDTO.getCategoryId()).orElseThrow(/* entity not found exception */);
    expense.setCategory(category);

    PaymentMethod paymentMethod = paymentMethodRepository.findById(expenseDTO.getPaymentMethodId()).orElseThrow(/* entity not found exception */);
    expense.setPaymentMethod(paymentMethod);

    // Save the Expense entity
    Expense savedExpense = expenseRepository.save(expense);

    // Convert and return the saved Expense as DTO
    return convertToDTO(savedExpense);
}

}
