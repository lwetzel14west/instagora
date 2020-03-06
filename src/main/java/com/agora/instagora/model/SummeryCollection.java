package com.agora.instagora.model;

import java.util.ArrayList;
import java.util.List;

public class SummeryCollection {
	List<TextScraper> header1;
	List<TextScraper> header2;
	List<String> imgURL;



	public SummeryCollection() {
		header1 = new ArrayList();
		header2 = new ArrayList();
	}

	public List<TextScraper> getHeader1() {
		return header1;
	}
	public void setHeader1(List<TextScraper> header1) {
		this.header1 = header1;
	}
	public List<TextScraper> getHeader2() {
		return header2;
	}
	public void setHeader2(List<TextScraper> header2) {
		this.header2 = header2;
	}
	public List<String> getImgURL() {
		return imgURL;
	}

	public void setImgURL(List<String> imgURL) {
		this.imgURL = imgURL;
	}
}
