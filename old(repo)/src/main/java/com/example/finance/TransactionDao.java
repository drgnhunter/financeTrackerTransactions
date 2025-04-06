package com.example.finance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.example.finance.Transactions;
import com.example.finance.HibernateUtil;

@Repository
public class TransactionDao {
    // Method to save a transaction
    public void saveTransaction(Transactions transaction) {
        // Start a new session and transaction
        org.hibernate.Transaction hibernateTransaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Begin a transaction
            hibernateTransaction = session.beginTransaction();
            System.out.println("Session has started");

            // Save the transaction object directly since category and account are already
            // set
            session.persist(transaction);

            // Commit the transaction
            hibernateTransaction.commit();
            System.out.println("Transaction saved successfully");

        } catch (Exception e) {
            if (hibernateTransaction != null) {
                hibernateTransaction.rollback(); // Rollback if any exception occurs
            }
            e.printStackTrace();
        }
    }

    // public Transactions getUser(String account_id) {
    //     try (Session session = HibernateUtil.getSessionFactory().openSession()) {
    //         // Update the query to filter by username and password and fetch a single result
    //         return session
    //                 .createQuery("FROM User WHERE id = :account_id", Transactions.class)
    //                 .setParameter("account_id", account_id)
    //                 .uniqueResult(); // Fetches a single user or null if no match is found
    //     }
    // }
}