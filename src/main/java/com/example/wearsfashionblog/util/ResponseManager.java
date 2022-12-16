package com.example.wearsfashionblog.util;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ResponseManager<T> {
    public ApiResponse<T> success(T data) {
        return new ApiResponse<T>((T) "Request Successful", true, data);
    }
}
