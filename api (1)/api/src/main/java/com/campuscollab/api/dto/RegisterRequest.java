package com.campuscollab.api.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String fullName;
    private String studentId;
    private String email;
    private String password;
}