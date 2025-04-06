package com.example.finance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.finance.Category;
import com.example.finance.HibernateUtil;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Repository;


public class CategoryDao {
    @Transactional
    public void saveCategory(Category student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            System.out.println("Session has started");
            // save the student object
            session.persist(student);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Category getUser(String username, String password)  {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Update the query to filter by username and password and fetch a single result
            return session.createQuery("FROM User WHERE username = :username AND password = :password", Category.class)
                          .setParameter("username", username)
                          .setParameter("password", password)
                          .uniqueResult();  // Fetches a single user or null if no match is found
        }
    }
}