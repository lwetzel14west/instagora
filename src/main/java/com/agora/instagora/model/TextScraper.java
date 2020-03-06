package com.agora.instagora.model;

public class TextScraper {

	String header;
	StringBuilder articleText;

	public TextScraper() {
		articleText = new StringBuilder();
	}

	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getArticleText() {
		return articleText.toString();
	}

	public void setArticleText(String articleText) {
		this.articleText.append(articleText);
	}

}
