package com.agora.instagora.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Service;

import com.agora.instagora.model.SummeryCollection;
import com.agora.instagora.model.TextScraper;


@Service
public class StoryContentGenerator {

	public SummeryCollection contentExtractor(String json) {
		JsonParser springParser = JsonParserFactory.getJsonParser();
		Map<String,Object> article = springParser.parseMap(json);
		String title = (String) article.get("title");
		Map<String,Object> content = (Map<String, Object>) article.get("content");
		List<Object> blocks = (List<Object>) content.get("blocks");
		Map<String,Object> entityMap = (Map<String,Object>) content.get("entityMap");
		SummeryCollection sc = grabText(blocks);
		sc.setImgURL(grabMedia(entityMap));
		return sc;
	}

	public SummeryCollection grabText(List<Object> blocks) {
		SummeryCollection sc = new SummeryCollection();
		for(Object blockObj: blocks) {
			Map<String,Object> block = (Map<String, Object>) blockObj;
			String type = (String) block.get("type");
			if (type.equals("header-one")) {
				String h1text = (String) block.get("text");
				TextScraper tsh1 = new TextScraper();
				tsh1.setHeader(h1text);
				sc.getHeader1().add(tsh1);
			} else if (type.equals("header-two")) {
				String h2text = (String) block.get("text");
				TextScraper tsh2 = new TextScraper();
				tsh2.setHeader(h2text);
				sc.getHeader2().add(tsh2);
			} else if (type.equals("unstyled")) {
				String value = (String) block.get("text");
				if (!sc.getHeader1().isEmpty()) {
					sc.getHeader1().get(sc.getHeader1().size()-1).setArticleText(value);
				}
				if (!sc.getHeader2().isEmpty()) {
					sc.getHeader2().get(sc.getHeader2().size()-1).setArticleText(value);
				}
			}
		}
		return sc;
	}

	public List<String> grabMedia(Map<String,Object> entityMaps) {
		List<String> imageUrls = new ArrayList<String>();
		for(int i = 0; entityMaps.containsKey(i);i++) {
			Map<String,Object> enitity = (Map<String, Object>) entityMaps.get(i);
			if(enitity.get("type").equals("IMAGE")) {
				Map<String,Object> data = (Map<String, Object>) enitity.get("data");
				imageUrls.add((String) data.get("src"));
			}
				
			
		}
		return imageUrls;
	}
}	
