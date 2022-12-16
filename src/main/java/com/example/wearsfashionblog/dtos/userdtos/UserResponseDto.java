package com.example.wearsfashionblog.dtos.userdtos;

import com.example.wearsfashionblog.enums.Role;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserResponseDto {
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private String gender;
    private Timestamp createdAt;
}
