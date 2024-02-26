package com.spendwise.dto;

public class PaymentMethodDTO {
    private Long payment_method_id;
    private String name;
    private String description;

    public PaymentMethodDTO(){}
    public PaymentMethodDTO(Long payment_method_id, String name, String description){
      this.payment_method_id = payment_method_id;
      this.name = name;
      this.description = description;
    }

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
