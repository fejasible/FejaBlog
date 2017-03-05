package com.feja.blog.service;

import java.util.ArrayList;
import java.util.Date;

import com.feja.blog.model.Article;
import com.feja.blog.model.ArticleType;
import com.feja.blog.model.Config;
import com.feja.blog.model.ConfigWithBLOBs;
import com.feja.blog.model.Recommend;
import com.feja.blog.model.Type;

public interface Service {
	//总括
	ConfigWithBLOBs getConfig(int configId);
	Article getArticle(int articleId);
	Type getType(int typeId);
	ArticleType getArticleType(int articleTypeId);
	Recommend getRecommand(int recommandId);
	
	//展示页面
	ArrayList<Article> getAllRecommandArticles();
	ArrayList<Article> getArticlesByType(String type);
	ArrayList<Article> getArticlesByType(int id);
	ArrayList<Article> getArticlesByDate(Date date);
	ArrayList<String[]> getAllTypes();
	ArrayList<String[]> getAllDates();
	
	//登陆验证
	boolean validate(String username, String password);
	
	//博客管理
		//文章管理
	int addArticle(Article article);
	boolean editArticle(Article article);
	boolean saveArticle(Article article);
	boolean recycleArticle(int articleId);
	boolean addTypeToArticle(int articleId, String type);
	boolean addTypeToArticle(int articleId, int typeId);
	boolean updateArticleVisible(Article article, boolean visible);
	boolean updateArticleToRecommand(Article article, boolean recommand);
		//类别管理
	boolean addType(String type);
	boolean editType(Type type);
	boolean deleteType(Type type);
	boolean updateTypeVisible(Type type, boolean visible);
		//博客配置管理
	boolean updateBlogName(String blogName);
	boolean updateBlogDescribe(String describe);
	boolean updateCopyRight(String copyright);
		//草稿箱管理
		//回收站管理
	boolean recoverArticle(Article article);
	boolean destroyArticle(int articleId);
		//写文章页面
	
	
	
	
}
