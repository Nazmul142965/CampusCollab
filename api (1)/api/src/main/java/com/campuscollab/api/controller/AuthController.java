package com.campuscollab.api.controller;

import com.campuscollab.api.dto.LoginRequest;
import com.campuscollab.api.dto.RegisterRequest;
import com.campuscollab.api.dto.UserResponse;
import com.campuscollab.api.model.User;
import com.campuscollab.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // এটি ফ্রন্টএন্ড থেকে রিকোয়েস্ট গ্রহণ করার অনুমতি দেয়
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        // চেক করা হচ্ছে যে এই ইমেইল দিয়ে আগেই কোনো অ্যাকাউন্ট খোলা হয়েছে কিনা
        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email is already taken!");
        }

        // একটি নতুন User অবজেক্ট তৈরি করা হচ্ছে
        User user = new User();
        user.setFullName(registerRequest.getFullName());
        user.setStudentId(registerRequest.getStudentId());
        user.setEmail(registerRequest.getEmail());

        // গুরুত্বপূর্ণ: এখানে পাসওয়ার্ড সরাসরি সেভ করা হচ্ছে, যা নিরাপদ নয়।
        // প্রোডাকশন অ্যাপে সবসময় পাসওয়ার্ড হ্যাশ (Hash) করে সেভ করতে হয়।
        user.setPassword(registerRequest.getPassword());

        // ইউজারকে ডাটাবেসে সেভ করা হচ্ছে
        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        // ইমেইল দিয়ে ইউজারকে খোঁজা হচ্ছে
        Optional<User> userOptional = userRepository.findByEmail(loginRequest.getEmail());

        // যদি ইউজারকে খুঁজে না পাওয়া যায় অথবা পাসওয়ার্ড না মেলে
        if (userOptional.isEmpty() || !userOptional.get().getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
        }

        // যদি লগইন সফল হয়
        User user = userOptional.get();

        // ইউজারের নাম ও আইডি দিয়ে একটি UserResponse অবজেক্ট তৈরি করে ফ্রন্টএন্ডে পাঠানো হচ্ছে
        return ResponseEntity.ok(new UserResponse(user.getFullName(), user.getStudentId()));
    }
}
