package com.example.wearsfashionblog.dtos.likedtos;

import com.example.wearsfashionblog.models.Post;
import com.example.wearsfashionblog.models.User;
import lombok.Data;

@Data
public class LikeAPostDto {
    private Long noOfLikes = 0L;
    private User user;
    private Post post;
}
