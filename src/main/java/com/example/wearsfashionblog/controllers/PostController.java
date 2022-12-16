package com.example.wearsfashionblog.controllers;

import com.example.wearsfashionblog.dtos.postdtos.CreatePostDto;
import com.example.wearsfashionblog.exceptions.NotFoundException;
import com.example.wearsfashionblog.exceptions.NotNullException;
import com.example.wearsfashionblog.exceptions.UnauthorizedException;
import com.example.wearsfashionblog.util.ApiResponse;
import com.example.wearsfashionblog.models.Post;
import com.example.wearsfashionblog.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/api/v1/fashion-blog")
public class PostController {
    private final PostService postService;

    @PostMapping("/blogger/create-post")
    public ResponseEntity<ApiResponse<Post>> createPost(@RequestBody CreatePostDto createPostDto) throws UnauthorizedException, NotNullException {
        ApiResponse<Post> post =  postService.createPost(createPostDto);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @GetMapping("/view-post/{postId}")
    public ResponseEntity<ApiResponse<Post>> viewPostById(@PathVariable Long postId) throws NotFoundException, UnauthorizedException {
        ApiResponse<Post> post = postService.findPostById(postId);
        return new ResponseEntity<>(post, HttpStatus.FOUND);
    }

    @GetMapping("/all-posts")
    public ResponseEntity<ApiResponse<List<Post>>> viewAllPosts() throws NotFoundException, UnauthorizedException {
        ApiResponse<List<Post>> allPosts = postService.findAllPosts();
        return new ResponseEntity<>(allPosts, HttpStatus.ACCEPTED);
    }

    @PutMapping("/blogger/update-post/{postId}")
    public ResponseEntity<ApiResponse<Post>> updatePost(@PathVariable Long postId, @RequestBody CreatePostDto createPostDto) throws NotFoundException, UnauthorizedException {
        ApiResponse<Post> post = postService.updatePostById(postId, createPostDto);
        return new ResponseEntity<>(post,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/blogger/delete-post/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId) throws UnauthorizedException, NotFoundException {
        postService.deletePostById(postId);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.ACCEPTED);
    }
}
