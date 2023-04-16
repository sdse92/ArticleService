package com.sdse.article_service.articles.controller;

import com.sdse.article_service.articles.entity.Article;
import com.sdse.article_service.articles.entity.ArticleRequest;
import org.springframework.ui.Model;

public interface ArticleController {

    public Article create(ArticleRequest article);

    public String get(Long id, Model model);
}
