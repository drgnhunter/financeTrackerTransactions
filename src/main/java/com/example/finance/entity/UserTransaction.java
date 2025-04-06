// package com.example.finance.entity;


// import java.math.BigDecimal;
// import java.time.LocalDate;
// import java.util.List;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "transactions")
// public class UserTransaction {
    

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "id")
//     private int id;

//     // @Column(name = "first_name")
//     // private String firstName;

//     // @OneToMany(mappedBy = "instructor", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
//     //   CascadeType.REFRESH })
//     // private List<Course> courses;


//     @Column(name = "amount")
//     private BigDecimal amount;          // Amount for the transaction
//     @Column(name = "date")
//     private LocalDate date;            // Date of the transaction
//     @Column(name = "description")
//     private String description;        // Optional description of the transaction
    
//     @OneToMany(mappedBy = "transaction", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
//       CascadeType.REFRESH })
//     private List<Category> catgeories;            // ID of the category (foreign key reference to Category)
    
    
//     // @Column(name = "id")
//     // private int accountId;             // ID of the account (foreign key reference to Account)
    
    
//     public UserTransaction() {

//     }

//     public UserTransaction(BigDecimal amount, LocalDate date, String description) {
//         // this.firstName = firstName;
//         // this.lastName = lastName;
//         // this.email = email;
//         this.amount = amount;
//         this.date = date;
//         this.description = description;

//     }

//     public int getId() {
//          return id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//        // Getters and Setters
//     public BigDecimal getAmount() {
//         return amount;
//     }

//     public void setAmount(BigDecimal amount) {
//         this.amount = amount;
//     }

//     public LocalDate getDate() {
//         return date;
//     }

//     public void setDate(LocalDate date) {
//         this.date = date;
//     }

//     public String getDescription() {
//         return description;
//     }

//     public void setDescription(String description) {
//         this.description = description;
//     }

//     public List<Category> getCategory() {
//         return catgeories;
//     }

//     public void setCategory(List<Category> categories) {
//         this.catgeories = categories;
//     }


 
//     @Override
//     public String toString() {
//         return "TransactionRequest [amount=" + amount + ", date=" + date + ", description=" + description +
//                 ", categories=" + catgeories + "]";
//     }


//     // public List<Course> getCourses() {
//     //     return courses;
//     // }

//     // public void setCourses(List<Course> courses) {
//     //     this.courses = courses;
//     // }
// }

package com.example.finance.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class UserTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")  // Changed from "transaction_id" to "category_id"
    private Category category;

    public UserTransaction() {
    }

    public UserTransaction(BigDecimal amount, LocalDate date, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "UserTransaction [amount=" + amount + ", date=" + date + ", description=" + description + ", category=" + category + "]";
    }
}
