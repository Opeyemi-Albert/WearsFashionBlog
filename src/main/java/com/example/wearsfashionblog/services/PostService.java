package com.example.wearsfashionblog.services;
import com.example.wearsfashionblog.dtos.postdtos.CreatePostDto;
import com.example.wearsfashionblog.exceptions.NotFoundException;
import com.example.wearsfashionblog.exceptions.NotNullException;
import com.example.wearsfashionblog.exceptions.UnauthorizedException;
import com.example.wearsfashionblog.util.ApiResponse;
import com.example.wearsfashionblog.models.Post;

import java.util.List;

public interface PostService {
    ApiResponse<Post> createPost(CreatePostDto createPostDto) throws NotNullException, UnauthorizedException;
    ApiResponse<Post> findPostById(Long postId) throws NotFoundException, UnauthorizedException;
    ApiResponse<List<Post>> findAllPosts() throws NotFoundException, UnauthorizedException;
    ApiResponse<Post> updatePostById(Long postId, CreatePostDto createPostDto) throws NotFoundException, UnauthorizedException;
    void deletePostById(Long postId) throws UnauthorizedException, NotFoundException;
}
