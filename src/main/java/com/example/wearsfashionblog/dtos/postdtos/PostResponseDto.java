package com.example.wearsfashionblog.dtos.postdtos;

import com.example.wearsfashionblog.enums.Category;
import com.example.wearsfashionblog.enums.Gender;

import java.sql.Timestamp;

public class PostResponseDto {
    private String id;
    private String postTitle;
    private String postDescription;
    private Category category;
    private Gender gender;
    private Timestamp createdAt;
}
