package com.sdse.article_service.articles.service;

import com.sdse.article_service.articles.entity.Article;
import com.sdse.article_service.articles.entity.ArticleRequest;
import com.sdse.article_service.articles.repository.ArticleRepository;
import com.sdse.article_service.util.ResourceNotFoundException;
import org.hibernate.type.LocalDateType;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class ArticleServiceImpl implements ArticleService{

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article create(ArticleRequest article) {
        Article newArticle = new Article();
        newArticle.setTitle(article.getTitle());
        newArticle.setContent(article.getContent());
        newArticle.setCreatedAt(LocalDateTime.now());
        newArticle.setUpdatedAt(LocalDateTime.now());
        return articleRepository.save(newArticle);
    }

    @Override
    public Article get(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Article with id: " + id + " not exist"));
    }
}
