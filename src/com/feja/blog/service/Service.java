package com.feja.blog.service;

import java.util.ArrayList;
import java.util.Date;

import com.feja.blog.model.Article;
import com.feja.blog.model.ArticleType;
import com.feja.blog.model.Config;
import com.feja.blog.model.Recommand;
import com.feja.blog.model.Type;

public interface Service {
	
	Config getConfig(int id);
	Article getArticle(int id);
	Type getType(int id);
	ArticleType getArticleType(int id);
	Recommand getRecommand(int id);
	
	ArrayList<Article> getAllRecommandArticles();
	ArrayList<Article> getArticlesByType(String type);
	ArrayList<Article> getArticlesByType(int id);
	ArrayList<Article> getArticlesByDate(Date date);
	
	ArrayList<String[]> getAllTypes();
	ArrayList<String[]> getAllDates();
	
	
}
