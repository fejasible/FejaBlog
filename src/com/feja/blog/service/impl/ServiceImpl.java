package com.feja.blog.service.impl;

import java.util.ArrayList;
import java.util.Date;

import com.feja.blog.model.Article;
import com.feja.blog.model.ArticleType;
import com.feja.blog.model.Config;
import com.feja.blog.model.Recommand;
import com.feja.blog.model.Type;
import com.feja.blog.service.Service;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{

	@Override
	public Config getConfig(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article getArticle(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getType(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleType getArticleType(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Recommand getRecommand(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Article> getAllRecommandArticles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Article> getArticlesByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Article> getArticlesByType(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Article> getArticlesByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String[]> getAllTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String[]> getAllDates() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
