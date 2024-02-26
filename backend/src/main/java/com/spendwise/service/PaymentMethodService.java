package com.spendwise.service;

import com.spendwise.dto.PaymentMethodDTO;
import com.spendwise.entity.PaymentMethod;
import com.spendwise.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    public List<PaymentMethodDTO> findAllPaymentMethods() {
        List<PaymentMethod> paymentMethods = paymentMethodRepository.findAll();
        return paymentMethods.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<PaymentMethodDTO> findPaymentMethodsByUser(Long userId) {
        // This should be implemented to filter payment methods by userId
        // You will need to add a custom method to your repository to fetch payment methods by userId
        return null;
    }

    private PaymentMethodDTO convertToDTO(PaymentMethod paymentMethod) {
        PaymentMethodDTO dto = new PaymentMethodDTO();
        dto.setPaymentMethodId(paymentMethod.getPaymentMethodId());
        dto.setName(paymentMethod.getName());
        dto.setDescription(paymentMethod.getDescription());
        return dto;
    }
}
