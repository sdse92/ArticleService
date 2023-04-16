package com.sdse.article_service.articles.service;

import com.sdse.article_service.articles.entity.Article;
import com.sdse.article_service.articles.entity.ArticleRequest;

public interface ArticleService {

    public Article create(ArticleRequest article);

    public Article get(Long id);

}
