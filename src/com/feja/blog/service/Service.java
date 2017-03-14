package com.feja.blog.service;

import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.feja.blog.model.Article;
import com.feja.blog.model.ArticleType;
import com.feja.blog.model.Config;
import com.feja.blog.model.ConfigWithBLOBs;
import com.feja.blog.model.Recommend;
import com.feja.blog.model.Type;

public interface Service {
	
	public Log logger = LogFactory.getLog(Service.class);
	
	//总括
	ConfigWithBLOBs getConfig(int configId);
	Article getArticle(int articleId);
	Type getType(int typeId);
	Type getTypeByTypeString(String type);
	ArticleType getArticleType(int articleTypeId);
	Recommend getRecommand(int recommandId);
	
	//展示页面
	ArrayList<Article> getAllRecommandArticles();
	ArrayList<Article> getArticlesByType(String type);
	ArrayList<Article> getArticlesByType(int id);
	ArrayList<Article> getArticlesByDate(Date date);
	ArrayList<String[]> getAllTypesSorted();
	ArrayList<String[]> getAllDatesSorted();
	
	//登陆验证
	boolean validate(String username, String password);
	
	//博客管理
		//文章管理
	int addArticle(Article article);
	boolean editArticle(Article article);
	boolean saveArticleAsDraft(Article article);
	boolean recycleArticle(int articleId, int isDelete);
	int addTypeToArticle(int articleId, String type);
	int addTypeToArticle(int articleId, int typeId);
	int removeTypeFromArticle(int articleId, int typeId);
	boolean updateArticleVisible(int articleId, boolean visible);
	boolean updateArticleToRecommend(int articleId, boolean recommend);
	boolean isArticleRecommend(int articleId);
		//类别管理
	int addType(String type);
	boolean editType(Type type);
	boolean deleteType(int typeId);
	boolean updateTypeVisible(int typeId, boolean visible);
		//博客配置管理
	boolean updateBlogName(String blogName);
	boolean updateBlogDescribe(String describe);
	boolean updateCopyRight(String copyright);
		//草稿箱管理
		//回收站管理
	boolean deleteArticle(int articleId, boolean recover);
	boolean destroyArticle(int articleId);
		//写文章页面
	
	//其他
	ArrayList<Article> getAllArticles();
}
