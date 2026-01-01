package com.campuscollab.api.repository;

import com.campuscollab.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // এটি Spring-কে বলে যে এটি একটি ডাটাবেস রিপোজিটরি।
public interface UserRepository extends JpaRepository<User, Long> {

    // Spring Data JPA এই মেথডের নাম দেখেই নিজে থেকে এর কোড তৈরি করে নেবে,
    // যা ইমেইল দিয়ে ডাটাবেস থেকে ইউজার খুঁজে বের করবে।
    Optional<User> findByEmail(String email);
}