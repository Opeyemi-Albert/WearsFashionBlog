package com.example.wearsfashionblog.controllers;

import com.example.wearsfashionblog.dtos.userdtos.UserResponseDto;
import com.example.wearsfashionblog.dtos.userdtos.UserSignupDto;
import com.example.wearsfashionblog.exceptions.AlreadyExistsException;
import com.example.wearsfashionblog.exceptions.NotFoundException;
import com.example.wearsfashionblog.util.ApiResponse;
import com.example.wearsfashionblog.models.User;
import com.example.wearsfashionblog.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fashion-blog")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<UserResponseDto>> signup(@RequestBody UserSignupDto userSignupDto) throws AlreadyExistsException {
        ApiResponse<UserResponseDto> user = userService.signup(userSignupDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<UserResponseDto>> login(@RequestBody User user) throws NotFoundException {
        ApiResponse<UserResponseDto> userResponse = userService.login(user.getEmail(), user.getPassword());
        return new ResponseEntity<>(userResponse, HttpStatus.ACCEPTED);
    }
}
