package com.campuscollab.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor // এটি Lombok-কে সব ফিল্ড নিয়ে একটি কনস্ট্রাক্টর তৈরির নির্দেশ দেয়।
public class UserResponse {
    private String name;
    private String id;
}