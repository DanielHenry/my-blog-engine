package com.danielhenry.myblogengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielhenry.myblogengine.entity.Article;

interface ArticleRepository extends JpaRepository<Article, Long> {

}