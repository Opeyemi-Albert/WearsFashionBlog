package com.example.wearsfashionblog.services;

import com.example.wearsfashionblog.exceptions.NotFoundException;
import com.example.wearsfashionblog.exceptions.UnauthorizedException;
import com.example.wearsfashionblog.util.ApiResponse;
import com.example.wearsfashionblog.models.Like;

public interface LikeService {
    ApiResponse<Like> likeAPost(Long postId) throws UnauthorizedException;
    ApiResponse<String> unLikeAPost(Long postId) throws UnauthorizedException, NotFoundException;
    ApiResponse<Like> likeAComment(Long postId) throws UnauthorizedException;

    ApiResponse<String> unLikeAComment(Long commentId) throws UnauthorizedException, NotFoundException;
}
