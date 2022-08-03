package com.example.first_project.service;

import com.example.first_project.Entity.Article;
import com.example.first_project.Entity.Comment;
import com.example.first_project.dto.CommentDto;
import com.example.first_project.repository.ArticleRepository;
import com.example.first_project.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommentService {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommentRepository commentRepository;

    public List<CommentDto> getComment(Long article_id) {
        List<Comment> comments = commentRepository.findByArticleId(article_id);
        return comments.stream().map(CommentDto::toDto).collect(Collectors.toList());
    }
    @Transactional
    public CommentDto postComment(CommentDto dto,Long article_id) {
        Article article  = articleRepository.findById(article_id).orElseThrow(()->new IllegalArgumentException("there's no article to post"));
        Comment comment = Comment.createComment(dto,article);
        log.info("짜증남"+comment.getBody());
        Comment created = commentRepository.save(comment);
        return CommentDto.toDto(created);
    }
    @Transactional
    public CommentDto patchComment(CommentDto dto, Long comment_id) {
        Comment comment  = commentRepository.findById(comment_id).orElseThrow(()->new IllegalArgumentException("there's no article to update"));
        log.info(dto.toString()+"여기다 여채");
        comment.patchComment(dto,comment_id);
        Comment update = commentRepository.save(comment);
        return CommentDto.toDto(update);
    }
    @Transactional
    public CommentDto deleteComment(Long comment_id) {
        Comment comment = commentRepository.findById(comment_id).orElseThrow(()->new IllegalArgumentException("there's no article to delete"));
        commentRepository.delete(comment);
        return CommentDto.toDto(comment);
    }
}
