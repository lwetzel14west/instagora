package com.agora.instagora.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.agora.instagora.entity.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {

	public Optional<Article> findById(Long arg0);
	public Article save(Article arg0);
	void deleteById(Long arg0);
}
