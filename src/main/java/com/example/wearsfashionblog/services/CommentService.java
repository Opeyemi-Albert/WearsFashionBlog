package com.example.wearsfashionblog.services;

import com.example.wearsfashionblog.dtos.commentdtos.CreateCommentDto;
import com.example.wearsfashionblog.exceptions.NotFoundException;
import com.example.wearsfashionblog.exceptions.NotNullException;
import com.example.wearsfashionblog.util.ApiResponse;
import com.example.wearsfashionblog.models.Comment;

import java.util.List;

public interface CommentService {
    ApiResponse<Comment> createComment(CreateCommentDto createCommentDto, Long postId) throws NotNullException, NotFoundException;
    ApiResponse<List<Comment>> findAllPostComments(Long postId) throws NotFoundException;
    ApiResponse<Comment> updateComment(Long commentId, Comment comment) throws NotNullException;
    ApiResponse<String> deleteCommentById(Long commentId);
}