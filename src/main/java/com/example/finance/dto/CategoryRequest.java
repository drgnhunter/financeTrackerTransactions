package com.example.finance.dto;

public class CategoryRequest {
    
    private String name;           // Name of the category (e.g., "Groceries")
    private int transactionType;   // Transaction type (1 = Income, 2 = Transfer, 3 = Salary)

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }
}
