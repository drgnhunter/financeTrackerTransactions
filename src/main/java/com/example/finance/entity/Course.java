// package com.example.finance.entity;


// import jakarta.persistence.*;

// @Entity
// @Table(name = "course")
// public class Course {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "id")
//     private int id;

//     @Column(name = "title")
//     private String title;

//     @ManyToOne(cascade = CascadeType.ALL)
//     @JoinColumn(name = "instructor_id")
//     private UserTransaction instructor;

//     public Course() {

//     }

//     public Course(String title) {
//         this.title = title;
//     }

//     public int getId() {
//          return id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     public String getTitle() {
//         return title;
//     }

//     public void setTitle(String title) {
//         this.title = title;
//     }

//     public UserTransaction getInstructor() {
//         return instructor;
//     }

//     public void setInstructor(UserTransaction instructor) {
//         this.instructor = instructor;
//     }

//     @Override
//     public String toString() {
//         return "Course [id=" + id + ", title=" + title + "]";
//     }
// }