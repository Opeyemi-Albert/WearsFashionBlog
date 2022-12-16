package com.example.wearsfashionblog.controllers;

import com.example.wearsfashionblog.dtos.commentdtos.CreateCommentDto;
import com.example.wearsfashionblog.exceptions.NotFoundException;
import com.example.wearsfashionblog.exceptions.NotNullException;
import com.example.wearsfashionblog.util.ApiResponse;
import com.example.wearsfashionblog.models.Comment;
import com.example.wearsfashionblog.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fashion-blog/post")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/create-comment/{postId}")
    public ResponseEntity<ApiResponse<Comment>> createNewComment(@PathVariable Long postId, @RequestBody CreateCommentDto createCommentDto) throws NotNullException, NotFoundException {
        ApiResponse<Comment> comment = commentService.createComment(createCommentDto,postId);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @GetMapping("/all-comments/{postId}")
    public ResponseEntity<ApiResponse<List<Comment>>> getAllPostComments(@PathVariable Long postId) throws NotFoundException {
        ApiResponse<List<Comment>> comments = commentService.findAllPostComments(postId);
        return new ResponseEntity<>(comments, HttpStatus.FOUND);
    }

    @PutMapping("/update-comment/{commentId}")
    public ResponseEntity<ApiResponse<Comment>> editComment(@PathVariable Long commentId, @RequestBody Comment newComment) throws NotNullException {
        ApiResponse<Comment> comment = commentService.updateComment(commentId, newComment);
        return new ResponseEntity<>(comment,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-comment/{commentId}")
    public ResponseEntity<ApiResponse<String>> deleteComment(@PathVariable Long commentId){
        ApiResponse<String> response = commentService.deleteCommentById(commentId);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
