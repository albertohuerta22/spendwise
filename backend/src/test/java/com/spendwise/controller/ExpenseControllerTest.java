package com.spendwise.controller;

import com.spendwise.dto.ExpenseDTO;
import com.spendwise.service.ExpenseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExpenseController.class)
@ExtendWith(MockitoExtension.class)
public class ExpenseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExpenseService expenseService;

    @InjectMocks
    private ExpenseController expenseController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(expenseController).build();
    }

    @Test
    void getAllExpensesForUser_ShouldReturnExpenses() throws Exception {
    // Assuming you have constructor in ExpenseDTO adjusted for new fields
   ExpenseDTO expense1 = new ExpenseDTO(1L, new BigDecimal("100.00"), new Date(), "Weekly grocery shopping", 1L, "Groceries", 1L, "Credit Card");
    ExpenseDTO expense2 = new ExpenseDTO(2L, new BigDecimal("50.00"), new Date(), "Monthly subway pass", 2L, "Transport", 2L, "Debit Card");
    List<ExpenseDTO> expenses = Arrays.asList(expense1, expense2);

    when(expenseService.findAllExpensesForUser(anyLong())).thenReturn(expenses);

    mockMvc.perform(get("/expenses/user/{user_id}", 1L)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    verify(expenseService, times(1)).findAllExpensesForUser(anyLong());
    verifyNoMoreInteractions(expenseService);
}

}
