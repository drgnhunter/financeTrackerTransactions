// package com.example.finance.entity;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "category")
// public class Category {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "id")
//     private int id;

//     @Column(name = "name")
//     private String name;

//     @Column(name = "transaction_type")
//     private String transaction_type;

//     @ManyToOne(cascade = CascadeType.ALL)
//     @JoinColumn(name = "transaction_id")
//     private UserTransaction transaction;


//     // @Column(name = "transaction_type")
//     // private int transactionType;

//     // @Column(name = "email")
//     // private String email;

//     public Category() {

//     }

//     public Category(String name, String transaction_type) {
//         this.name = name;
//         this.transaction_type = transaction_type;
//         // this.email = email;
//     }

//     public int getId() {
//         return id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public UserTransaction getTransaction() {
//         return transaction;
//     }

//     public void setTransaction(UserTransaction transaction) {
//         this.transaction = transaction;
//     }

//     // public String getEmail() {
//     // return email;
//     // }

//     // public void setEmail(String email) {
//     // this.email = email;
//     // }

//     @Override
//     public String toString() {
//         return "Student [id=" + id + ", name=" + name + ", transaction_type=" + transaction_type + "]";
//     }
// }

package com.example.finance.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "transaction_type")
    private String transaction_type;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<UserTransaction> transactions;

    public Category() {
    }

    public Category(String name, String transaction_type) {
        this.name = name;
        this.transaction_type = transaction_type;
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

    public List<UserTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<UserTransaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", transaction_type=" + transaction_type + "]";
    }
}
