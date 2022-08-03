package com.example.first_project.controller;

import com.example.first_project.Entity.Comment;
import com.example.first_project.dto.CommentDto;
import com.example.first_project.repository.CommentRepository;
import com.example.first_project.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CommentApiController {
    @Autowired
    CommentService service;

    @GetMapping("/api/articles/comments/{article_id}")
    public ResponseEntity<List<CommentDto>> GetComment(@PathVariable Long article_id){
        List<CommentDto> commentDtos = service.getComment(article_id);
        return (commentDtos != null) ? ResponseEntity.status(HttpStatus.OK).body(commentDtos) : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PostMapping("api/articles/comments/{article_id}")
    public ResponseEntity<CommentDto> PostComment(@RequestBody CommentDto dto,@PathVariable Long article_id){
        log.info("무지"+dto.getBody());
        CommentDto commentDto = service.postComment(dto,article_id);
        return (commentDto != null)? ResponseEntity.status(HttpStatus.OK).body(commentDto) : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PatchMapping("api/comments/{comment_id}")
    public ResponseEntity<CommentDto> PatchComment(@RequestBody CommentDto dto,@PathVariable Long comment_id){
        CommentDto commentDto = service.patchComment(dto,comment_id);
        return (commentDto != null)? ResponseEntity.status(HttpStatus.OK).body(commentDto) : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @DeleteMapping("api/comments/{comment_id}")
    public ResponseEntity<CommentDto> DeleteComment(@PathVariable Long comment_id){
        CommentDto commentDto = service.deleteComment(comment_id);
        return (commentDto != null)? ResponseEntity.status(HttpStatus.OK).body(commentDto) : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

    }
}
