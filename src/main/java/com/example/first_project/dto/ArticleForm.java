package com.example.first_project.dto;

import com.example.first_project.Entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
public class ArticleForm {





    public Article toEntity(){

        return new Article(id,title,content);
    }

    private Long id;
    private String title;
    private String content;

}
