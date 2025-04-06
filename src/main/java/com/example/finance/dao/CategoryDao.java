package com.example.finance.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

// import com.example.finance.entity.Course;
import com.example.finance.entity.UserTransaction;
import com.example.finance.HibernateUtil;
import java.util.List;
import com.example.finance.entity.Category;

import org.hibernate.query.Query;

public class CategoryDao {
    public void saveCategory(Category category) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(category);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateCategory(Category course) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(course);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteCategory(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a course object
            UserTransaction course = session.get(UserTransaction.class, id);
            if (course != null) {
                session.delete(course);
                System.out.println("course is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    // public Course getCourse(String title) {

    // Transaction transaction = null;
    // Course course = null;
    // try (Session session = HibernateUtil.getSessionFactory().openSession()) {
    // // Start a transaction
    // transaction = session.beginTransaction();

    // // Create HQL query to fetch course by title
    // String hql = "FROM Course WHERE title = :title";
    // course = session.createQuery(hql, Course.class)
    // .setParameter("title", title) // Set the title parameter
    // .uniqueResult(); // Fetch a single result

    // // Commit the transaction
    // transaction.commit();
    // } catch (Exception e) {
    // if (transaction != null) {
    // transaction.rollback();
    // }
    // e.printStackTrace();
    // }
    // return course;
    // }

    public List<Category> getCatgory(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
           

            Query<Category> query = session.createQuery("from Category WHERE name=:name", Category.class)
                                .setParameter("name", name);
            return query.list();
        }
    }
}
