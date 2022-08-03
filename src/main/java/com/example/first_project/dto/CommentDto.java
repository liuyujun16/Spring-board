package com.example.first_project.dto;


import com.example.first_project.Entity.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
public class CommentDto {
//    public Comment toEntity(){
//
//    }
    private Long id;
    private String body;
    private String nickname;
    private Long article_id;

    public static CommentDto toDto(Comment comment) {
        return new CommentDto(comment.getId(), comment.getBody(),comment.getNickname(),comment.getArticle().getId());

    }

}
