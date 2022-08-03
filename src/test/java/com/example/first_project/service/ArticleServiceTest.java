package com.example.first_project.service;

import com.example.first_project.Entity.Article;
import com.example.first_project.dto.ArticleForm;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ArticleServiceTest {
    @Autowired
    ArticleService service;
//    @Test
//    @DisplayName("get all article")
//    void getAllArticle() {
//        Article a  = new Article(1L,"aaaa","1111");
//        Article b  = new Article(2L,"bbbb","2222");
//        Article c  = new Article(3L,"cccc","3333");
//        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));
//
//        log.info(expected.toString());
//        List<Article> articles = service.getAllArticle();
//        assertEquals(expected.toString(),articles.toString());
//
//    }


    @Test
    @DisplayName("get article success")
    void getCertainArticle_success() {
        Article expected = new Article(1L,"aaaa","1111");

        Article article = service.getCertainArticle(1L);

        assertEquals(expected.toString(),article.toString());

    }


    @Test
    @DisplayName("get Article fail id's not exist")
    void getCertainArticle_fail() {
        Article expected = null;

        Article article = service.getCertainArticle(-1L);

        assertEquals(expected,article);

    }

    @Transactional
    @Test
    @DisplayName("create success")
    void create_success() {
        // 예상
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(7L, title, content);
        // 실제
        Article article = service.createArticle(dto);
        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @DisplayName("create fail id included")
    void create_fail() {
        // 예상
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(7L, title, content);
        Article expected = null;
        // 실제
        Article article = service.createArticle(dto);
        // 비교
        assertEquals(expected, article);
    }



}