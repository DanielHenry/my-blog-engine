package com.danielhenry.myblogengine.controller;

import java.util.List;

import com.danielhenry.myblogengine.entity.Article;
import com.danielhenry.myblogengine.repository.ArticleRepository;
import com.danielhenry.myblogengine.exception.ArticleNotFoundException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ArticleController {

	private final ArticleRepository repository;

	ArticleController(ArticleRepository repository) {
		this.repository = repository;
	}

	// Aggregate root

	@GetMapping("/articles")
	List<Article> all() {
		return repository.findAll();
	}

	@PostMapping("/articles")
	Article newArticle(@RequestBody Article newArticle) {
		return repository.save(newArticle);
	}

	// Single item

	@GetMapping("/articles/{id}")
	Article one(@PathVariable Long id) {

		return repository.findById(id)
			.orElseThrow(() -> new ArticleNotFoundException(id));
	}

	@PutMapping("/articles/{id}")
	Article replaceArticle(@RequestBody Article newArticle, @PathVariable Long id) {

		return repository.findById(id)
			.map(article -> {
				article.setTitle(newArticle.getTitle());
				article.setContent(newArticle.getContent());
				return repository.save(article);
			})
			.orElseGet(() -> {
				newArticle.setId(id);
				return repository.save(newArticle);
			});
	}

	@DeleteMapping("/articles/{id}")
	void deleteArticle(@PathVariable Long id) {
		repository.deleteById(id);
	}
}