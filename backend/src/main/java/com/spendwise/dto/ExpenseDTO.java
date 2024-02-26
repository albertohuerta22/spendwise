package com.spendwise.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ExpenseDTO {
    private Long expense_id;
    private BigDecimal amount;
    private Date date;
    private Long category_id;
    private String categoryName;
    private Long paymentMethod_id;
    private String paymentMethodName;
    private String description;

    public ExpenseDTO() {
    }

    public ExpenseDTO(Long expense_id, BigDecimal amount, Date date, String description, Long category_id, String categoryName, Long paymentMethod_id, String paymentMethodName) {
        this.expense_id = expense_id;
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.category_id = category_id;
        this.categoryName = categoryName;
        this.paymentMethod_id = paymentMethod_id;
    }

    public Long getExpenseId() {
        return expense_id;
    }

    public void setExpenseId(Long expense_id){
        this.expense_id = expense_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long expense_id) {
        this.expense_id = expense_id;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId(){
        return category_id;
    }

    public void setCategoryId(Long category_id){
        this.category_id = category_id;
    }

    public String getCategoryName(){
        return categoryName;
    }

    public void setCategoryName(String categoryName){
        this.categoryName = categoryName;
    }

    public Long getPaymentMethodId(){
        return paymentMethod_id;
    }

    public void setPaymentMethodId(Long paymentMethod_id){
        this.paymentMethod_id = paymentMethod_id;
    }

    public String getPaymentMethodName(){
        return paymentMethodName;
    }

    public void setPaymentMethodName(String paymentMethodName){
        this.paymentMethodName = paymentMethodName;
    }
}
