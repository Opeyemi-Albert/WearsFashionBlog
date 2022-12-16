package com.example.wearsfashionblog.dtos.postdtos;

import com.example.wearsfashionblog.enums.Category;
import com.example.wearsfashionblog.enums.Gender;
import lombok.Data;

@Data
public class CreatePostDto {
    private String postTitle;
    private String postDescription;
    private Category category;
    private Gender gender;
}
