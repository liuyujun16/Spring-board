package com.example.first_project.service;

import com.example.first_project.Entity.Article;
import com.example.first_project.dto.ArticleForm;
import com.example.first_project.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class ArticleService {
    @Autowired
    private ArticleRepository repo;

    public List<Article> getAllArticle() {
        return repo.findAll();
    }

    public Article getCertainArticle(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Article createArticle(ArticleForm dto) {
        Article article = dto.toEntity();
        log.info(article.toString());
        if (article.getId() != null)
        {
            log.info("실패? id가 존재함?");
            return null;
        }
        return repo.save(article);

    }

    public Article updateArticle(ArticleForm dto, Long id) {
        Article article = dto.toEntity();
        Article target = repo.findById(id).orElse(null);
        if (target == null || id != article.getId()){
            return null;
        }
        target.update(article);
        return repo.save(target);

    }

    public Article deleteArticle(Long id) {
        Article article = repo.findById(id).orElse(null);
        if (article == null){
            return null;
        }
        repo.delete(article);
        return article;

    }
    @Transactional
    public List<Article> createMultipleArticles(List<ArticleForm> dtos) {
        //List<Article> articleList = dtos.stream().map(ArticleForm::toEntity).toList();
        List<Article> articleList = dtos.stream()
                .map(ArticleForm::toEntity)
                .collect(Collectors.toList());
        // entity 묶음을 DB로 저장
        articleList
                .forEach(article -> repo.save(article));
        // 강제 예외 발생
        repo.findById(-1L).orElseThrow(
                () -> new IllegalArgumentException("결제 실패!")
        );
        // 결과값 반환
        return articleList;

    }
}
