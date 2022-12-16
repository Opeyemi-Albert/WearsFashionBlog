package com.example.wearsfashionblog.services.serviceImpl;

import com.example.wearsfashionblog.dtos.userdtos.UserResponseDto;
import com.example.wearsfashionblog.dtos.userdtos.UserSignupDto;
import com.example.wearsfashionblog.enums.Role;
import com.example.wearsfashionblog.exceptions.AlreadyExistsException;
import com.example.wearsfashionblog.exceptions.NotFoundException;
import com.example.wearsfashionblog.util.ApiResponse;
import com.example.wearsfashionblog.models.User;
import com.example.wearsfashionblog.repositories.UserRepository;
import com.example.wearsfashionblog.services.UserService;
import com.example.wearsfashionblog.util.ResponseManager;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ResponseManager responseManager;
    private final HttpSession httpSession;

    @Override
    public boolean isEmailExist(String email) {
        boolean status;
        status = userRepository.existsByEmail(email);
        return status;
    }

    @Override
    public ApiResponse<UserResponseDto> signup(UserSignupDto userSignupDto) throws AlreadyExistsException {
        ApiResponse apiResponse;

        boolean emailExistStatus = isEmailExist(userSignupDto.getEmail());

        if(emailExistStatus == true){
            throw new AlreadyExistsException("Email already exists");
        }

        User user = new User();
        BeanUtils.copyProperties(userSignupDto, user);
        user.setRole(Role.BLOGGER);
        userRepository.save(user);

        UserResponseDto userResponseDto = new UserResponseDto();
        BeanUtils.copyProperties(user, userResponseDto);
        apiResponse = responseManager.success(userResponseDto);

        return apiResponse;
    }

    @Override
    public ApiResponse<UserResponseDto> login(String email, String password) throws NotFoundException {
        boolean isBloggerExistStatus = userRepository.existsByEmailAndPassword(email, password);

        if(isBloggerExistStatus == false)
            throw new NotFoundException("Invalid credentials");

        User user = userRepository.findByEmailAndPassword(email,password);
        UserResponseDto userResponseDto = new UserResponseDto();
        BeanUtils.copyProperties(user, userResponseDto);
        httpSession.setAttribute("userId",user.getId());
        ApiResponse<UserResponseDto> apiResponse = responseManager.success(userResponseDto);

        return apiResponse;
    }
}
