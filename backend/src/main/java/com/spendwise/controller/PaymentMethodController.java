package com.spendwise.controller;

import com.spendwise.dto.PaymentMethodDTO;
import com.spendwise.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment-methods")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping
    public List<PaymentMethodDTO> getAllPaymentMethods() {
        return paymentMethodService.findAllPaymentMethods();
    }

    @GetMapping("/user/{userId}")
    public List<PaymentMethodDTO> getPaymentMethodsByUser(@PathVariable Long userId) {
        return paymentMethodService.findPaymentMethodsByUser(userId);
    }

    // Additional endpoints
}
