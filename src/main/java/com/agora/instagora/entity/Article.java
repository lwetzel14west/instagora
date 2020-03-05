package com.agora.instagora.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Article {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String json;

	public Article() {
    }

    public Article(String json) {
        this.json = json;
    }

    public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

}
