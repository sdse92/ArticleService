package com.sdse.article_service.articles.controller;

import com.sdse.article_service.articles.entity.Article;
import com.sdse.article_service.articles.entity.ArticleRequest;
import com.sdse.article_service.articles.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/articles")
public class ArticleMvcController implements ArticleController{

    ArticleService articleService;

    public ArticleMvcController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    @PostMapping("")
    public Article create(@RequestBody ArticleRequest article) {
        return articleService.create(article);
    }

    @Override
    @GetMapping("/{id}")
    public String get(@PathVariable("id") Long id, Model model) {
        Article article = articleService.get(id);
        model.addAttribute("title", article.getTitle());
        model.addAttribute("content", article.getContent());
        return "article";
    }
}
