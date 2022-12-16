package com.example.wearsfashionblog.services;

import com.example.wearsfashionblog.dtos.userdtos.UserResponseDto;
import com.example.wearsfashionblog.dtos.userdtos.UserSignupDto;
import com.example.wearsfashionblog.exceptions.AlreadyExistsException;
import com.example.wearsfashionblog.exceptions.NotFoundException;
import com.example.wearsfashionblog.util.ApiResponse;

public interface UserService {
    boolean isEmailExist(String email);
    ApiResponse<UserResponseDto> signup(UserSignupDto userSignupDto) throws AlreadyExistsException;
    ApiResponse<UserResponseDto> login(String email, String password) throws NotFoundException;
}
