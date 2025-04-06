package com.example.finance.controller;

import com.example.finance.dto.CategoryRequest;
import com.example.finance.dto.TransactionRequest;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.finance.Transactions;

import com.example.finance.TransactionDao;
import com.example.finance.CategoryDao;
import jakarta.servlet.http.HttpServletResponse;

import com.example.finance.JwtTokenUtil;
import com.example.finance.Category;

import jakarta.servlet.http.Cookie; // Correct import for Jakarta Cookie
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest; // For Spring Boot 2.4+ and Jakarta EE

import com.example.finance.User;
import com.example.finance.UserDao;

@RestController
public class MainController {

    // @Autowired
    // private CategoryDao categoryDao;  // Injecting CategoryDao

    // @Autowired
    // private TransactionDao transactionDao;  // Injecting TransactionDao

    // Endpoint for the home page
    @GetMapping("/")
    public String home() {
        return "Welcome to the Spring Boot Application!";
    }

    // Example of another endpoint
    @GetMapping("/greeting")
    public String getGreeting() {
        return "Hello, World!";
    }

    // // Endpoint to create a transaction
    // @RequestMapping(value = "/createTransaction", method = RequestMethod.POST)
    // public ResponseEntity<String> createTransaction(@RequestBody TransactionRequest transactionRequest, HttpServletResponse response) {
    //     try {
    //         BigDecimal amount = transactionRequest.getAmount();
    //         LocalDate date = transactionRequest.getDate();
    //         String description = transactionRequest.getDescription();
    //         int categoryId = transactionRequest.getCategoryId();  // Get categoryId from request
    //         int accountId = transactionRequest.getAccountId();
    //         // String transactionType = transactionRequest.getTransactionType();  // Uncomment if needed

    //         // Fetch category by ID
    //         Category category = categoryDao.getCategoryById(categoryId);
    //         if (category == null) {
    //             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid category ID");
    //         }

    //         // Create a new Transactions entity
    //         Transactions transaction = new Transactions();
    //         transaction.setAmount(amount);
    //         transaction.setDate(date);
    //         transaction.setDescription(description);
    //         transaction.setAccountId(accountId);
    //         transaction.setCategory(category);

    //         // Save the transaction using the DAO or service
    //         transactionDao.saveTransaction(transaction); // Save the transaction using the DAO

    //         // Returning a success response with status code 201 (Created)
    //         return ResponseEntity.status(HttpStatus.CREATED).body("Transaction created successfully");
    //     } catch (Exception e) {
    //         // Log the exception (you can use a logger here)
    //         e.printStackTrace();
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the transaction");
    //     }
    // }

    // Endpoint to create a category
    @RequestMapping(value = "/createCategory", method = RequestMethod.POST)
    public ResponseEntity<String> createCategory(@RequestBody CategoryRequest categoryRequest, HttpServletResponse response) {
        try {
            // Extract the category details from the request
            String name = categoryRequest.getName(); // Category name (e.g., "Groceries", "Salary")
            int transactionTypeInt = categoryRequest.getTransactionType();  // 1 for Income, 2 for Transfer, 3 for Salary
            System.out.println("INT=> "+transactionTypeInt);
            
            Category category = new Category(name,transactionTypeInt);
            CategoryDao categoryDao = new CategoryDao();
            // Save the category using the DAO or service
            categoryDao.saveCategory(category); // Save the category using the DAO

            // Returning a success response with status code 201 (Created)
            return ResponseEntity.status(HttpStatus.CREATED).body("Category created successfully");
        } catch (Exception e) {
            // Log the exception (you can use a logger here)
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the category");
        }
    }


    @GetMapping("/createUser")
    public String createUserNew() {
        UserDao userDao = new UserDao();
        User user = new User("john_doe", "password123@");
        userDao.saveUser(user);
        return "success";
    }
    // @RequestMapping(value = "/createTransaction", method = RequestMethod.POST)
    // public ResponseEntity<String>  createTransaction(@RequestBody TransactionRequest transactionRequest, HttpServletResponse response) {
    //     try {
    //         BigDecimal amount = transactionRequest.getAmount();
    //         LocalDate date = transactionRequest.getDate();
    //         String description = transactionRequest.getDescription();
    //         int categoryId = transactionRequest.getCategoryId();  // Get categoryId from request
    //         int accountId = transactionRequest.getAccountId();
    //         // String transactionType = transactionRequest.getTransactionType();


    //         // Fetch category by ID
    //         Category category = categoryDao.getCategoryById(categoryId);
    //         if (category == null) {
    //             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid category ID");
    //         }




    //         // Create a new Transactions entity
    //         Transactions transaction = new Transactions();
    //         transaction.setAmount(amount);
    //         transaction.setDate(date);
    //         transaction.setDescription(description);
    //         transaction.setAccountId(accountId);
    //         transaction.setCategory(category);
            


    //         TransactionDao transactionDao = new TransactionDao();
    //          // Save the transaction using the DAO or service
    //          transactionDao.saveTransaction(transaction); // Assuming this method saves the transaction

    //          // Returning a success response with status code 200 (OK)
    //          return ResponseEntity.ok().body("Transaction created successfully");
    //     } catch (Exception e) {
    //         // Log the exception (you can use a logger here)
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
    //     }
    
    // }


    // @RequestMapping(value = "/createCategory", method = RequestMethod.POST)
    // public ResponseEntity<String> createCategory(@RequestBody CategoryRequest categoryRequest, HttpServletResponse response) {
    //     try {
            
    //         // Extract the category details from the request
    //         String name = categoryRequest.getName(); // Category name (e.g., "Groceries", "Salary")
    //         int transactionType = categoryRequest.getTransactionType(); // 1 for Income, 2 for Transfer, 3 for Salary, etc.

    //         // Create a new Category entity
    //         Category category = new Category();
    //         category.setName(name);
    //         category.setTransactionType(transactionType);

    //         // Save the category using the DAO or service
    //         CategoryDao categoryDao = new CategoryDao();
    //         categoryDao.saveCategory(category); // Assuming this method saves the category

    //         // Returning a success response with status code 200 (OK)
    //         return ResponseEntity.ok().body("Category created successfully");
    //     } catch (Exception e) {
    //         // Log the exception (you can use a logger here)
    //         e.printStackTrace();
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the category");
    //     }
    // }

    // You can add more endpoints here
}
