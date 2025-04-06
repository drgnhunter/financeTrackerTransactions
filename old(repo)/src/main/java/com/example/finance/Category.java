package com.example.finance;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "transaction_type")
    private int transactionType;



    public Category(String name, int transactionType) {
        this.name = name;
        this.transactionType = transactionType;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTransactionType() {
        return this.transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

  
    @Override
    public String toString() {
        return "Student [id=" + id + ", username=" + name + ", password=" + transactionType + "]";
    }
    
}