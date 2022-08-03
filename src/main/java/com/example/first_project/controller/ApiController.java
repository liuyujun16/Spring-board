package com.example.first_project.controller;


import com.example.first_project.Entity.Article;
import com.example.first_project.dto.ArticleForm;
import com.example.first_project.repository.ArticleRepository;
import com.example.first_project.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ApiController {
    @Autowired
    ArticleService service;
    @GetMapping("/api/articles")
    public List<Article> getArticles(){
        return service.getAllArticle();
    }
    @GetMapping("/api/articles/{id}")
    public Article getCertainArticle(@PathVariable Long id){
        return service.getCertainArticle(id);
    }
    @PostMapping("/api/articles")
    public ResponseEntity<Article> createArticle(@RequestBody ArticleForm dto){
        Article article = service.createArticle(dto);
        return (article != null) ? ResponseEntity.status(HttpStatus.OK).body(article) : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@RequestBody ArticleForm dto, @PathVariable Long id){
        Article article = service.updateArticle(dto,id);
        return  (article == null ) ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null):ResponseEntity.status(HttpStatus.OK).body(article);
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> deleteArticle(@PathVariable Long id){
        Article article = service.deleteArticle(id);
        return (article == null) ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null) : ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("/api/transaction-test")
    public ResponseEntity<List<Article>> createMultipleArticles(@RequestBody List<ArticleForm> dtos){
        List<Article> articleList = service.createMultipleArticles(dtos);
        return (articleList == null) ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null) : ResponseEntity.status(HttpStatus.OK).body(articleList);
    }
}
