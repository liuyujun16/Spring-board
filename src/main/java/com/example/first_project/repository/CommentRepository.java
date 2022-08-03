package com.example.first_project.repository;

import com.example.first_project.Entity.Comment;
import com.example.first_project.dto.CommentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Query(value =
            "SELECT * " +
                    "FROM comment " +
                    "WHERE article_id = :articleId",
            nativeQuery = true)
    List<Comment> findByArticleId(@Param("articleId") Long articleId);

    @Query(value =
            "SELECT * FROM comment WHERE nickname = : nickname",nativeQuery = true
    )
    List<Comment> findByNickname(@Param("nickname") String nickname);

}
