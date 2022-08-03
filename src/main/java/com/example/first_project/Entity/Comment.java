package com.example.first_project.Entity;


import com.example.first_project.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Article_id")
    private Article article;

    @Column
    private String body;
    @Column
    private String nickname;


    public static Comment createComment(CommentDto dto,Article article) {
        if(dto.getId() != null){
            throw new IllegalArgumentException("it shoudn't have it's own id");
        }
        if(article.getId() != dto.getArticle_id()){
            throw new IllegalArgumentException("article id doesn't exist");
        }
        return new Comment(dto.getId(),article,dto.getBody(), dto.getNickname());
    }





    public void patchComment(CommentDto dto,Long comment_id) {
        if (comment_id != this.id){
            throw new IllegalArgumentException("there's no id");
        }
        if (dto.getBody() != this.body){
            this.body = dto.getBody();
        }
        if(dto.getNickname() != this.getNickname()){
            this.nickname = dto.getNickname();
        }

    }
}
