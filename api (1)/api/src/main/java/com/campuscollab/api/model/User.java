package com.campuscollab.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok-এর এই অ্যানোটেশনটি getter, setter ইত্যাদি মেথড স্বয়ংক্রিয়ভাবে তৈরি করে দেয়।
@Entity // এটি JPA-কে বলে যে এই ক্লাসটি একটি ডাটাবেস টেবিল।
@Table(name = "users") // ডাটাবেসে টেবিলটির নাম হবে "users"।
@NoArgsConstructor // JPA-এর জন্য একটি খালি কনস্ট্রাক্টর তৈরি করে।
public class User {

    @Id // এটি 'id' ফিল্ডকে টেবিলের প্রাইমারি কী (Primary Key) হিসেবে চিহ্নিত করে।
    @GeneratedValue(strategy = GenerationType.IDENTITY) // এটি 'id'-এর ভ্যালু স্বয়ংক্রিয়ভাবে তৈরি করবে।
    private Long id;

    private String fullName;

    @Column(unique = true, nullable = false) // এই কলামের ভ্যালু ইউনিক এবং আবশ্যক।
    private String studentId;

    @Column(unique = true, nullable = false) // এই কলামের ভ্যালু ইউনিক এবং আবশ্যক।
    private String email;

    @Column(nullable = false) // এই কলামের ভ্যালু আবশ্যক।
    private String password;
}
