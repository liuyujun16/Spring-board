package com.example.first_project.controller;


import com.example.first_project.Entity.Article;
import com.example.first_project.dto.ArticleForm;
import com.example.first_project.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
public class ArticleController {
    @Autowired
    ArticleRepository repo;
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "/articles/new";
    }

    @PostMapping("articles/create")
    public String createArticle(ArticleForm form){
        //System.out.println(form.toString());
        log.info(form.toString());
        Article article = form.toEntity();
        //System.out.println(article.toString());
        log.info(article.toString());
        Article test = repo.save(article);
        //System.out.println(test.toString());
        log.info(test.toString());
        return "redirect:/articles/"+test.getId();
    }

    @GetMapping("articles/{id}")
    public String findbyId(@PathVariable Long id, Model model){
        Article article = repo.findById(id).orElse(null);
        model.addAttribute("article",article);
        return "/articles/show";
    }

    @GetMapping("articles/")
    public String allArticle(Model model){
        List<Article> ArticleList = repo.findAll();
        model.addAttribute("ArticleList",ArticleList);
        return "/articles/index";
    }


    @GetMapping("articles/edit/{id}")
    public String editArticle(@PathVariable Long id,Model model){
        Article article = repo.findById(id).orElse(null);
        model.addAttribute("article",article);
        return "/articles/edit";
    }


    @PostMapping("articles/update")
    public String updateArticle(ArticleForm form){
       Article article =  form.toEntity();
       Article target  = repo.findById(article.getId()).orElse(null);
       if (target != null){
           repo.save(article);
       }
       return "redirect:/articles/" + article.getId();
    }

    @GetMapping("articles/delete/{id}")
    public String deleteArticle(@PathVariable Long id, RedirectAttributes rttr){
        Article article = repo.findById(id).orElse(null);
        if (article != null){
            repo.delete(article);
            rttr.addFlashAttribute("msg","delete success!");
        }
        return "redirect:/articles/";
    }
}
