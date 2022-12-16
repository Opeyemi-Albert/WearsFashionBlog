package com.example.wearsfashionblog.dtos.commentdtos;

import com.example.wearsfashionblog.models.Post;
import com.example.wearsfashionblog.models.User;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class CreateCommentDto {
    private String comment;
    private Timestamp createdAt;
    private User user;
    private Post post;
}
