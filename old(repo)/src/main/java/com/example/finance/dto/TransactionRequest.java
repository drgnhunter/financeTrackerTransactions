package com.example.finance.dto;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionRequest {

    private BigDecimal amount;          // Amount for the transaction
    private LocalDate date;            // Date of the transaction
    private String description;        // Optional description of the transaction
    private int categoryId;            // ID of the category (foreign key reference to Category)
    private int accountId;             // ID of the account (foreign key reference to Account)
    private String transactionType;    // Type of transaction (e.g., "INCOME", "EXPENSE", "TRANSFER")

    // Getters and Setters
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "TransactionRequest [amount=" + amount + ", date=" + date + ", description=" + description +
                ", categoryId=" + categoryId + ", accountId=" + accountId + ", transactionType=" + transactionType + "]";
    }
}
