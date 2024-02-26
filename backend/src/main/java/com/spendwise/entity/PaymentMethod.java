package com.spendwise.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payment_methods")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payment_method_id;
    private String name;
    private String description;

    public PaymentMethod(){}

    public Long getPaymentMethodId(){
      return payment_method_id;
    }

    public void setPaymentMethodId(Long payment_method_id){
      this.payment_method_id = payment_method_id;
    }

    public String getName(){
      return name;
    }

    public void setName(String name){
      this.name = name;
    }

    public String getDescription(){
      return description;
    }

    public void setDescription(String description){
      this.description = description;
    }
}
