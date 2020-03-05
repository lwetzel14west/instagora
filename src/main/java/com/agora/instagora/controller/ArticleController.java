package com.agora.instagora.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.agora.instagora.entity.Article;
import com.agora.instagora.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ArticleController {

	@Autowired
    private ArticleRepository repository;
	
	@GetMapping("/article/{id}")
	public String getArticle(@PathVariable long id) {
		Article article = repository.findById(id).orElse(null);
		return (article != null? article.getJson():null);
	}

	@PutMapping("/article/{id}")
	public String updateArticle(@PathVariable long id, @RequestBody String newArticle) {
		Article article = repository.findById(id).orElse(null);
		if(article != null) {
			article.setJson(newArticle);
			repository.save(article);
			return article.getJson();
		} else {
			return null;
		}

	}

	@PostMapping("/article")
	public Article createArticle(@RequestBody String newArticle) {
		
		return repository.save(new Article(newArticle));
	}

	@DeleteMapping("/article/{id}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
