package com.example.first_project.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;
    @Column
    private String content;


    public void update(Article article) {
        if (article.getContent() != null)
            this.content = article.getContent();
        if (article.getTitle() != null)
            this.title = article.getTitle();
    }
}
