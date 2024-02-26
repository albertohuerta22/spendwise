package com.spendwise.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "expenses")
public class Expense {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expense_id;

    @Column(nullable = false)
    private BigDecimal amount;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "payment_method_id", nullable = false)
    private PaymentMethod paymentMethod;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public Expense() {
    }

    public Expense(Long expense_id, BigDecimal amount, Date date, Category category, String description, User user, PaymentMethod paymentMethod) {
        this.expense_id = expense_id;
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.user = user;
        this.category = category;
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return expense_id;
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

    public User getUser() {
        return user;
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

    public Category getCategory(){
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PaymentMethod getPaymentMethod(){
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
    }
}
